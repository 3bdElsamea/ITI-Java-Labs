/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworld;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author lenovo
 */
public class HelloWorld extends Application {

    @Override
    public void start(Stage primaryStage) {
        Text helloWorldTxt = new Text();
        helloWorldTxt.setText("Hello World");
        helloWorldTxt.setStyle("-fx-font: 40 arial; -fx-fill: red; -fx-stroke: black; -fx-stroke-width: 1;");

        Reflection reflection = new Reflection();
        reflection.setFraction(1);
        helloWorldTxt.setEffect(reflection);

        StackPane rootPane = new StackPane();
        rootPane.getChildren().add(helloWorldTxt);
        Stop[] stops = new Stop[] { new Stop(0, Color.BLACK), new Stop(0.5, Color.WHITE), new Stop(1, Color.BLACK) };
        LinearGradient backGroundLabel = new LinearGradient(0, 0.2, 0, 1, true, CycleMethod.NO_CYCLE, stops);
        Scene scene = new Scene(rootPane, 300, 250, backGroundLabel);

        primaryStage.setTitle("Hello World Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
