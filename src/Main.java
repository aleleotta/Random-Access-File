import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {
    public static void main(String[] args) {
        File defaultFile = new File("src\\Default File.txt");
        File resultFile1 = new File("src\\Result File1.txt");
        File resultFile2 = new File("src\\Result File2.txt");
        RandomAccessFile defaultFileAccess;
        RandomAccessFile resultFileAccess1;
        RandomAccessFile resultFileAccess2;
        try {
            if (!defaultFile.exists()) {
                defaultFile.createNewFile();
                defaultFileAccess = new RandomAccessFile(defaultFile, "rw");
                defaultFileAccess.writeBytes("a");
                defaultFileAccess.close();
            }
            if (!resultFile1.exists()) {
                resultFile1.createNewFile();
            }
            defaultFileAccess = new RandomAccessFile(defaultFile, "r");
            resultFileAccess1 = new RandomAccessFile(resultFile1, "rw");
            char startChar = (char)(defaultFileAccess.readLine()).charAt(0);
            for (int i = 1; i <= 5; i++) {
                if (i == 5) {
                    resultFileAccess1.writeBytes("a"+i);
                }
                else {
                    resultFileAccess1.writeBytes("a"+i+"\n");
                }
            }
            resultFileAccess2 = new RandomAccessFile(resultFile2, "rw");
            int i = 1;
            for (char start = startChar; start <= 'e'; start++) {
                if (start == 'e') {
                    resultFileAccess2.writeBytes(String.valueOf(start)+i);
                }
                else {
                    resultFileAccess2.writeBytes(String.valueOf(start)+i+"\n");
                }
                i++;
            }
        }
        catch (IOException err) {
            System.out.println(err.getMessage());
        }
    }
}