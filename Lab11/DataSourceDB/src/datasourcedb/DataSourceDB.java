package datasourcedb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class DataSourceDB {

    public static void main(String[] args) {
        Properties prop = new Properties();
        OutputStream output = null;
        try {
            output = new FileOutputStream("iلti.properties");
            prop.setProperty(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.RefFSContextFactory");
            prop.setProperty("MYSQL_DB_URL", "jdbc:mysql://localhost:3306/ITI");
            prop.setProperty("MYSQL_DB_USERNAME", "root");
            prop.setProperty("MYSQL_DB_PASSWORD", "");
            prop.store(output, null);
            Context ctx = new InitialContext(prop);
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/ITI");
            Connection connection = ds.getConnection();
            Statement statement = connection.createStatement();
            // Insert Student
            // String addStudent = "INSERT INTO students VALUES (null, 'Omar',26
            // ,'os','Omar@gmail.com'";
            // statement.executeUpdate(addStudent);
            // Select All Students
            ResultSet selectAllSet = statement.executeQuery("select * from students");
            while (selectAllSet.next()) {
                System.out.println(
                        selectAllSet.getInt(1) + ":" + selectAllSet.getString(2) + ":" + selectAllSet.getString(3)
                                + ":" + selectAllSet.getString(4) + ":" + selectAllSet.getString(5));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (NamingException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

}
