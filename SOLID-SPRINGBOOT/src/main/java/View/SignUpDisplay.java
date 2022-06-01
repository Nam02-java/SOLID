package View;

import Controller.ControllerCenter_Manager;
import Controller.SignUpController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class SignUpDisplay {

    static public JTextField textFieldName;
    static public JPasswordField passwordField;
    static public JLabel labelUserName, labelPassword, labelLogo;
    static public JButton buttonRegister, buttonPrevious;
    static public ImageIcon imageIcon;
    static public JFrame jFrame;

    public SignUpDisplay() {
        SignUpGUI.setComponent();
        SetButtonPrevious.working();
        SetButtonRegister.working();
    }
}

class SignUpGUI extends SignUpDisplay {

    public static void setComponent() {
        jFrame = new JFrame("Sign Up");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setBounds(1350, 300, 300, 400);
        jFrame.getContentPane().setBackground(Color.darkGray);
        jFrame.setLayout(null);
        jFrame.setVisible(true);
        labelLogo = new JLabel("Create Account");
        labelLogo.setFont(new Font("MV Boli", Font.PLAIN, 22));
        labelLogo.setForeground(Color.WHITE);
        labelLogo.setBounds(60, 30, 170, 50);
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
        buttonRegister = new JButton("Register");
        buttonRegister.setBounds(90, 200, 100, 25);
        buttonRegister.setForeground(Color.WHITE);
        buttonRegister.setBackground(Color.BLACK);
        buttonPrevious = new JButton("Previous");
        buttonPrevious.setBounds(15, 320, 100, 25);
        buttonPrevious.setForeground(Color.WHITE);
        buttonPrevious.setBackground(Color.BLACK);
        jFrame.add(labelLogo);
        jFrame.add(textFieldName);
        jFrame.add(labelUserName);
        jFrame.add(passwordField);
        jFrame.add(labelPassword);
        jFrame.add(buttonRegister);
        jFrame.add(buttonPrevious);
    }
}

class SetButtonPrevious extends SignUpGUI {
    public static void working() {
        buttonPrevious.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jFrame.setVisible(false);
                new LoginDisplay();
            }
        });
    }
}

class SetButtonRegister extends SignUpGUI {
    public static void working() {
        buttonRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    SignUpController signUpController = new SignUpController();
                    ControllerCenter_Manager.doConnect(signUpController);
                } catch (SQLException | IOException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
    }
}

