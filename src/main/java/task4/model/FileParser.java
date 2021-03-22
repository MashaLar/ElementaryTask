package task4.model;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileParser {

    private FileParser() { }

    public static StringBuilder readFile(String path) throws IOException {
        FileReader fileReader = new FileReader(path);
        StringBuilder S = new StringBuilder();
        Scanner sc = new Scanner(fileReader);
        while (sc.hasNext()) {
            S.append(sc.nextLine());
        }
        fileReader.close();
        return S;
    }

    public static int countOfRegex(String path, String word) throws IOException{
        int i = 0;
        String s = readFile(path).toString();
        if(s.matches(".*"+word+".*")) {
            i = s.split(word).length - 1;
        }
        return i;
    }

    public static boolean replaceOfRegex(String path, String word, String newWord) throws IOException {
        String s = readFile(path).toString();
        FileWriter fileWriter = new FileWriter(path);
        if(s.matches(".*"+word+".*")) {
            fileWriter.write(s.replaceAll(word, newWord));
            fileWriter.close();
            return true;
        }
        return false;
    }

}
