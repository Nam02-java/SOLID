package Controller;

import Model.DataModel;
import Model.LoginModel;
import View.ShowMessage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static JDBC.SystemCenter.*;
import static View.LoginDisplay.*;
import static Controller.AddController.*;

public class LoginController implements ControllerCenter {

    private static ArrayList<LoginModel> arrayList_Login = new ArrayList<>();
    public static Boolean check;
    public static int checkId_user;
    public static String checkUser_name;

    @Override
    public void working() throws SQLException, IOException {
        if (textFieldName.getText().equals("") && passwordField.getText().equals("")) {
            check = false;
            new ShowMessage("Không được để ô trống");
        } else if (textFieldName.getText().equals("")) {
            new ShowMessage("Không được để ô tên trống");
        } else if (passwordField.getText().equals("")) {
            new ShowMessage("Không được để ô mật khẩu trống");
        } else {
            arrayList_Login.clear();
            connection = getJDBCConnection();
            statement = connection.createStatement();
            String query = "SELECT * FROM table_user";
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id_user = resultSet.getInt(1);
                String user_name = resultSet.getString(2);
                String user_password = resultSet.getString(3);
                arrayList_Login.add(new LoginModel(id_user, user_name, user_password));
            }
            if (arrayList_Login.size() == 0) {
                new ShowMessage("tên đăng nhập hoặc mật khẩu không đúng");
                check = false;
                return;
            } else if (arrayList_Login.size() >= 1) {
                for (int i = 0; i < arrayList_Login.size(); i++) {
                    if (arrayList_Login.get(i).getUser_name().equals(textFieldName.getText())) {
                        if (arrayList_Login.get(i).getUser_password().equals(passwordField.getText())) {
                            checkId_user = arrayList_Login.get(i).getId_user();
                            checkUser_name = arrayList_Login.get(i).getUser_name();
                            new ShowMessage("Đăng nhập thành công");
                            new ClearArrayList(arrayList_DataUser);
                            new ClearFile(fileData);
                            arrayList_Login.clear();
                            check = true;
                            query = "SELECT d.id , e.student_name , e.age , e.address , e.gpa FROM students_data.table_data e INNER JOIN students_data.table_user d ON e.id = d.id HAVING d.id = " + checkId_user + ";";
                            resultSet = statement.executeQuery(query);
                            while (resultSet.next()) {
                                int id_user = resultSet.getInt(1);
                                String student_name = resultSet.getString(2);
                                int age = resultSet.getInt(3);
                                String address = resultSet.getString(4);
                                int gpa = resultSet.getInt(5);
                                arrayList_DataUser.add(new DataModel(id_user, student_name, age, address, gpa));
                            }
                            return;
                        }
                    }
                }
                new ShowMessage("Tên đăng nhập hoặc mật khẩu không đúng");
                check = false;
                return;
            }
            connection.close();
        }
    }
}

