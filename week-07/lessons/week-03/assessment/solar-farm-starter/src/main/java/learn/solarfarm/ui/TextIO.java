package learn.solarfarm.ui;

public interface TextIO {

    void println(Object value);

    void print(Object value);

    void printf(String format, Object... values);

    String readString(String prompt);

    String readRequiredString(String prompt);

    boolean readBoolean(String prompt);

    Boolean readOptionalBoolean(String prompt);

    int readInt(String prompt);

    int readInt(String prompt, int max);

    int readInt(String prompt, int min, int max);

    int readOptionalInt(String prompt, int min, int max);

    <T extends Enum<T>> T readEnum(String prompt, Class<T> tEnum);

   <T extends Enum<T>> T readOptionalEnum(String prompt, Class<T> tEnum, T defaultEnum);
}
