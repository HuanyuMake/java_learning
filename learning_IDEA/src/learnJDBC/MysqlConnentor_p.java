package learnJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author 潘栋磊
 * @version 0.0.1
 */
public class MysqlConnentor_p {
    static String drivername = "com.mysql.cj.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/lsh?useLegacyDatetimeCode=false&serverTimezone=America/New_York";
    String username = "root";
    String password = "123456";

    static {
        try {
            Class.forName(drivername);
            System.out.println("创建驱动成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(String url, String username, String password) {
        Connection conn = null;
        try {
            conn = (Connection) DriverManager.getConnection(url, username, password);
            System.out.println("链接数据库成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public MysqlConnentor_p(String url, String username, String password) {

    }
}
