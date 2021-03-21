package task9.model;

import general.converter.StringConverter;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class PalindromeList {

    private Set<String> palindromes;

    public PalindromeList() {
        palindromes = new HashSet<>();
    }

    public void findAndAddPalindromeToSet(String S) {
        for (int i = 0; i < S.length(); i++) {
            for (int j = i + 1; j <= S.length(); j++) {
                if (isValidString(S.substring(i, j))) {
                    if (isPalindrome(S.substring(i, j))) {
                        palindromes.add(S.substring(i, j));
                    }
                }
            }
        }
    }

    public Set<String> getPalindromesSet() {
        return palindromes;
    }

    private boolean isPalindrome(String str) {
        return str.equals(StringConverter.reverseString(str));
    }

    private boolean isValidString(String S) {
        return S.length() >= 2;
    }

    @Override
    public String toString() {
        return palindromes.stream()
                .sorted(Comparator.comparingInt(String::length))
                .filter(string -> !string.matches(""))
                .collect(Collectors.joining(", ", "\nAll palindromes: ", "."));
    }

}
