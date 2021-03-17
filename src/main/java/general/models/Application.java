package general.models;

public interface Application {
    String inputDataFiltered(String someMessage);
    String inputData(String someMessage);
    void showData(String someData);
    void showWarning(String someData);
}
