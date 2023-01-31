package learnJDBC;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author 潘栋磊
 * @version 0.0.1
 */
public class JDBCUtils {
    private String user;
    private String password;
    private String url;
    private String driver;

    static String displayInterval = "\t\t\t\t\t\t\t";

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getUrl() {
        return url;
    }

    public String getDriver() {
        return driver;
    }

    public String getPath() {
        return path;
    }

    private String path = "src\\dbConfigs.properties";

    private boolean configLoaded;

    public JDBCUtils setConfig(String path) {
        try {
            loadConfig(path);
        } catch (IOException e) {
            throw new RuntimeException("Can`t find the config file");
        }
        return this;
    }

    public JDBCUtils setConfig(String user, String password, String url, String driver) {
        Properties config = new Properties();
        config.setProperty("user", user);
        config.setProperty("password", password);
        config.setProperty("url", url);
        config.setProperty("driver", driver);

        loadConfig(config);

        return this;
    }

    private void loadConfig(String path) throws IOException {
        Properties config = new Properties();
        config.load(new FileInputStream(path));
        loadConfig(config);
    }

    private void loadConfig(Properties config) {
        user = config.getProperty("user");
        password = config.getProperty("password");
        url = config.getProperty("url");
        driver = config.getProperty("driver");
        if (user == null || password == null || url == null || driver == null) {
            throw new RuntimeException("Config properties user, password, url, driver should not be null");
        }
        configLoaded = true;
    }


    public JDBCUtils() {
        try {
            loadConfig(path);
        } catch (IOException e) {
            throw new RuntimeException("The config file cannot be found from the default path: " + path);
        }
    }

    public JDBCUtils(String configFilePath) {
        try {
            loadConfig(configFilePath);
        } catch (IOException e) {
            throw new RuntimeException("The config file cannot be found from the default path: " + configFilePath);
        }
    }

    public JDBCUtils(String user, String password, String url, String driver) {
        setConfig(user, password, url, driver);
    }

    public Connection getConnection() {
        if (configLoaded) {
            try {
                Class.forName(driver);
                return DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                throw new RuntimeException("Can`t get a connection, Error info: " + e.getMessage());
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("Can`t find the driver class");
            }
        } else {
            throw new RuntimeException("Can`t get a connection before the config setting successfully");
        }
    }

    public static void close(Connection... cs) {
        if (cs.length > 0) {
            try {
                for (Connection c : cs) {
                    if (c != null) {
                        c.close();
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void close(ResultSet... rs) {
        if (rs.length > 0) {
            try {
                for (ResultSet r : rs) {
                    if (r != null) {
                        r.close();
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void close(Statement... ss) {
        if (ss.length > 0) {
            try {
                for (Statement s : ss) {
                    if (s != null) {
                        s.close();
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public static void close(ResultSet r, Connection c) {
        close(r);
        close(c);
    }

    public static void close(Connection c, ResultSet r) {
        close(r);
        close(c);
    }

    public static void close(ResultSet r, Statement s, Connection c) {
        close(s);
        close(r);
        close(c);
    }

    public static void close(ResultSet r, Connection c, Statement s) {
        close(s);
        close(r);
        close(c);
    }

    public static void close(Connection c, ResultSet r, Statement s) {
        close(s);
        close(r);
        close(c);
    }

    public static void close(Connection c, Statement s, ResultSet r) {
        close(s);
        close(r);
        close(c);
    }

    public static void close(Statement s, ResultSet r, Connection c) {
        close(s);
        close(r);
        close(c);
    }

    public static void close(Statement s, Connection c, ResultSet r) {
        close(s);
        close(r);
        close(c);
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

        try {
            set.first();
        } catch (Exception e) {
            System.out.println("the set should be scrollable");
        }
    }

    public static void printSet(ResultSet set) throws SQLException {
        printSet(set, "", false);
    }

    public static void printSet(ResultSet set, boolean readSetMetaData) throws SQLException {
        printSet(set, "", readSetMetaData);
    }


}
