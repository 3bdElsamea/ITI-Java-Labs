
package connectdb;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectDB {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/ITI";
        String username = "root";
        String password = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            // Insert Student
            String addStudent = "INSERT INTO students VALUES (null, 'Mohsen Hafez',26 ,'os','tarek@gmail.com')";
            statement.executeUpdate(addStudent);
            // Select All Students
            ResultSet selectAllSet = statement.executeQuery("select * from students");
            while (selectAllSet.next()) {
                System.out.println(
                        selectAllSet.getInt(1) + ":" + selectAllSet.getString(2) + ":" + selectAllSet.getString(3)
                                + ":" + selectAllSet.getString(4) + ":" + selectAllSet.getString(5));
            }
            // Update Student
            String updateStudent = "UPDATE students SET name = 'Abbas Helmy', email = 'osama@gmail.com' where id = 6";
            statement.executeUpdate(updateStudent);
            // Select All Students
            selectAllSet = statement.executeQuery("select * from students");
            while (selectAllSet.next()) {
                System.out.println(
                        selectAllSet.getInt(1) + ":" + selectAllSet.getString(2) + ":" + selectAllSet.getString(3)
                                + ":" + selectAllSet.getString(4) + ":" + selectAllSet.getString(5));
            }
            // Delete Student
            String deleteStudent = "DELETE FROM students WHERE id = 3";
            statement.executeUpdate(deleteStudent);
            // Select All Students
            selectAllSet = statement.executeQuery("select * from students");
            while (selectAllSet.next()) {
                System.out.println(
                        selectAllSet.getInt(1) + ":" + selectAllSet.getString(2) + ":" +
                                selectAllSet.getString(3)
                                + ":" + selectAllSet.getString(4) + ":" + selectAllSet.getString(5));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
