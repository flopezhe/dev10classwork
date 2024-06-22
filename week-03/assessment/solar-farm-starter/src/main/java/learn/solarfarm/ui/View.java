package learn.solarfarm.ui;

import learn.solarfarm.domain.SolarPanelService;
import learn.solarfarm.models.Material;
import learn.solarfarm.models.SolarPanel;

import java.util.List;
import java.util.Scanner;

public class View {
    private final TextIO io;
    Scanner scanner = new Scanner(System.in);

    public View(TextIO io) {
        this.io = io;
    }

    public int chooseMenuOption() {
        displayHeader("Main Menu");
        io.println("0. Exit");
        io.println("1. Find Panels by Section");
        io.println("2. Add a Panel");
        io.println("3. Update a Panel");
        io.println("4. Remove a Panel");
        return io.readInt("Choose [0-4]", 0, 4);
    }

    public String getSection() {
        io.println("");
        return io.readRequiredString("Section Name");
    }

    public int getRow() {
        return io.readInt("Row", 1, SolarPanelService.MAX_ROW_COLUMN);
    }

    public int getColumn() {
        return io.readInt("Column", 1, SolarPanelService.MAX_ROW_COLUMN);
    }

    public void displaySolarPanels(String section, List<SolarPanel> solarPanels) {
        io.println("");
        io.printf("Panels in %s%n", section);
        io.println("Row Col Year Material Tracking");
        for (SolarPanel sp : solarPanels) {
            io.printf("%3s %3s %4s %8s %8s%n", sp.getRow(), sp.getColumn(), sp.getYearInstalled(),
                    sp.getMaterial(), sp.isTracking() ? "yes" : "no");
        }
    }


    public void displayHeader(String message) {
        int length = message.length();
        io.println("");
        io.println(message);
        io.println("=".repeat(length));
    }

    public void displayErrors(List<String> errors) {
        displayMessage("[Errors]");
        for (String error : errors) {
            io.println(error);
        }
    }

    public void displayMessage(String message) {
        io.println("");
        io.println(message);
    }

    public void displayMessage(String format, Object... args) {
        displayMessage(String.format(format, args));
    }

    public SolarPanel addSolarPanel() {
        displayHeader("Add a Panel");
        io.println("");

        SolarPanel result = new SolarPanel();
        result.setSection(io.readRequiredString("Section"));
        result.setRow(io.readInt("Row", 1, SolarPanelService.MAX_ROW_COLUMN));
        result.setColumn(io.readInt("Column", 1, SolarPanelService.MAX_ROW_COLUMN));
        result.setMaterial(io.readEnum("Material", Material.class));
        result.setYearInstalled(io.readInt("Installation Year", SolarPanelService.getMaxInstallationYear()));
        result.setTracking(io.readBoolean("Tracked [y/n]"));
        return result;
    }

    public String readString(String prompt) {
        displayMessage(prompt);
        return scanner.nextLine();
    }

    public boolean confirmDelete(SolarPanel panel){
        displayHeader(String.format(" Delete %s?", panel.getKey()));
        return io.readBoolean("Really delete [ y or n] ");
    }


    public void updatePanel(SolarPanel solarPanel) {
        String yrInstalled = "";
        int yearInstalled = 0;
        do {
            yrInstalled = (String.format("Year Installed (%s) \nNew Year", solarPanel.getYearInstalled()));
            if (!yrInstalled.isBlank()) {
                try {
                    yearInstalled = io.readInt(yrInstalled, 0, 2024);
                    solarPanel.setYearInstalled(yearInstalled);
                } catch (NumberFormatException ex) {
                    System.out.println("Year must be current or previous years");
                }
            }
        } while (!yrInstalled.isBlank() && yearInstalled == 0);

        String mats = "";
        int opt = 0;
        do{
            mats = (String.format("Material (%s) \nNew Material:", solarPanel.getMaterial());
            if(!mats.isBlank()){
                try{
                    Material option = readMaterial("New Material: ");
                    option = io.readEnum(option, Material.class);
                }catch (NumberFormatException ex){
                    System.out.println("Material option must be 1-5");
                }
            }
        } while(!mats.isBlank() && opt==0);


        String tracks = "";
        boolean isTracking = false;
        do {
            tracks = readString(String.format("Current Tracking Status (%s) \nPress [Enter] to keep original value. \nOtherwise, Enter [ y or n] if the panel is tracking: ", solarPanel.isTracking()));
            if (!tracks.isBlank()) {
                try {
                    isTracking = io.readBoolean(" Are you sure you want to "+ tracks + "?");
                    solarPanel.setTracking(isTracking);
                } catch (NumberFormatException ex) {
                    System.out.println("Must be y or n.");
                }
            }
        } while (!tracks.isBlank() && isTracking == false);

    }

    private Material readMaterial(String prompt) {
        Material result = Material.POLY_SI;
        System.out.println("1. POLY_SI");
        System.out.println("2. MONO_SI");
        System.out.println("3. A_SI");
        System.out.println("4. CD_TE");
        System.out.println("5. CIGS");

        int choice = io.readInt("Choose [1-5]", 1, 5);
        switch (choice) {
            case 1:
                result = Material.POLY_SI;
                break;
            case 2:
                result = Material.MONO_SI;
                break;
            case 3:
                result = Material.A_SI;
                break;
            case 4:
                result = Material.CD_TE;
                break;
            case 5:
                result = Material.CIGS;
                break;
        }

        return result;
    }

}





