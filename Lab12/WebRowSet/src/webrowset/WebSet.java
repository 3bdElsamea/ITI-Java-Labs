
package webrowset;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

public class WebSet {
    public void actions() {
        try {
            RowSetFactory factory = RowSetProvider.newFactory();
            WebRowSet webSet = factory.createWebRowSet();
            webSet.setCommand("SELECT * FROM students");
            webSet.setUrl("jdbc:mysql://localhost:3306/ITI");
            webSet.setUsername("root");
            webSet.setPassword("");
            webSet.execute();
            FileOutputStream out = new FileOutputStream("studentsList.xml");
            webSet.writeXml(out);
            System.out.println("Exported To XML file");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        WebSet webSet = new WebSet();
        webSet.actions();

    }

}
