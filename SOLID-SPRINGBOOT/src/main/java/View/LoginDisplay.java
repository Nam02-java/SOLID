package View;

import Controller.ControllerCenter_Manager;
import Controller.LoginController;

import static Controller.LoginController.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class LoginDisplay {

    static public JButton buttonLogin, buttonSignUp;
    static public JTextField textFieldName;
    static public JPasswordField passwordField;
    static public JLabel labelUserName, labelPassword, labelLogo;
    static public ImageIcon imageIcon;
    static public JFrame jFrame;


    public LoginDisplay() {
        LoginGUI.setComponent();
        SetButtonLogin.working();
        SetButtonSignUp.working();
    }
}

class LoginGUI extends LoginDisplay { //extend loginDisplay

    public static void setComponent() {
        jFrame = new JFrame("Login");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setBounds(1350, 300, 300, 400);
        jFrame.getContentPane().setBackground(Color.DARK_GRAY);
        jFrame.setLayout(null);
        jFrame.setVisible(true);
        labelLogo = new JLabel();
        labelLogo.setIcon(imageIcon = new ImageIcon("C:\\Users\\User\\Downloads\\icons8-student-center-48.png"));
        labelLogo.setBounds(110, 20, 50, 50);
        textFieldName = new JTextField();
        textFieldName.setBounds(60, 100, 170, 30);
        textFieldName.setBackground(Color.black);
        textFieldName.setCaretColor(Color.WHITE);
        textFieldName.setForeground(Color.WHITE);
        labelUserName = new JLabel();
        labelUserName.setIcon(imageIcon = new ImageIcon("C:\\Users\\User\\Downloads\\icons8-user-24.png"));
        labelUserName.setBounds(10, 100, 24, 24);
        passwordField = new JPasswordField();
        passwordField.setBounds(60, 145, 170, 30);
        passwordField.setBackground(Color.black);
        passwordField.setCaretColor(Color.WHITE);
        passwordField.setForeground(Color.WHITE);
        labelPassword = new JLabel();
        labelPassword.setIcon(imageIcon = new ImageIcon("C:\\Users\\User\\Downloads\\icons8-password-24.png"));
        labelPassword.setBounds(10, 147, 24, 24);
        buttonLogin = new JButton("Login");
        buttonLogin.setBounds(90, 200, 100, 25);
        buttonLogin.setForeground(Color.WHITE);
        buttonLogin.setBackground(Color.BLACK);
        buttonSignUp = new JButton("Sign Up");
        buttonSignUp.setBounds(190, 330, 80, 25);
        buttonSignUp.setForeground(Color.WHITE);
        buttonSignUp.setBackground(Color.BLACK);
        jFrame.add(labelLogo);
        jFrame.add(textFieldName);
        jFrame.add(labelUserName);
        jFrame.add(passwordField);
        jFrame.add(labelPassword);
        jFrame.add(buttonLogin);
        jFrame.add(buttonSignUp);

    }
}

class SetButtonLogin extends LoginGUI { //extends login gui

    public static void working() {
        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                LoginController loginController = new LoginController();
                try {
                    ControllerCenter_Manager.doConnect(loginController);
                    if (check == true) {
                        jFrame.setVisible(false);
                        new DataDisplay();
                    } else {
                        return;
                    }
                } catch (SQLException | IOException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
    }
}

class SetButtonSignUp extends LoginGUI {

    public static void working() {
        buttonSignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jFrame.setVisible(false);
                new SignUpDisplay();
            }
        });
    }
}