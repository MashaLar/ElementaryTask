package task4.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReaderFile {

    private FileReader fileStream;

    public ReaderFile(String path) throws FileNotFoundException {
        fileStream = new FileReader(path);
    }

    public String readFile() {
        String S = "";
        try(BufferedReader buf = new BufferedReader(fileStream)){
            S = buf.readLine();
        }catch (IOException e){
            System.out.println(e);
        }
        return S;
    }

    public void closeFile() {
        try {
            fileStream.close();
        }
        catch (IOException e){
            System.out.println(e);
        }
    }

}
