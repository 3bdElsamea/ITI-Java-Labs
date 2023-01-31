
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
        PreparedStatement pstmt;
        ResultSet empsSet;
        int[] check;
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ITI", "root", "");
            // Creation
            query = "CREATE TABLE `iti`.`test4` (`Id` INT NULL AUTO_INCREMENT , `F_Name` VARCHAR(255) NOT NULL , `L_Name` VARCHAR(255) NOT NULL , `Gender` VARCHAR(255) NOT NULL , `Age` INT NOT NULL , `Address` VARCHAR(255) NOT NULL , `Phone_Number` VARCHAR(255) NOT NULL , `Vaction_Balance` INT NOT NULL DEFAULT '30' , PRIMARY KEY (`Id`)) ENGINE = InnoDB;";
            pstmt = conn.prepareStatement(query);
            pstmt.executeUpdate();
            System.out.println("---------- End Of Creation --------------");
            query = "INSERT IGNORE INTO test4 (F_Name, L_Name, Gender, Age, Address, Phone_Number,Vaction_Balance) "
                    + "VALUES (?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(query);
            conn.setAutoCommit(false);
            // 1
            pstmt.setString(1, "Bridget");
            pstmt.setString(2, "Fry");
            pstmt.setString(3, "F");
            pstmt.setInt(4, 2023 - 1962);
            pstmt.setString(5, "1343 Kemper Lane");
            pstmt.setString(6, "801-796-6793");
            pstmt.setInt(7, 30);
            pstmt.addBatch();

            // 2
            pstmt.setString(1, "Patrick");
            pstmt.setString(2, "Vasquez");
            pstmt.setString(3, "M");
            pstmt.setInt(4, 55);
            pstmt.setString(5, "3891 Retreat Avenue");
            pstmt.setString(6, "205-309-6128");
            pstmt.setInt(7, 30);
            pstmt.addBatch();

            // 3
            pstmt.setString(1, "April");
            pstmt.setString(2, "Witt");
            pstmt.setString(3, "F");
            pstmt.setInt(4, 21);
            pstmt.setString(5, "2794 Tea Berry Lane");
            pstmt.setString(6, "715-828-5864");
            pstmt.setInt(7, 30);
            pstmt.addBatch();

            // 4
            pstmt.setString(1, "Rebecca");
            pstmt.setString(2, "Hall");
            pstmt.setString(3, "F");
            pstmt.setInt(4, 44);
            pstmt.setString(5, "754 Saint Clair Street");
            pstmt.setString(6, "662-598-7707");
            pstmt.setInt(7, 30);
            pstmt.addBatch();

            // 5
            pstmt.setString(1, "Dwayne");
            pstmt.setString(2, "Wilkens");
            pstmt.setString(3, "M");
            pstmt.setInt(4, 26);
            pstmt.setString(5, "3594 Brooke Street");
            pstmt.setString(6, "713-655-2603");
            pstmt.setInt(7, 30);
            pstmt.addBatch();

            check = pstmt.executeBatch();
            for (int x : check)
                System.out.println(x);
            conn.commit();

            System.out.println("---------------- End Of Insert ----------------");
            // Select all to Check Insertion
            query = new String("SELECT * FROM test4");
            pstmt = conn.prepareStatement(query);
            empsSet = pstmt.executeQuery();
            while (empsSet.next()) {
                System.out.println(empsSet.getInt(1) + ":" + empsSet.getString(2) + ":" + empsSet.getString(3) + ":"
                        + empsSet.getString(4) + ":" + empsSet.getString(5) + ":"
                        + empsSet.getString(8));
            }
            System.out.println("---------- End Of Select --------------");
            // Modification
            Statement stmt = conn.createStatement();
            query = "UPDATE test4 SET Vaction_Balance = 45 WHERE Age>=45";
            stmt.addBatch(query);
            query = "UPDATE test4 SET F_Name = CONCAT('MR.',F_Name) WHERE Gender='M'";
            stmt.addBatch(query);
            query = "UPDATE test4 SET F_Name = CONCAT('MRS.',F_Name) WHERE Gender='F'";
            stmt.addBatch(query);

            check = stmt.executeBatch();
            for (int x : check)
                System.out.println(x);
            conn.commit();
            System.out.println("---------- End Of Modification --------------");
            // Select all to Check Modification
            query = new String("SELECT * FROM test4");
            pstmt = conn.prepareStatement(query);
            empsSet = pstmt.executeQuery();
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
