package learn.solarfarm.domain;

import learn.solarfarm.data.SolarPanelRepository;
import learn.solarfarm.models.SolarPanel;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@Service
public class SolarPanelService {
    public final static int MAX_ROW_COLUMN = 250;

    private final SolarPanelRepository repository;

    public SolarPanelService(SolarPanelRepository repository) {
        this.repository = repository;
    }

    public static int getMaxInstallationYear() {
        return Year.now().getValue();
    }

    public List<SolarPanel> findBySection(String section) {
        return repository.findBySection(section);
    }

    public SolarPanel findByKey(String section, int row, int column)  {
        return repository.findByKey(section, row, column);
    }

    public SolarPanel findById(int solarPanelId)  {
        return repository.findById(solarPanelId);
    }

    public List<String> findAllSections() {
        ArrayList<String> result = new ArrayList<>();
        for (SolarPanel solarPanel : repository.findAll())
            if (!result.contains(solarPanel.getSection()))
                result.add(solarPanel.getSection());
        return result;
    }

    public SolarPanelResult create(SolarPanel solarPanel) {
        SolarPanelResult result = validate(solarPanel);

        if (solarPanel != null && solarPanel.getId() > 0) {
            result.addErrorMessage("SolarPanel `id` should not be set.");
        }

        if (result.isSuccess()) {
            solarPanel = repository.create(solarPanel);
            result.setSolarPanel(solarPanel);
        }

        return result;
    }

    public SolarPanelResult update(SolarPanel solarPanel)  {
        SolarPanelResult result = validateInputs(solarPanel);
        if (solarPanel == null) return result;

        if (solarPanel.getId() <= 0) {
            result.addErrorMessage("SolarPanel `id` is required.");
            return result;
        }

        if (repository.findById(solarPanel.getId()) == null) {
            result.addErrorMessage("SolarPanel with Id " + solarPanel.getId() + " not found.");
            return result;
        }

        if (hasDuplicateKey(solarPanel))
            result.addErrorMessage("SolarPanel `section`, `row`, and `column` must be unique.");

        if (result.isSuccess()) {
            if (repository.update(solarPanel))
                result.setSolarPanel(solarPanel);
            else
                result.addErrorMessage("SolarPanel " + solarPanel.getId() + " not found.");
        }

        return result;
    }

    public SolarPanelResult deleteById(int solarPanelId) {
        SolarPanelResult result = new SolarPanelResult();
        if (!repository.deleteById(solarPanelId))
            result.addErrorMessage("SolarPanel " + solarPanelId + " not found.");
        return result;
    }

    private boolean hasDuplicateKey(SolarPanel solarPanel)  {
        SolarPanel withMatchingKey = repository.findByKey(
                solarPanel.getSection(),
                solarPanel.getRow(),
                solarPanel.getColumn());
        return withMatchingKey != null && solarPanel.getId() != withMatchingKey.getId();
    }

    private SolarPanelResult validateInputs(SolarPanel solarPanel) {
        SolarPanelResult result = new SolarPanelResult();

        if (solarPanel == null) {
            result.addErrorMessage("SolarPanel cannot be null.");
            return result;
        }

        if (solarPanel.getSection() == null || solarPanel.getSection().isBlank()) {
            result.addErrorMessage("SolarPanel `section` is required.");
        }

        if (solarPanel.getRow() < 1 || solarPanel.getRow() >= MAX_ROW_COLUMN) {
            result.addErrorMessage("SolarPanel `row` must be a positive number less than or equal to %s.", MAX_ROW_COLUMN);
        }

        if (solarPanel.getColumn() < 1 || solarPanel.getColumn() >= MAX_ROW_COLUMN) {
            result.addErrorMessage("SolarPanel `column` must be a positive number less than or equal to %s.", MAX_ROW_COLUMN);
        }

        if (solarPanel.getYearInstalled() > getMaxInstallationYear()) {
            result.addErrorMessage("SolarPanel `yearInstalled` must be in the past.");
        }

        if (solarPanel.getMaterial() == null) {
            result.addErrorMessage("SolarPanel `material` is required.");
        }

        return result;
    }

    private SolarPanelResult validate(SolarPanel solarPanel) {
        SolarPanelResult result = validateInputs(solarPanel);

        // If everything is successful so far, then check if the combined values
        // of **Section**, **Row**, and **Column** are unique (i.e. the natural key).
        if (result.isSuccess()) {
            SolarPanel existingSolarPanel = repository.findByKey(solarPanel.getSection(),
                    solarPanel.getRow(), solarPanel.getColumn());

            // If an existing panel was found for the provided **Section**, **Row**, and **Column** values
            // add an error message if the id values don't match (i.e. they're not the same record).
            if (existingSolarPanel != null && existingSolarPanel.getId() != solarPanel.getId()) {
                result.addErrorMessage("SolarPanel `section`, `row`, and `column` must be unique.");
            }
        }

        return result;
    }
}
