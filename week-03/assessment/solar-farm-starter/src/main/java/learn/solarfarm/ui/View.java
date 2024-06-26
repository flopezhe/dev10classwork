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

        solarPanel.setSection(io.readRequiredString(String.format("Section (%s) \nNew Section", solarPanel.getSection())));

        solarPanel.setRow(io.readInt(String.format("Row (%s) \n New Row", solarPanel.getRow()), 1, 250));

        solarPanel.setColumn(io.readInt(String.format("Column (%s) \n New Column", solarPanel.getColumn()), 1, 250));

        solarPanel.setYearInstalled(io.readInt(String.format("Year Installed (%s) \nNew Year", solarPanel.getYearInstalled()), 0, 2024));

        solarPanel.setMaterial(io.readEnum(String.format("Material (%s)", solarPanel.getMaterial()), Material.class));

        solarPanel.setTracking(io.readBoolean(String.format("Tracking (%s) \nEnter (y or n) to update", solarPanel.isTracking())));


    }



}





