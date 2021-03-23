package task5.model;

import general.converter.StringConverter;
import task5.constants.NumberWordsArray;
import task5.util.EndNumberWord;
import task5.util.HundredsUniqueNums;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NumberToWord implements NumberWordsArray {

    private List<String> result;
    private String number;

    public NumberToWord(String number) {
        result = new ArrayList<>();
        this.number = number;
        translate();
    }

    private void translate() {
        if ((number.matches("0+"))) {
            number = "0";
            result.add(ZERO);
            return;
        }
        replaceZeroOnStart();
        String newNumber = number;
        if ((number.matches("-\\d*"))) {
            result.add(MINUS);
            newNumber = number.substring(1);
        }
        String[] num = divideNumber(StringConverter
                .stringIgnoreTabsSpaces(newNumber));
        for (int i = num.length - 1; i >= 0; i--) {
            translateToWord(num[i]);
            if (i >= 1) {
                if (i + 3 == 4) {
                    result.add(HundredsUniqueNums
                            .changeNumToHundredUnique(result));
                    result.remove(result.size()-2);
                }
                result.add(EndNumberWord.endWordAdd(num[i], i));
            }
        }
    }

    private void replaceZeroOnStart(){
        if (number.matches("0+[1-9]+")) {
            number = number.replaceAll("0","");
        }
    }

    private String[] divideNumber(String S) {
        String[] devNum = StringConverter.reverseString(S)
                .split("(?<=\\G.{3})");
        for (int i = 0; i < devNum.length; i++) {
            devNum[i] = StringConverter.reverseString(devNum[i]);
        }
        return devNum;
    }

    private void translateToWord(String S) {
        switch (S.length()) {
            case 1:
                result.add(WORDS[0][Integer.parseInt(S)]);
                return;
            case 2:
                twoNumbersToWord(S);
                return;
            case 3:
                result.add(WORDS[3][Integer.parseInt("" + S.charAt(0))]);
                twoNumbersToWord(S.substring(1));
                return;
        }
    }

    private void twoNumbersToWord(String S) {
        if (Integer.parseInt(S) > 10 && Integer.parseInt(S) < 20) {
            result.add(WORDS[1][Integer.parseInt("" + S.charAt(1))]);
        } else {
            result.add(WORDS[2][Integer.parseInt("" + S.charAt(0))]);
            result.add(WORDS[0][Integer.parseInt("" + S.charAt(1))]);
        }
    }

    @Override
    public String toString() {
        return number + " - " + result.stream()
                .filter(string -> !string.matches(""))
                .collect(Collectors.joining(" "));
    }
}
