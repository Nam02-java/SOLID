package Controller;

import Model.DataModel;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import static View.PanelCenterGUI.*;
import static Controller.LoginController.*;
import static View.PanelWestGUI.*;


public class AddController implements ControllerCenter {
    public static File fileData = new File("Data.txt");
    public static ArrayList<DataModel> arrayList_DataUser = new ArrayList<DataModel>();

    @Override
    public void working() throws SQLException, IOException {
        arrayList_DataUser.clear();
        new ReadFileToArrayList(fileData);
        arrayList_DataUser.add(new DataModel(checkId_user, textFieldName.getText(), Integer.parseInt(textFieldAge.getText()), textFieldAddress.getText(), Integer.parseInt(textFieldGPA.getText())));
        array2d = new Object[arrayList_DataUser.size()][5];
        Collections.reverse(arrayList_DataUser);
        for (int i = 0; i < arrayList_DataUser.size(); i++) {
            Object id = array2d[i][0] = arrayList_DataUser.get(i).getId();
            Object name = array2d[i][1] = arrayList_DataUser.get(i).getName();
            Object age = array2d[i][2] = arrayList_DataUser.get(i).getAge();
            Object address = array2d[i][3] = arrayList_DataUser.get(i).getAddress();
            Object gpa = array2d[i][4] = arrayList_DataUser.get(i).getGPA();
            row = new Object[]{id, name, age, address, gpa};
            model.addRow(row);
            textFieldName.setText(""); // update
            textFieldAge.setText("");
            textFieldAddress.setText("");
            textFieldGPA.setText("");
            Collections.reverse(arrayList_DataUser);
            new WriteToFile(fileData);
            break;
        }
    }
}
