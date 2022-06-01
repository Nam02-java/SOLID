package Controller;

import java.io.IOException;

import static Controller.AddController.*;
import static View.LoginDisplay.*;
import static Controller.LoginController.*;

public class LogoutController implements ControllerCenter {
    @Override
    public void working() throws IOException {
        new ClearArrayList(arrayList_DataUser);
        new ClearFile(fileData);
        textFieldName.setText(checkUser_name);
    }
}
