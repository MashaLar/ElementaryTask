package task5.model;

public class NumberToWord {

    //TODO: make output string variable
    // divide to several classes

    private static final String[][] WORDS ={{"", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"},
            {"", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"},
            {"", "десять", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто"},
            {"", "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот"},
            {"тысяча", "тысячи", "тысяч"},
            {"миллион","миллиона", "миллионов"},
            { "миллиард", "миллиарда", "миллиардов"}};

    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public String translate(String S){
        if((S.matches("0+"))) {
            return "ноль";
        }
        StringBuilder result = new StringBuilder();
        String[] num = divideNumber(S.replaceAll("[,;\\s]",""));
        for (int i = num.length-1; i>=0; i--) {
            result.append(translateToWord(num[i]));
            if (i >= 1) {
                if(i+3==4) result = hundredsUniqueNums(result);
                result.append(endWordAdd(num[i], i));
            }
        }
        return result.toString();
    }

    private String[] divideNumber(String S){
        String[] devNum = reverseString(S).split("(?<=\\G.{3})");
        for (int i = 0; i<devNum.length;i++) {
            String num = reverseString(devNum[i]);
            devNum[i] = num;
        }
        return devNum;
    }

    private String translateToWord(String S){
        if(S.length() ==1){
            return WORDS[0][Integer.parseInt(S)]+" ";
        }
        else if(S.length() ==2){
            return twoNumbersToWord(S);
        }
        else if (S.length()==3){
            return WORDS[3][Integer.parseInt(""+S.charAt(0))]+" "+ twoNumbersToWord(S.substring(1));
        }
        else{
            return "Too big number";
        }

    }

    private String twoNumbersToWord(String S){
        if(Integer.parseInt(S) >10 && Integer.parseInt(S)<20 )
        {
            return WORDS[1][Integer.parseInt(""+S.charAt(1))]+" ";
        }
        else {
            return WORDS[2][Integer.parseInt(""+S.charAt(0))]+" "+ WORDS[0][Integer.parseInt(""+S.charAt(1))]+" ";
        }
    }

    private StringBuilder hundredsUniqueNums(StringBuilder S){
        if(S.toString().matches(".*один $")){
            S.delete(S.length()-6,S.length()-1);
            S.append("одна ");
        }
        else if(S.toString().matches(".*два $")){
            S.delete(S.length()-5,S.length()-1);
            S.append("две ");
        }
        return S;
    }

    private String endWordAdd(String S, int row){
        int lastSymbol = Integer.parseInt(""+S.substring((S.length()-1)));
        int twoLastSymbols = 0;
        if(S.length()>=2) {
            twoLastSymbols = Integer.parseInt(S.substring((S.length()-2)));
        }
        if(lastSymbol == 0 || lastSymbol>=5 || (twoLastSymbols>10 && twoLastSymbols<20) ){
           return WORDS[row+3][2]+" ";
        }
        else if(lastSymbol == 1){
            return WORDS[row+3][0]+" ";
        }
        else {
            return WORDS[row+3][1]+" ";
        }
    }
}
