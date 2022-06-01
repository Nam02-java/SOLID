package View;

import javax.swing.*;

public class ShowMessage {

    public ShowMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Title", JOptionPane.INFORMATION_MESSAGE);
    }
}
