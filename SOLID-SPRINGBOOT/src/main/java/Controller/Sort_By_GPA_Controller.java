package Controller;

import Model.DataModel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;

import static Controller.AddController.*;

public class Sort_By_GPA_Controller implements ControllerCenter {
    @Override
    public void working() throws SQLException, IOException {
        Collections.sort(arrayList_DataUser, new Comparator<DataModel>() {
            public int compare(DataModel d1, DataModel d2) {
                if (d1.getGPA() - d2.getGPA() > 0) {
                    return 1;
                } else if (d1.getGPA() - d2.getGPA() < 0) {
                    return -1;
                } else {
                    if (d1.getName().compareTo(d2.getName()) > 0) {
                        return 1;
                    } else if (d1.getName().compareTo(d2.getName()) < 0) {
                        return -1;
                    } else {
                        if (d1.getAge() - d2.getAge() > 0) {
                            return 1;
                        } else if (d1.getAge() - d2.getAge() < 0) {
                            return -1;
                        } else {
                            if (d1.getAddress().compareTo(d2.getAddress()) > 0) {
                                return 1;
                            } else if (d1.getAddress().compareTo(d2.getAddress()) < 0) {
                                return -1;
                            } else {
                                return 0;
                            }
                        }
                    }
                }
            }
        });
        Display_Data_After_Login display_data_after_login = new Display_Data_After_Login();
        ControllerCenter_Manager.doConnect(display_data_after_login);
    }
}
