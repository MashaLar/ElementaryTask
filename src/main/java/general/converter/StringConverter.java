package general.converter;

import general.validation.StringValidator;

public class StringConverter {

    public static Integer StringToInt(String S) {
        if(StringValidator.isInt(S)) return Integer.parseInt(S);
        else return 0;
    }
    public static Double StringToDouble(String S){
        if(StringValidator.isDouble(S)) return Double.parseDouble(S);
        else return 0.0;
    }
    public static String StringIgnoreRegisterLow(String S){
        return S.toLowerCase();
    }
    public static String StringIgnoreRegisterUp(String S){
        return S.toUpperCase();
    }
    public static String StringIgnoreTabsSpaces(String S){
        return S.replaceAll("[\\s, \t]","");
    }


}
