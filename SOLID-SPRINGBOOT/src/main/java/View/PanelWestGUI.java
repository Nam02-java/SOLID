package View;

import Controller.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import static View.PanelWestGUI.*;
import static Controller.AddController.*;

public class PanelWestGUI extends JPanel {

    private JPanel panel_PanelWestGUI = new JPanel();
    public static JTextField textFieldName, textFieldAge, textFieldAddress, textFieldGPA;
    public static JButton buttonAdd, buttonDelete, buttonEdit, buttonSave;

    public PanelWestGUI() {
        setComponent();
        SetButtonAdd.working();
        setButtonSave.working();
        SetButtonDelete.working();
        SetButtonEdit.working();
        new CheckFileExists(fileData);
    }

    public void setComponent() {
        setLayout(new GridLayout(6, 1));
        setPreferredSize(new Dimension(450, 420));
        add(new JLabel("Name"));
        add(textFieldName = new JTextField());
        add(new JLabel("Age"));
        add(textFieldAge = new JTextField());
        add(new JLabel("Address"));
        add(textFieldAddress = new JTextField());
        add(new JLabel("GPA"));
        add(textFieldGPA = new JTextField());
        add(panel_PanelWestGUI);
        panel_PanelWestGUI.setLayout(new FlowLayout(3));
        panel_PanelWestGUI.add(buttonAdd = new JButton("Add"));
        panel_PanelWestGUI.add(buttonEdit = new JButton("Edit"));
        panel_PanelWestGUI.add(buttonDelete = new JButton("Delete"));
        panel_PanelWestGUI.add(buttonSave = new JButton("Save into MySQL"));
    }
}

class SetButtonAdd {

    public static void working() {
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AddController addController = new AddController();
                try {
                    ControllerCenter_Manager.doConnect(addController);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (SQLException throwables) {
                    new ShowMessage("Vui lòng điền đúng dữ liệu và không được để ô trống");
                }
            }
        });
    }
}

class setButtonSave {
    public static void working() {
        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                SaveController saveController = new SaveController();
                try {
                    ControllerCenter_Manager.doConnect(saveController);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
    }
}

class SetButtonDelete {
    public static void working() {
        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                DeleteController deleteController = new DeleteController();
                try {
                    ControllerCenter_Manager.doConnect(deleteController);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
    }
}

class SetButtonEdit {
    public static void working() {
        buttonEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                EditController editController = new EditController();
                try {
                    ControllerCenter_Manager.doConnect(editController);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
    }
}