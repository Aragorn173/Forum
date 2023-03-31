package Database;

import javax.swing.*;
import java.sql.*;
import java.util.Scanner;

public class Controller extends JFrame {
    Model model;
    View view;

    Connection conn = null;


     try {
        conn = DriverManager.getConnection("jdbc:mysql://db.umea-ntig.se:3306/te20? "+
                "allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",model.getUser(),model.getPassword());
    } catch (
    SQLException e) {
        e.printStackTrace();
    }


        try {
        Statement stmt = conn.createStatement();
        String SQLQuery = "SELECT * FROM al04forum";
        ResultSet result = stmt.executeQuery(SQLQuery);

        ResultSetMetaData metadata = result.getMetaData();

        int numCols = metadata.getColumnCount();
        for (int i = 1 ; i <= numCols ; i++) {
            System.out.println(metadata.getColumnClassName(i));
        }

        while (result.next()) {
            String output = "";
            output += result.getInt("id") + ", " +
                    result.getString("title") + ", " +
                    result.getInt("authorid") + ", " +
                    result.getString("content");
            System.out.println(output);
        }

        Scanner in = new Scanner(System.in);
        System.out.println("Ange titel:");
        String titel = in.nextLine();
        System.out.println("Ange innehåll");
        String content = in.nextLine();



        SQLQuery = "INSERT INTO al04forum(title,content) VALUES ('"+titel+"','"+content+"')";

        stmt.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    public static void main(String[] args) {
        Model m = new Model();
        View v = new View();
    }
}