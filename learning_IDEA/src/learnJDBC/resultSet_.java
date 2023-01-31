package learnJDBC;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author 潘栋磊
 * @version 0.0.1
 */
public class resultSet_ {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        Connection connection = JDBCHelper.getConnection();

        Statement statement = connection.createStatement();

        String sql = "SELECT * FROM stu";

        ResultSet resultSet = statement.executeQuery(sql);

/*      _id	    name	resume	subject1	subject2	subject3
        1	    zhang		    20	        30          55.66
        2	    li		        56.22	    21.3	    12.66
        3	    jun		        52.22	    30	        55.66
        4	    sun		        52.22	    42.9	    12.66
        5	    dui		        0	        33.6	    66.3
        9	    test	        0	        0	        0
        */
        while (resultSet.next()) {
            int _id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            Float s1 = resultSet.getFloat(4);
            Float s2 = resultSet.getFloat(5);
            Float s3 = resultSet.getFloat(6);
            System.out.println(_id + "\t" + name + "\t" + s1 + "\t" + s2 + "\t" + s3);
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}
