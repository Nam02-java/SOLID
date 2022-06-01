package Controller;

import java.io.IOException;
import java.sql.SQLException;

import static View.PanelCenterGUI.*;

public class DeleteController implements ControllerCenter {
    @Override
    public void working() throws SQLException, IOException {
        model.removeRow(table.getSelectedRow());
    }
}
