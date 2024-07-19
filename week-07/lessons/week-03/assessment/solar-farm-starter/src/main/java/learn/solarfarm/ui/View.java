package learn.solarfarm.ui;

import learn.solarfarm.domain.SolarPanelResult;
import learn.solarfarm.domain.SolarPanelService;
import learn.solarfarm.models.Material;
import learn.solarfarm.models.SolarPanel;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.List;

public class View {
    private final TextIO io;

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

    public SolarPanel update(SolarPanel solarPanel) {
        io.println("");
        io.printf("Editing %s%n", solarPanel.getKey());
        io.println("Press [Enter] to keep original value.");
        io.println("");

        String section = io.readString(String.format("Section (%s)", solarPanel.getSection()));
        if (!section.isBlank()) solarPanel.setSection(section);

        int row = io.readOptionalInt(
                String.format("Row (%d)", solarPanel.getRow()), 1, SolarPanelService.MAX_ROW_COLUMN);
        if (row > 0) solarPanel.setRow(row);

        int column = io.readOptionalInt(
                String.format("Column (%d)", solarPanel.getColumn()), 1, SolarPanelService.MAX_ROW_COLUMN);
        if (column > 0) solarPanel.setColumn(column);

        Material material = io.readOptionalEnum("Material", Material.class, solarPanel.getMaterial());
        if (material != null) solarPanel.setMaterial(material);

        int installationYear = io.readOptionalInt(
                String.format("Installation Year (%d)", solarPanel.getYearInstalled()),
                1, SolarPanelService.getMaxInstallationYear());
        if (installationYear > 0) solarPanel.setYearInstalled(installationYear);

        Boolean tracking = io.readOptionalBoolean(
                solarPanel.isTracking() ? "Tracked (yes) [y/n]" : "Tracked (no) [y/n]");
        if (tracking != null) solarPanel.setTracking(tracking);

        return solarPanel;
    }

    public void displaySuccess(SolarPanel solarPanel, String verb) {
        io.println("");
        io.println("[Success]");
        io.printf("Panel %s %s.", solarPanel.getKey(), verb);
        io.println("");
    }

    public void listSections(List<String> sections) {
        displayHeader("Sections: ");
        for (String section : sections)
            System.out.println(section);
    }
}
