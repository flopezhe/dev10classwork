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
                    // TODO: complete delete
                    deletePanel();
                    break;
            }
        }
    }

    private void findSolarPanelsBySection() throws DataAccessException {
        view.displayHeader("Find Panels by Section");
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

    private void deletePanel() throws DataAccessException {
        String section = view.getSection();
        int row = view.getRow();
        int col = view.getColumn();
        SolarPanel panel = service.findByKey(section, row, col);
        boolean confirm = view.confirmDelete(panel);

        if(confirm){
            SolarPanelResult result = service.deleteById(panel.getId());
            if(result.isSuccess()){
                view.displayMessage(String.format("%s successfully deleted!", panel.getKey()));
                view.displayMessage("");
            } else {
                view.displayErrors(result.getErrorMessages());
            }
        }

    }

    private void updateSolarPanel() throws DataAccessException {
        String section = view.getSection();
        int row = view.getRow();
        int col = view.getColumn();
        SolarPanel panel = service.findByKey(section, row, col);
        view.updatePanel(panel);
        SolarPanelResult result = service.update(panel);
        if(result.isSuccess()){
            view.displayMessage(String.format("%s successfully updated!", panel.getKey()));
        } else {
            view.displayErrors(result.getErrorMessages());
        }

        // TODO: grab the section, row, and column from the view.
        // TODO: use the service to fetch a solar panel by its key (section, row, column).
        // TODO: complete update
    }

}
