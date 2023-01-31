
package batchdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchDB {

    public static void main(String[] args) {
        Connection conn = null;
        String query;
        PreparedStatement prepStatement;
        ResultSet empsSet;
        int[] check;
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ITI", "root", "");
            // Creation
            query = "CREATE TABLE `iti`.`test` (`Id` INT NULL AUTO_INCREMENT , `F_Name` VARCHAR(255) NOT NULL , `L_Name` VARCHAR(255) NOT NULL , `Gender` VARCHAR(255) NOT NULL , `Age` INT NOT NULL , `Address` VARCHAR(255) NOT NULL , `Phone_Number` VARCHAR(255) NOT NULL , `Vaction_Balance` INT NOT NULL DEFAULT '30' , PRIMARY KEY (`Id`)) ENGINE = InnoDB;";
            prepStatement = conn.prepareStatement(query);
            prepStatement.executeUpdate();
            System.out.println("---------- End Of Creation --------------");
            // Insertion
            query = "INSERT IGNORE INTO test (F_Name, L_Name, Gender, Age, Address, Phone_Number,Vaction_Balance) "
                    + "VALUES (?,?,?,?,?,?,?)";
            prepStatement = conn.prepareStatement(query);
            conn.setAutoCommit(false);
            // 1
            prepStatement.setString(1, "Bridget");
            prepStatement.setString(2, "Fry");
            prepStatement.setString(3, "F");
            prepStatement.setInt(4, 2023 - 1962);
            prepStatement.setString(5, "1343 Kemper Lane");
            prepStatement.setString(6, "801-796-6793");
            prepStatement.setInt(7, 30);
            prepStatement.addBatch();

            // 2
            prepStatement.setString(1, "Patrick");
            prepStatement.setString(2, "Vasquez");
            prepStatement.setString(3, "M");
            prepStatement.setInt(4, 55);
            prepStatement.setString(5, "3891 Retreat Avenue");
            prepStatement.setString(6, "205-309-6128");
            prepStatement.setInt(7, 30);
            prepStatement.addBatch();

            // 3
            prepStatement.setString(1, "April");
            prepStatement.setString(2, "Witt");
            prepStatement.setString(3, "F");
            prepStatement.setInt(4, 21);
            prepStatement.setString(5, "2794 Tea Berry Lane");
            prepStatement.setString(6, "715-828-5864");
            prepStatement.setInt(7, 30);
            prepStatement.addBatch();

            // 4
            prepStatement.setString(1, "Rebecca");
            prepStatement.setString(2, "Hall");
            prepStatement.setString(3, "F");
            prepStatement.setInt(4, 44);
            prepStatement.setString(5, "754 Saint Clair Street");
            prepStatement.setString(6, "662-598-7707");
            prepStatement.setInt(7, 30);
            prepStatement.addBatch();

            // 5
            prepStatement.setString(1, "Dwayne");
            prepStatement.setString(2, "Wilkens");
            prepStatement.setString(3, "M");
            prepStatement.setInt(4, 26);
            prepStatement.setString(5, "3594 Brooke Street");
            prepStatement.setString(6, "713-655-2603");
            prepStatement.setInt(7, 30);
            prepStatement.addBatch();

            check = prepStatement.executeBatch();
            for (int x : check)
                System.out.println(x);
            conn.commit();
            System.out.println("---------------- End Of Insert ----------------");

            // Select all to Check Insertion
            query = new String("SELECT * FROM test");
            prepStatement = conn.prepareStatement(query);
            empsSet = prepStatement.executeQuery();
            while (empsSet.next()) {
                System.out.println(empsSet.getInt(1) + ":" + empsSet.getString(2) + ":" + empsSet.getString(3) + ":"
                        + empsSet.getString(4) + ":" + empsSet.getString(5) + ":"
                        + empsSet.getString(8));
            }
            System.out.println("---------- End Of Select --------------");

            // Modification
            Statement statement = conn.createStatement();
            query = "UPDATE test SET Vaction_Balance = 45 WHERE Age>=45";
            statement.addBatch(query);
            query = "UPDATE test SET F_Name = CONCAT('MR.',F_Name) WHERE Gender='M'";
            statement.addBatch(query);
            query = "UPDATE test SET F_Name = CONCAT('MRS.',F_Name) WHERE Gender='F'";
            statement.addBatch(query);

            check = statement.executeBatch();
            for (int x : check)
                System.out.println(x);
            conn.commit();
            System.out.println("---------- End Of Modification --------------");

            // Select all to Check Modification
            query = new String("SELECT * FROM test");
            prepStatement = conn.prepareStatement(query);
            empsSet = prepStatement.executeQuery();
            while (empsSet.next()) {
                System.out.println(empsSet.getInt(1) + ":" + empsSet.getString(2) + ":" + empsSet.getString(3) + ":"
                        + empsSet.getString(4) + ":" + empsSet.getString(5) + ":"
                        + empsSet.getString(8));
            }
            System.out.println("---------- End Of Select --------------");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
