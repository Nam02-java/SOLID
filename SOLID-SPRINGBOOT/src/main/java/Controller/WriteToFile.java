package Controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static Controller.AddController.*;
import static View.PanelCenterGUI.*;

public class WriteToFile {

    public WriteToFile(File file) throws IOException {
        if (table.getModel().getRowCount() == 0) {
            return;
        } else {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (int i = 0; i < arrayList_DataUser.size(); i++) {
                bufferedWriter.write(arrayList_DataUser.get(i).getId() + " " + arrayList_DataUser.get(i).getName() + " " + arrayList_DataUser.get(i).getAge() + " " + arrayList_DataUser.get(i).getAddress() + " " + arrayList_DataUser.get(i).getGPA() + "\n");
            }
            bufferedWriter.close();
        }
    }
}
