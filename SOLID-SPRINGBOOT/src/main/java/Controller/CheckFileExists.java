package Controller;

import java.io.File;
import java.io.IOException;

public class CheckFileExists {

    public CheckFileExists(File file) {
        try {
            if (file.exists()) {
            } else {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
