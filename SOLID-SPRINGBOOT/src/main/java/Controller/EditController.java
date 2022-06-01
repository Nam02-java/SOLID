package Controller;

import java.io.IOException;
import java.sql.SQLException;

import static View.PanelCenterGUI.*;

public class EditController implements ControllerCenter {
    @Override
    public void working() throws SQLException, IOException {
        table.setEnabled(true);
    }
}
