package learn.solarfarm.ui;

import java.util.Scanner;

public class ConsoleIO implements TextIO {

    private final Scanner console = new Scanner(System.in);

    @Override
    public void println(Object value) {
        System.out.println(value);
    }

    @Override
    public void print(Object value) {
        System.out.print(value);
    }

    @Override
    public void printf(String format, Object... values) {
        System.out.printf(format, values);
    }

    @Override
    public String readString(String prompt) {
        // for consistent display of prompts
        // remove any leading and trailing whitespace and add a space after the prompt
        print(prompt.trim() + ": ");
        return console.nextLine();
    }

    @Override
    public String readRequiredString(String prompt) {
        while (true) {
            String value = readString(prompt);
            if (value != null && !value.isBlank()) {
                return value;
            }
            printf("[Error]%nYou must provide a value.%n");
        }
    }

    @Override
    public boolean readBoolean(String prompt) {
        String result = readString(prompt);
        return result.equalsIgnoreCase("y");
    }

    @Override
    public Boolean readOptionalBoolean(String prompt) {
        String result = readString(prompt);
        if (result.isBlank()) return null;
        return Boolean.valueOf(result.equalsIgnoreCase("y"));
    }

    @Override
    public int readOptionalInt(String prompt, int min, int max) {
        while (true) {
            String value = readString(prompt);
            if (value.isBlank()) return 0;
            try {
                int result = Integer.parseInt(value);
                if (result >= min && result <= max) {
                    return result;
                }
                printf("[Error]%nValue must be between %s and %s.%n", min, max);
            } catch (NumberFormatException ex) {
                printf("[Error]%n'%s' is not a valid number.%n", value);
            }
        }
    }

    @Override
    public int readInt(String prompt) {
        while (true) {
            String value = readString(prompt);
            try {
                int result = Integer.parseInt(value);
                return result;
            } catch (NumberFormatException ex) {
                printf("[Error]%n'%s' is not a valid number.%n", value);
            }
        }
    }

    @Override
    public int readInt(String prompt, int max) {
        while (true) {
            int value = readInt(prompt);
            if (value <= max) {
                return value;
            }
            printf("[Error]%nValue must be less than or equal to %s.%n", max);
        }
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        while (true) {
            int value = readInt(prompt);
            if (value >= min && value <= max) {
                return value;
            }
            printf("[Error]%nValue must be between %s and %s.%n", min, max);
        }
    }

    @Override
    public <T extends Enum<T>> T readEnum(String prompt, Class<T> tEnum) {
        println(prompt);
        T[] enumConstants = tEnum.getEnumConstants();
        for (int i = 0; i < enumConstants.length; i++) {
            System.out.printf("%s. %s%n", i + 1, enumConstants[i]);
        }
        String label = String.format("Select [1-%s]", enumConstants.length);
        int index = readInt(label, 1, enumConstants.length);
        return enumConstants[index - 1];
    }

    @Override
    public <T extends Enum<T>> T readOptionalEnum(String prompt, Class<T> tEnum, T defaultEnum) {
        println(prompt);
        T[] enumConstants = tEnum.getEnumConstants();
        for (int i = 0; i < enumConstants.length; i++)
            if (enumConstants[i] == defaultEnum)
                System.out.printf("(%s. %s)%n", i + 1, enumConstants[i]);
            else
                System.out.printf("%s. %s%n", i + 1, enumConstants[i]);
        String label = String.format("Select [1-%s] or press [Enter]", enumConstants.length);
        int index = readOptionalInt(label, 1, enumConstants.length);
        if (index > 0)
            return enumConstants[index - 1];
        return null;
    }
}
