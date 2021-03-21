package general.converter;

import general.validation.StringValidator;

public class StringConverter {

    public static Integer stringToInt(String S) {
        if(StringValidator.isInt(S)) return Integer.parseInt(S);
        else return 0;
    }
    public static Double stringToDouble(String S){
        if(StringValidator.isDouble(S)) return Double.parseDouble(S);
        else return 0.0;
    }
    public static String stringIgnoreRegisterLow(String S){
        return S.toLowerCase();
    }
    public static String stringIgnorePlus(String S){
        return S.replaceAll("\\+", "");
    }
    public static String stringIgnoreTabsSpaces(String S){
        return S.replaceAll("[.,;\\s\t]+", "");
    }
    public static String reverseString(String S) {
        return new StringBuilder(S).reverse().toString();
    }
    public static String stringIgnoreTabsSpacesPlus(String S){
        return S.replaceAll("[+.,;\\s\t]+",
                "");
    }

}
