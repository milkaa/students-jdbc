package milka.milka;

import java.sql.*;
import java.util.Random;

public class DB {

    private static Connection connection;
    private static boolean connected = false;

    public static void connect() {
        if (connected) {
            return;
        }
        boolean success1 = false;
        boolean success2 = false;
        try {
            DriverManager.registerDriver((Driver) Class.forName("com.mysql.jdbc.Driver").newInstance());
            success1 = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "");
            success2 = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (success1) {
            if (success2) {
                connected = true;
            }
        }
    }

    public static void saveQuestion(String q) {
        try {
            Statement s = connection.createStatement();
            s.executeUpdate(String.format("insert into questions (question) values (\"" + q + "\")"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getAnswer() {
        try {
            Random random = new Random();
            int selected = random.nextInt(6);

            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery("select Answer from answers where Idx=" + selected + ";");
            rs.next();
            return rs.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
            return "";
        }
    }

}
