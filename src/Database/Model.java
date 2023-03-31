package Database;

import javax.swing.*;
import java.sql.*;

public class Model {

        Connection conn = null;
        String user = "te20";
        JPasswordField pf = new JPasswordField();
       String password = JOptionPane.showInputDialog(pf, "password?");

    public String getPassword() {
        return password;
    }

    public String getUser() {
        return user;
    }





}
