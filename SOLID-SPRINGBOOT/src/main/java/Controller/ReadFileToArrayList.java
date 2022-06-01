package Controller;

import Model.DataModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static Controller.AddController.*;

public class ReadFileToArrayList {

    public ReadFileToArrayList(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            arrayList_DataUser.add(new DataModel(scanner.nextInt(), scanner.next(), scanner.nextInt(), scanner.next(), scanner.nextInt()));
        }
        scanner.close();
    }
}
