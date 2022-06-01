package View;


import Controller.ControllerCenter_Manager;
import Controller.Display_Data_After_Login;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.sql.SQLException;

public class PanelCenterGUI extends JPanel {

    public static DefaultTableModel model;
    public static JTable table;
    public static String[] column;
    public static Object[][] array2d;
    public static Object[] row;

    public PanelCenterGUI() throws IOException, SQLException {
        setComponent();
        Display_Data_After_Login display_data_after_login = new Display_Data_After_Login();
        ControllerCenter_Manager.doConnect(display_data_after_login);
    }

    private void setComponent() throws IOException, SQLException {
        column = new String[]{"ID_Teacher", "Student_Name", "Student_Age", "Student_City", "Student_GPA"};
        model = new DefaultTableModel(array2d, column);
        table = new JTable(model);
        add(new JScrollPane(table));
        table.setEnabled(false);
    }
}
