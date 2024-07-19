package learn.solarfarm.ui;

import learn.solarfarm.data.DataAccessException;
import learn.solarfarm.domain.SolarPanelResult;
import learn.solarfarm.domain.SolarPanelService;
import learn.solarfarm.models.SolarPanel;

import java.util.List;

public class Controller {
    private final View view;
    private final SolarPanelService service;

    public Controller(View view, SolarPanelService service) {
        this.view = view;
        this.service = service;
    }

    public void run() {
        view.displayHeader("Welcome to Solar Farm");
        try {
            runApp();
        } catch (DataAccessException ex) {
            view.displayErrors(List.of(ex.getMessage()));
        }
        view.displayMessage("Goodbye!");
    }

    private void runApp() throws DataAccessException {
        for (int option = view.chooseMenuOption();
             option > 0;
             option = view.chooseMenuOption()) {

            switch (option) {
                case 1:
                    findSolarPanelsBySection();
                    break;
                case 2:
                    addSolarPanel();
                    break;
                case 3:
                    updateSolarPanel();
                    break;
                case 4:
                    deleteSolarPanel();
                    break;
            }
        }
    }

    private void findSolarPanelsBySection() throws DataAccessException {
        view.displayHeader("Find Panels by Section");
        view.listSections(service.findAllSections());
        String section = view.getSection();
        List<SolarPanel> solarPanels = service.findBySection(section);
        if (solarPanels.isEmpty()) {
            view.displayMessage("There are no panels in this section.");
        } else {
            view.displaySolarPanels(section, solarPanels);
        }
    }

    private void addSolarPanel() throws DataAccessException {
        SolarPanel solarPanel = view.addSolarPanel();
        SolarPanelResult result = service.create(solarPanel);
        if (result.isSuccess()) {
            view.displayMessage("[Success]%nPanel %s added.", result.getSolarPanel().getKey());
        } else {
            view.displayErrors(result.getErrorMessages());
        }
    }

    private void updateSolarPanel() throws DataAccessException {
        view.displayHeader("Update a Panel");
        SolarPanel solarPanel = findSolarPanel();
        if (solarPanel == null) return;

        solarPanel = view.update(solarPanel);
        SolarPanelResult result = service.update(solarPanel);

        if (result.isSuccess())
            view.displaySuccess(result.getSolarPanel(), "updated");
        else
            view.displayErrors(result.getErrorMessages());
    }

    private void deleteSolarPanel() throws DataAccessException {
        view.displayHeader("Delete a Panel");
        SolarPanel solarPanel = findSolarPanel();
        if (solarPanel == null) return;

        SolarPanelResult result = service.deleteById(solarPanel.getId());

        if (result.isSuccess())
            view.displaySuccess(solarPanel, "deleted");
        else
            view.displayErrors(result.getErrorMessages());
    }

    private SolarPanel findSolarPanel() throws DataAccessException {
        String section = view.getSection();
        int row = view.getRow();
        int column = view.getColumn();
        SolarPanel solarPanel = service.findByKey(section, row, column);
        if (solarPanel == null)
            view.displayMessage("SolarPanel %s-%d-%d not found.", section, row, column);
        return solarPanel;
    }

}
