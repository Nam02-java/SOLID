package Controller;

import Model.DataModel;

import java.io.IOException;
import java.sql.SQLException;

import static Controller.AddController.*;
import static View.PanelCenterGUI.*;
import static JDBC.SystemCenter.*;
import static Controller.LoginController.*;

public class SaveController implements ControllerCenter {
    @Override
    public void working() throws SQLException, IOException {
        new ClearArrayList(arrayList_DataUser);
        for (int row = 0; row < table.getModel().getRowCount(); row++) {
            int id = Integer.parseInt(String.valueOf(table.getModel().getValueAt(row, 0)));
            String name = (String) table.getModel().getValueAt(row, 1);
            int age = Integer.parseInt(String.valueOf(table.getModel().getValueAt(row, 2)));
            String address = (String) table.getModel().getValueAt(row, 3);
            int gpa = Integer.parseInt(String.valueOf(table.getModel().getValueAt(row, 4)));
            arrayList_DataUser.add(new DataModel(id, name, age, address, gpa));
        }
        new WriteToFile(fileData);
        connection = getJDBCConnection();
        statement = connection.createStatement();
        String query = "DELETE FROM table_data WHERE id =" + checkId_user + " ;";
        statement.executeUpdate(query);
        if (table.getModel().getRowCount() == 0) {
            return;
        } else {
            for (int i = 0; i < arrayList_DataUser.size(); i++) {
                query = "INSERT INTO table_data (id, student_name,age,address,gpa) VALUES (" + checkId_user + ", " + "\"" + arrayList_DataUser.get(i).getName() + "\"" + ", " + arrayList_DataUser.get(i).getAge() + ", " + "\"" + arrayList_DataUser.get(i).getAddress() + "\"" + ", " + arrayList_DataUser.get(i).getGPA() + ");";
                statement.executeUpdate(query);
            }
        }
        table.setEnabled(false);
        connection.close();
    }
}
