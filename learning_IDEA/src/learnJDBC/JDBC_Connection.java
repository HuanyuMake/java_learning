package learnJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC_Connection {
    static String drivername = "com.mysql.cj.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/lsh?useLegacyDatetimeCode=false&serverTimezone=America/New_York";
    static String username = "root";
    static String password = "123456";

    static {
        try {
            Class.forName(drivername);
            System.out.println("创建驱动成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = (Connection) DriverManager.getConnection(url, username, password);
            System.out.println("链接数据库成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void main(String[] args) {
        JDBC_Connection.getConnection();
    }
}

