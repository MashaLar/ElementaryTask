package task5.util;

import task5.constants.NumberWordsArray;

public class EndNumberWord implements NumberWordsArray {
    private EndNumberWord(){};

    public static String endWordAdd(String S, int row){
        int lastSymbol = Integer.parseInt(S.substring((S.length()-1)));
        int twoLastSymbols = 0;
        if(S.length()>=2) {
            twoLastSymbols = Integer.parseInt(S.substring((S.length()-2)));
        }
        if(lastSymbol == 0 || lastSymbol>=5 || (twoLastSymbols>10 && twoLastSymbols<20) ){
            return END_NUMBER_WORDS[row][2];
        }
        else if(lastSymbol == 1){
            return END_NUMBER_WORDS[row][0];
        }
        else {
            return END_NUMBER_WORDS[row][1];
        }
    }
}
