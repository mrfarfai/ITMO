package modals;

import java.io.*;


public class FileReader {
    public static boolean check(File file) {
        try {
            if (!file.exists()) throw new FileNotFoundException();
        } catch (FileNotFoundException ex) {
            System.out.println("Файла по указанному пути не существует.");
            return false;
        }
        try {
            if (!file.canRead() || !file.canWrite()) throw new SecurityException();
        } catch (SecurityException ex) {
            System.out.println("Файл защищён от чтения и/или записи. Для работы программы нужны оба разрешения.");
            return false;
        }
        return true;
    }

}
