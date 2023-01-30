package HelloWorldCss;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloWorldCss extends Application {

    @Override
    public void start(Stage primaryStage) {
        Text helloWorldTxt = new Text();
        helloWorldTxt.setText("Hello World ");
        helloWorldTxt.setStyle("-fx-font: 40 arial; -fx-fill: red; -fx-stroke: black; -fx-stroke-width: 1;");

        Reflection reflection = new Reflection();
        reflection.setFraction(1);
        helloWorldTxt.setEffect(reflection);

        StackPane rootPane = new StackPane();
        rootPane.getChildren().add(helloWorldTxt);
        rootPane.setId("backGroundLG");
        Scene scene = new Scene(rootPane, 300, 250);
        scene.getStylesheets().add(getClass().getResource("style.css").toString());
        primaryStage.setTitle("Hello World Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}