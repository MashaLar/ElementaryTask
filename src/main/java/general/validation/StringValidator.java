package general.validation;

public class StringValidator {

    public static boolean isIntegerNumber(String S){
        return S.matches("-?\\d+");
    }
    public static boolean isInt(String S){
        return S.matches("-?\\d{1,9}");
    }
    public static boolean isDouble(String S){
        return S.matches("-?\\d{0,9}\\.?\\d{1,9}");
    }
    public static boolean isPath(String S){
        return S.matches("^(\\S:\\\\)?((\\w.*)+\\\\)*\\w+.txt$");
    }

}
