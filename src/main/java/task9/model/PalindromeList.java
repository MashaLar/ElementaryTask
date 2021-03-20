package task9.model;

import general.converter.StringConverter;

import java.util.HashSet;
import java.util.Set;

public class PalindromeList {

    private Set<String> palindromes;

    public PalindromeList() {
        palindromes = new HashSet<>();
    }

    public void findAndAddPalindromeToSet(String S){
        for (int i = 0; i < S.length(); i++) {
            for (int j = i + 1; j <= S.length(); j++) {
                if (isPalindrome(S.substring(i, j))) {
                    palindromes.add(S.substring(i, j));
                }
            }
        }
    }

    public Set<String> getPalindromesSet(){
        return palindromes;
    }

    private boolean isPalindrome(String str) {
        return str.equals(StringConverter.reverseString(str));
    }

}
