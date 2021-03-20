package task5.util;

import java.util.List;

public class HundredsUniqueNums {
    private HundredsUniqueNums(){}

    public static String changeNumToHundredUnique(List<String> strings){
        String lastElement = strings.get(strings.size()-1);
        if(lastElement.matches("один")){
            lastElement = "одна";
        }
        else if(lastElement.matches("два")){
            lastElement ="две";
        }
        return lastElement;
    }
}
