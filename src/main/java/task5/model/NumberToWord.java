package task5.model;

public class NumberToWord {

    //TODO: make output string variable
    // divide to several classes

    final public String[][] words ={{"", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"},
            {"", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"},
            {"", "десять", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто"},
            {"", "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот"},
            {"тысяча", "тысячи", "тысяч"},
            {"миллион","миллиона", "миллионов"},
            { "миллиард", "миллиарда", "миллиардов"}};

    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public void translate(String S){
        if((S.matches("0+"))) {
            System.out.println("ноль");
            return;
        }
        String[] num = divideNumber(S);
        for (int i = num.length-1; i>=0; i--) {
            translateToWord(num[i]);
            if(i>=1) endWordAdd(num[i],i);
        }
    }

    //TODO: made return?
    private void translateToWord(String S){
        if(S.length() ==1){
            System.out.print(words[0][Integer.parseInt(S)]+" ");
        }
        else if(S.length() ==2){
            twoNumbersToWord(S);
        }
        else if (S.length()==3){
            System.out.print(words[3][Integer.parseInt(""+S.charAt(0))]+" ");
            twoNumbersToWord(S.substring(1));
        }

    }

    private void twoNumbersToWord(String S){
        if(Integer.parseInt(S) >10 && Integer.parseInt(S)<20 )
        {
            System.out.print(words[1][Integer.parseInt(""+S.charAt(1))]+" ");
        }
        else {
            System.out.print(words[2][Integer.parseInt(""+S.charAt(0))]+" "+words[0][Integer.parseInt(""+S.charAt(1))]+" ");
        }
    }

    private String[] divideNumber(String S){
        String[] devNum = reverseString(S).split("(?<=\\G.{3})");
        for (int i = 0; i<devNum.length;i++) {
            String num = reverseString(devNum[i]);
            devNum[i] = num;
        }
        return devNum;
    }

    //TODO: add "одна" and "две"
    private void endWordAdd(String S, int row){
        int lastSymbol = Integer.parseInt(""+S.substring((S.length()-1)));
        int twoLastSymbols = 0;
        if(S.length()>=2) {
            twoLastSymbols = Integer.parseInt(S.substring((S.length()-2)));
        }
        if(lastSymbol == 0 || lastSymbol>=5 || (twoLastSymbols>10 && twoLastSymbols<20) ){
            System.out.print(words[row+3][2]+" ");
        }
        else if(lastSymbol == 1){
            System.out.print(words[row+3][0]+" ");
        }
        else {
            System.out.print(words[row+3][1]+" ");
        }
    }

}
