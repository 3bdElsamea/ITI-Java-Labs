package datasourcedb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

public class DataSourceDB {

    public static void main(String[] args) {
        dataSource();
    }

    // Function
    public static void dataSource() {
        Connection conn = null;
        Statement statement = null;
        ResultSet selectAllSet = null;
        try {
            DataSource ds = DataSourceFactory.getMySQLDataSource();
            conn = ds.getConnection();
            statement = conn.createStatement();
            selectAllSet = statement.executeQuery("select * from students");
            while (selectAllSet.next()) {
                System.out.println(
                        selectAllSet.getInt(1) + ":" + selectAllSet.getString(2) + ":" + selectAllSet.getString(3)
                                + ":" + selectAllSet.getString(4) + ":" + selectAllSet.getString(5));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (selectAllSet != null)
                    selectAllSet.close();
                if (statement != null)
                    statement.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
