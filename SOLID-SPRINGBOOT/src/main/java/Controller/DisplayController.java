package Controller;

import Model.DataModel;

import java.io.IOException;
import java.sql.SQLException;

import static Controller.AddController.*;
import static JDBC.SystemCenter.*;
import static Controller.LoginController.*;

public class DisplayController implements ControllerCenter {
    @Override
    public void working() throws SQLException, IOException {
        new ClearArrayList(arrayList_DataUser);
        new ClearFile(fileData);
        ClearTable_Before_Data_Into clearTable_before_data_into = new ClearTable_Before_Data_Into();
        ControllerCenter_Manager.doConnect(clearTable_before_data_into);
        connection = getJDBCConnection();
        statement = connection.createStatement();
        String query = "SELECT d.id , e.student_name , e.age , e.address , e.gpa FROM students_data.table_data e INNER JOIN students_data.table_user d ON e.id = d.id HAVING d.id = " + checkId_user + ";";
        resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            int id_user = resultSet.getInt(1);
            String student_name = resultSet.getString(2);
            int age = resultSet.getInt(3);
            String address = resultSet.getString(4);
            int gpa = resultSet.getInt(5);
            arrayList_DataUser.add(new DataModel(id_user, student_name, age, address, gpa));
        }
        connection.close();
        Display_Data_After_Login display_data_after_login = new Display_Data_After_Login();
        ControllerCenter_Manager.doConnect(display_data_after_login);
    }
}
