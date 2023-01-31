package learnJDBC;

import com.mysql.cj.jdbc.Driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.Properties;

/**
 * @author 潘栋磊
 * @version 0.0.1
 */
@SuppressWarnings({"all"})
public class JDBCHelper {
    public static void main(String[] args) throws SQLException {

        try {
//            connect_way01();
//            connect_way02();
//            connect_way03();
//            connect_way04();
            connect_way05();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static String displayInterval = "\t\t\t\t\t\t\t";

    public static void connect_way01() throws SQLException {
        Driver driver = new Driver();
        String url = "jdbc:mysql://localhost:3306/db01";

        Properties loginInfo = new Properties();

        loginInfo.setProperty("user", "root");
        loginInfo.setProperty("password", "020914");

        Connection connection = driver.connect(url, loginInfo);

        String sql = "INSERT INTO stu(`name`) VALUES('java')";

        String sql2 = "DESC stu";

        String sql3 = "delete from stu where `name`='java'";

//        statement对象用于执行静态sql语句并返回sql执行结果封装成的对象
        Statement statement = connection.createStatement();

//        dml操作返回的是影响的行数
        int effected_rows = statement.executeUpdate(sql3);

        System.out.println(effected_rows > 0 ? "成功" : "失败");

//        及时关闭连接, 避免太多会话连接,mysql数据库
        statement.close();

        connection.close();
    }

    /**
     * @desciption 动态加载Driver类, 只需要改变driverPath,即可改变加载的Driver类
     */
    public static void connect_way02() throws SQLException,
            ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, InstantiationException,
            IllegalAccessException {
        String driverPath = "com.mysql.cj.jdbc.Driver";
        Class<?> driverClass = Class.forName(driverPath);
        Driver driver = (Driver) driverClass.getDeclaredConstructor().newInstance();

        Properties loginInfo = new Properties();

        String url = "jdbc:mysql://localhost:3306/db01";
        loginInfo.setProperty("user", "root");
        loginInfo.setProperty("password", "020914");

        Connection connection = driver.connect(url, loginInfo);
        System.out.println(connection);

        connection.close();
    }

    public static void connect_way03() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, SQLException {
        String driverPath = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/db01";
        String user = "root";
        String password = "020914";

        Class<?> driverClass = Class.forName(driverPath);
        Driver driver = (Driver) driverClass.getDeclaredConstructor().newInstance();

//        注册driver驱动
        DriverManager.registerDriver(driver);

        Connection connection = DriverManager.getConnection(url, user, password);

        System.out.println(connection);

        connection.close();
    }

    /**
     * @description 最常用的方式, 这个方式不需要手动注册驱动, 但要求在加载该Driver类信息时, 其静态代码块已
     * 自动完成驱动的注册
     */
    public static void connect_way04() throws ClassNotFoundException, SQLException {

        String driverPath = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/db01";
        String user = "root";
        String password = "020914";

        //动态加载类信息,执行静态代码块
        Class.forName(driverPath);
        /* com.mysql.cj.jdbc.Driver类的静态代码块
         *      static {
         *           try {
         *              DriverManager.registerDriver(new Driver());
         *          } catch (SQLException var1) {
         *              throw new RuntimeException("Can't register driver!");
         *          }
         *      }
         *
         * */
        /*
         * jdk1.5后 若像mysql的jar包在Driver类静态代码块就自动注册的jar包, 可以不写Class.forName(driverPath);进行动态加载也行
         * 因为 jdk1.5以后使用了 JDBC4, 会自动调用jar包下的META-INFO/services/java.sql.Driver
         * 文本中的类名称来加载类,进而执行执行mysql Driver类的静态代码块注册 Driver
         * */
        Connection connection = DriverManager.getConnection(url, user, password);

        System.out.println(connection);

        connection.close();

    }

    /**
     * @description 在方式4的基础上, 这个方式使用了一个外部的配置文件, 在配置文件中更改了
     * 相关信息,在程序中也可以动态加载,不需要再更改源代码
     */
    public static void connect_way05() throws IOException, ClassNotFoundException, SQLException {
        Properties dbConfigs = new Properties();
        dbConfigs.load(new FileInputStream("src\\learnJDBC\\dbConfigs.properties"));
        String user = dbConfigs.getProperty("user");
        String password = dbConfigs.getProperty("password");
        String driverPath = dbConfigs.getProperty("driver");
        String url = dbConfigs.getProperty("url");

        Class.forName(driverPath);

        Connection connection = DriverManager.getConnection(url, user, password);

        System.out.println(connection);

        connection.close();
    }

    public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
        Properties dbConfigs = new Properties();
        dbConfigs.load(new FileInputStream("src\\learnJDBC\\dbConfigs.properties"));
        String user = dbConfigs.getProperty("user");
        String password = dbConfigs.getProperty("password");
        String driverPath = dbConfigs.getProperty("driver");
        String url = dbConfigs.getProperty("url");

        Class.forName(driverPath);

        return DriverManager.getConnection(url, user, password);
    }

    public static void printSet(ResultSet set, String format, boolean readSetMetaData) throws SQLException {
        try {
            set.first();
        } catch (Exception e) {
            System.out.println("the set should be scrollable");
        }
        if (!set.isFirst()) {
            System.out.println("the set cursor should be the first");
//            return;
        }

        ResultSetMetaData data = set.getMetaData();
// 获得所有列的数目及实际列数
        int columnCount = data.getColumnCount();
        if (readSetMetaData) {
            System.out.println("Total column count: " + columnCount);
            for (int i = 1; i <= data.getColumnCount(); i++) {
// 获得指定列的列名
                String columnName = data.getColumnName(i);
// 获得指定列的列值
                int columnType = data.getColumnType(i);
// 获得指定列的数据类型名
                String columnTypeName = data.getColumnTypeName(i);
// 所在的Catalog名字
                String catalogName = data.getCatalogName(i);
// 对应数据类型的类
                String columnClassName = data.getColumnClassName(i);

                System.out.println("第" + i + "列\t" + columnName + "\t" + columnType + "\t" +
                        columnTypeName + "\t" + catalogName + "\t" + columnClassName);
            }
        }

        if (format.equals("")) {
            StringBuffer culumnInfoRow = new StringBuffer();
            for (int i = 1; i <= columnCount; i++) {
                culumnInfoRow.append(data.getColumnName(i));
                culumnInfoRow.append(displayInterval);
            }
            System.out.println(culumnInfoRow);
            while (set.next()) {
                StringBuffer row = new StringBuffer();
                for (int i = 1; i <= columnCount; i++) {
                    row.append(set.getString(i));
                    row.append(displayInterval);
                }
                System.out.println(row);
            }
        } else {
            System.out.println("this method is developing, it can`t format the resultSet output");
            String[] columnDisplayFormat = format.split(" ");
            int length = columnDisplayFormat.length;
            if (length < 1) {
                throw new RuntimeException("invaild format string");
            }
//            详情模式, 需要这样写 "*d fieldName n fieldName y" n不显示,y显示
            if (columnDisplayFormat[0].equals("*d")) {
                System.out.println("this method is developing, it can`t format the resultSet output");
            } else if (columnDisplayFormat[0].equals("*")) {

            }

        }

        set.first();
    }

    public static void printSet(ResultSet set) throws SQLException {
        printSet(set, "", false);
    }

    public static void printSet(ResultSet set, boolean readSetMetaData) throws SQLException {
        printSet(set, "", readSetMetaData);
    }

}
