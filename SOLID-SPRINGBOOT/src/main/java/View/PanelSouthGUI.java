package View;

import Controller.ControllerCenter_Manager;
import Controller.DisplayController;
import Controller.Sort_By_GPA_Controller;
import Controller.Sort_By_Name_Controller;

import static View.PanelSouthGUI.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class PanelSouthGUI extends JPanel {

    public static JButton buttonLogout, buttonDisplay, button_Sort_By_GPA, button_Sort_By_Name;
    private JPanel panel = new JPanel();

    public PanelSouthGUI() {
        setComponent();
        SetButtonDisplay.working();
        SetButton_Sort_By_GPA.working();
        SetButton_Sort_By_Name.working();
    }

    private void setComponent() {
        add(panel);
        panel.setLayout(new FlowLayout(1));
        panel.add(buttonLogout = new JButton("Log out"));
        panel.add(buttonDisplay = new JButton("Display"));
        panel.add(button_Sort_By_GPA = new JButton("GPA sort"));
        panel.add(button_Sort_By_Name = new JButton("Name sort"));
    }
}

class SetButtonDisplay {
    public static void working() {
        buttonDisplay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                DisplayController displayController = new DisplayController();
                try {
                    ControllerCenter_Manager.doConnect(displayController);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
    }
}

class SetButton_Sort_By_GPA {

    public static void working() {
        button_Sort_By_GPA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Sort_By_GPA_Controller sort_by_gpa_controller = new Sort_By_GPA_Controller();
                try {
                    ControllerCenter_Manager.doConnect(sort_by_gpa_controller);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
    }
}

class SetButton_Sort_By_Name {
    public static void working() {
        button_Sort_By_Name.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Sort_By_Name_Controller sort_by_name_controller = new Sort_By_Name_Controller();
                try {
                    ControllerCenter_Manager.doConnect(sort_by_name_controller);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
    }
}
