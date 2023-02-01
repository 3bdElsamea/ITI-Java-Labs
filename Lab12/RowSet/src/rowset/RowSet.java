
package rowset;

import java.sql.SQLException;

import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

// Implemet RowListener
class MyRowSetListener implements RowSetListener {

    @Override
    public void cursorMoved(RowSetEvent event) {
        System.out.println("Cursor Moved");
    }

    @Override
    public void rowChanged(RowSetEvent event) {
        System.out.println("Row Changed");
    }

    @Override
    public void rowSetChanged(RowSetEvent event) {
        System.out.println("RowSet Changed");
    }
}

public class RowSet {

    public void actions(MyRowSetListener rowSetObj) {
        try {
            RowSetFactory factory = RowSetProvider.newFactory();
            JdbcRowSet jdbcSet = factory.createJdbcRowSet();
            jdbcSet.setUrl("jdbc:mysql://localhost:3306/ITI");
            jdbcSet.setUsername("root");
            jdbcSet.setPassword("");
            jdbcSet.setCommand("SELECT * FROM students");
            jdbcSet.execute();
            jdbcSet.addRowSetListener(rowSetObj);
            jdbcSet.first();
            jdbcSet.next();
            jdbcSet.previous();
            jdbcSet.absolute(2);
            // Update
            jdbcSet.updateString(2, "Amr");
            jdbcSet.updateRow();
            System.out.println("Student ID: " + jdbcSet.getString(1) + ":::" + "Student Name: " + jdbcSet.getString(2)
                    + ":::" + "Student Age: "
                    + jdbcSet.getString(3));
            // delete
            // jdbcSet.deleteRow();
            // Insert
            jdbcSet.moveToInsertRow();
            jdbcSet.updateString(2, "Mohamed");
            jdbcSet.updateInt(3, 20);
            jdbcSet.updateString(4, "pd");
            jdbcSet.updateString(5, "mohamed@hotmail.com");
            jdbcSet.insertRow();
            jdbcSet.moveToCurrentRow();
            System.out.println("Student ID: " + jdbcSet.getString(1) + ":::" + "Student Name: " + jdbcSet.getString(2)
                    + ":::" + "Student Age: "
                    + jdbcSet.getString(3));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyRowSetListener RowSetListener = new MyRowSetListener();
        RowSet rowSet = new RowSet();
        rowSet.actions(RowSetListener);
    }

}
