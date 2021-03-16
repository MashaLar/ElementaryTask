package general.validation;

public class StringValidator {

    public static boolean isNumber(String S){
        return S.matches("-?\\d+");
    }
    public static boolean isInt(String S){
        return S.matches("-?\\d{1,9}");
    }
    public static boolean isDouble(String S){
        return S.matches("-?\\d{1,9}\\.?\\d{1,9}");
    }

}
