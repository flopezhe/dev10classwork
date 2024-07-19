package learn.solarfarm.data;

import learn.solarfarm.models.Material;
import learn.solarfarm.models.SolarPanel;

import java.util.ArrayList;
import java.util.List;

public class SolarPanelRepositoryDouble implements SolarPanelRepository {
    private final ArrayList<SolarPanel> solarPanels = new ArrayList<>();

    public SolarPanelRepositoryDouble() {
        solarPanels.add(new SolarPanel(1, "Section One", 1, 1, 2020, Material.POLY_SI, true));
        solarPanels.add(new SolarPanel(2, "Section One", 1, 2, 2020, Material.POLY_SI, true));
        solarPanels.add(new SolarPanel(3, "Section Two", 10, 11, 2000, Material.A_SI, false));
    }

    @Override
    public List<SolarPanel> findAll()  {
        return solarPanels;
    }

    @Override
    public List<SolarPanel> findBySection(String section)  {
        ArrayList<SolarPanel> result = new ArrayList<>();
        for (SolarPanel sp : solarPanels) {
            if (sp.getSection().equalsIgnoreCase(section)) {
                result.add(sp);
            }
        }
        return result;
    }

    @Override
    public SolarPanel findByKey(String section, int row, int column)  {
        for (SolarPanel sp : solarPanels) {
            if (sp.isMatch(section, row, column)) {
                return sp;
            }
        }
        return null;
    }

    @Override
    public SolarPanel findById(int solarPanelId) {
        for (SolarPanel solarPanel : solarPanels)
            if (solarPanel.getId() == solarPanelId)
                return solarPanel;
        return null;
    }

    @Override
    public SolarPanel create(SolarPanel solarPanel)  {
        return solarPanel;
    }

    @Override
    public boolean update(SolarPanel solarPanel)  {
        return true;
    }

    @Override
    public boolean deleteById(int solarPanelId)  {
        return findById(solarPanelId) != null;
    }

}
