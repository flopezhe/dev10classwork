package learn.solarfarm.models;

/**
 * Represents a solar panel material.
 */
public enum Material {
    POLY_SI("Multicrystalline Silicon"),
    MONO_SI("Monocrystalline Silicon"),
    A_SI("Amorphous Silicon"),
    CD_TE("Cadmium Telluride"),
    CIGS("Copper Indium Gallium Selenide");

    private final String name;

    Material(String name) {
        this.name = name;
    }

    /**
     * The material name.
     *
     * @return A String representing the material name.
     */
    public static Material readMaterial(int choice) {
        switch (choice) {
            case 1:
                return POLY_SI;

            case 2:
                return MONO_SI;

            case 3:
                return A_SI;

            case 4:
                return CD_TE;

            case 5:
                return CIGS;
            default:
                throw new IllegalArgumentException("Invalid choice : " + choice);
        }
    }

    public String getName() {
        return name;
    }
}
