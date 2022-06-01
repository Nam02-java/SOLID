package View;

import Controller.ControllerCenter_Manager;
import Controller.LogoutController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import static View.PanelSouthGUI.*;

public class DataDisplay extends JFrame {

    public DataDisplay() throws IOException, SQLException {
        setComponent();
        setButtonLogout();
    }

    public void setComponent() throws IOException, SQLException {
        setTitle("Data");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 130, 1300, 700);
        setVisible(true);
        add(new PanelCenterGUI(), BorderLayout.CENTER);
        add(new PanelWestGUI(), BorderLayout.WEST);
        add(new PanelSouthGUI(), BorderLayout.SOUTH);
    }

    public void setButtonLogout() {
        buttonLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false);
                new LoginDisplay();
                LogoutController logoutController = new LogoutController();
                try {
                    ControllerCenter_Manager.doConnect(logoutController);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
    }
}

