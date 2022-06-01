package Controller;

import java.io.IOException;
import java.sql.SQLException;

import static View.PanelCenterGUI.*;
import static Controller.AddController.*;

public class Display_Data_After_Login implements ControllerCenter {
    @Override
    public void working() throws SQLException, IOException {
        ClearTable_Before_Data_Into clearTable_before_data_into = new ClearTable_Before_Data_Into();
        ControllerCenter_Manager.doConnect(clearTable_before_data_into);
        array2d = new Object[arrayList_DataUser.size()][5];
        for (int i = 0; i < arrayList_DataUser.size(); i++) {
            Object id = array2d[i][0] = arrayList_DataUser.get(i).getId();
            Object name = array2d[i][1] = arrayList_DataUser.get(i).getName();
            Object age = array2d[i][2] = arrayList_DataUser.get(i).getAge();
            Object address = array2d[i][3] = arrayList_DataUser.get(i).getAddress();
            Object gpa = array2d[i][4] = arrayList_DataUser.get(i).getGPA();
            row = new Object[]{id, name, age, address, gpa};
            model.addRow(row);
            new WriteToFile(fileData);
        }
    }
}
