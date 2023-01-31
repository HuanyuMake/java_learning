package learnJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 潘栋磊
 * @version 0.0.1
 */
public class preparedStatement_ {
    public static void main(String[] args) throws SQLException {
        JDBCUtils mysqlHelper = new JDBCUtils("src\\learnJDBC\\dbConfigs.properties");


        Connection connection = mysqlHelper.getConnection();

        String sql = "insert into stu(`name`) values (?);";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, "preparedStatement_");

//        int effected_rows = preparedStatement.executeUpdate();

//        System.out.println(effected_rows > 0 ? "成功" : "失败");

        JDBCUtils.displayInterval = "\t\t\t";

        sql = "select _id, `name`, subject1 as s1, subject2 as s2, subject3 as s3 from stu";

        preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE);

        ResultSet resultSet = preparedStatement.executeQuery();

//        System.out.println(resultSet);

        JDBCUtils.printSet(resultSet);

        JDBCUtils.close(preparedStatement, resultSet, connection);

    }
}
