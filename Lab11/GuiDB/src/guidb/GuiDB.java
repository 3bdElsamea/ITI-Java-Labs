/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guidb;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GuiDB extends Application {
    static boolean flag = true;
    static ResultSet dataSet = null;

    @Override
    public void start(Stage primaryStage) {
        GuiFrameBase root = new GuiFrameBase();
        Scene scene = new Scene(root, 600, 450);
        primaryStage.setTitle("Gui DataBase");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Connect to the database
        Connection conn = null;
        Statement stmt = null;
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ITI", "root", "");
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE,
                    ResultSet.HOLD_CURSORS_OVER_COMMIT);
            dataSet = stmt.executeQuery("SELECT * FROM guidb");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        // Show First Row
        try {
            dataSet.first();
            root.idField.setText(dataSet.getString(1));
            root.fNameField.setText(dataSet.getString(2));
            root.mNameField.setText(dataSet.getString(3));
            root.lNameField.setText(dataSet.getString(4));
            root.emailField.setText(dataSet.getString(5));
            root.phoneField.setText(dataSet.getString(6));
        } catch (SQLException ex) {
            Logger.getLogger(GuiDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Handling New Button
        root.newBtn.setOnAction((e) -> {
            root.idField.setText("");
            root.fNameField.setText("");
            root.mNameField.setText("");
            root.lNameField.setText("");
            root.emailField.setText("");
            root.phoneField.setText("");
            flag = false;
        });

        // Handling Update Button
        root.updBtn.setOnAction((e) -> {
            if (flag) {
                try {
                    // dataSet.updateString(1, root.idField.getText());
                    dataSet.updateString(2, root.fNameField.getText());
                    dataSet.updateString(3, root.mNameField.getText());
                    dataSet.updateString(4, root.lNameField.getText());
                    dataSet.updateString(5, root.emailField.getText());
                    dataSet.updateString(6, root.phoneField.getText());
                    dataSet.updateRow();
                } catch (SQLException exc) {
                    System.out.println(exc.getMessage());
                }
            } else {
                try {
                    dataSet.moveToInsertRow();
                    dataSet.updateString(2, root.fNameField.getText());
                    dataSet.updateString(3, root.mNameField.getText());
                    dataSet.updateString(4, root.lNameField.getText());
                    dataSet.updateString(5, root.emailField.getText());
                    dataSet.updateString(6, root.phoneField.getText());
                    dataSet.insertRow();
                    dataSet.moveToCurrentRow();
                    flag = true;
                } catch (SQLException exc) {
                    System.out.println(exc.getMessage());
                }
            }

        });

        // Handling Delete Button
        root.delBtn.setOnAction((e) -> {
            try {
                dataSet.deleteRow();
                dataSet.first();
                root.idField.setText(dataSet.getString(1));
                root.fNameField.setText(dataSet.getString(2));
                root.mNameField.setText(dataSet.getString(3));
                root.lNameField.setText(dataSet.getString(4));
                root.emailField.setText(dataSet.getString(5));
                root.phoneField.setText(dataSet.getString(6));
            } catch (SQLException exc) {
                System.out.println(exc.getMessage());
            }
        });

        // Handling First Button
        root.firstBtn.setOnAction((e) -> {
            try {
                dataSet.first();
                root.idField.setText(dataSet.getString(1));
                root.fNameField.setText(dataSet.getString(2));
                root.mNameField.setText(dataSet.getString(3));
                root.lNameField.setText(dataSet.getString(4));
                root.emailField.setText(dataSet.getString(5));
                root.phoneField.setText(dataSet.getString(6));
            } catch (SQLException exc) {
                System.out.println(exc.getMessage());
            }
        });

        // Handling Previous Button
        root.prevBtn.setOnAction((e) -> {
            try {
                dataSet.previous();
                root.idField.setText(dataSet.getString(1));
                root.fNameField.setText(dataSet.getString(2));
                root.mNameField.setText(dataSet.getString(3));
                root.lNameField.setText(dataSet.getString(4));
                root.emailField.setText(dataSet.getString(5));
                root.phoneField.setText(dataSet.getString(6));
            } catch (SQLException exc) {
                System.out.println(exc.getMessage());
            }
        });

        // Handling Next Button
        root.nextBtn.setOnAction((e) -> {
            try {
                dataSet.next();
                root.idField.setText(dataSet.getString(1));
                root.fNameField.setText(dataSet.getString(2));
                root.mNameField.setText(dataSet.getString(3));
                root.lNameField.setText(dataSet.getString(4));
                root.emailField.setText(dataSet.getString(5));
                root.phoneField.setText(dataSet.getString(6));
            } catch (SQLException exc) {
                System.out.println(exc.getMessage());
            }
        });

        // Handling Last Button
        root.lastBtn.setOnAction((e) -> {
            try {
                dataSet.last();
                root.idField.setText(dataSet.getString(1));
                root.fNameField.setText(dataSet.getString(2));
                root.mNameField.setText(dataSet.getString(3));
                root.lNameField.setText(dataSet.getString(4));
                root.emailField.setText(dataSet.getString(5));
                root.phoneField.setText(dataSet.getString(6));
            } catch (SQLException exc) {
                System.out.println(exc.getMessage());
            }
        });

    }

    public static void main(String[] args) {
        launch(args);
    }

}
