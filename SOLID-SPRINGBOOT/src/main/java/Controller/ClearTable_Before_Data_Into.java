package Controller;

import static View.PanelCenterGUI.*;

public class ClearTable_Before_Data_Into implements ControllerCenter {

    @Override
    public void working() {
        for (int i = model.getRowCount() - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }
}
