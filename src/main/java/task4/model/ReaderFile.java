package task4.model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReaderFile {

    private FileReader fileStream;

    public ReaderFile(String path) throws FileNotFoundException {
        fileStream = new FileReader(path);
    }

    public StringBuilder readFile() {
        StringBuilder S = new StringBuilder();
        Scanner sc = new Scanner(fileStream);
        while (sc.hasNext()) {
            S.append(sc.nextLine());
        }
        return S;
    }

    public int countOfRegex(String word){
        int i = 0;
        String s = readFile().toString();
        if(s.matches(".*"+word+".*")) {
            i = s.split(word).length - 1;
        }
        return i;
    }

    public void closeFile() {
        try {
            fileStream.close();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

}
