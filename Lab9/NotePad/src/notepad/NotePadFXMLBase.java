package notepad;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;

public class NotePadFXMLBase extends BorderPane {

    protected final MenuBar menuBar;
    protected final Menu fileMenu;
    protected final MenuItem newOption;
    protected final MenuItem openOption;
    protected final MenuItem saveOption;
    protected final SeparatorMenuItem fileSeparator;
    protected final MenuItem exitOption;
    protected final Menu exitMenu;
    protected final MenuItem undoOption;
    protected final SeparatorMenuItem editSeparator1;
    protected final MenuItem cutOption;
    protected final MenuItem copyOption;
    protected final MenuItem pasteOption;
    protected final MenuItem deleteOption;
    protected final SeparatorMenuItem separatorMenuItem1;
    protected final MenuItem selectOption;
    protected final Menu helpMenu;
    protected final MenuItem aboutOption;
    protected final TextArea textArea;

    public NotePadFXMLBase() {

        menuBar = new MenuBar();
        fileMenu = new Menu();
        newOption = new MenuItem();
        openOption = new MenuItem();
        saveOption = new MenuItem();
        fileSeparator = new SeparatorMenuItem();
        exitOption = new MenuItem();
        exitMenu = new Menu();
        undoOption = new MenuItem();
        editSeparator1 = new SeparatorMenuItem();
        cutOption = new MenuItem();
        copyOption = new MenuItem();
        pasteOption = new MenuItem();
        deleteOption = new MenuItem();
        separatorMenuItem1 = new SeparatorMenuItem();
        selectOption = new MenuItem();
        helpMenu = new Menu();
        aboutOption = new MenuItem();
        textArea = new TextArea();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(menuBar, javafx.geometry.Pos.CENTER);

        fileMenu.setMnemonicParsing(false);
        fileMenu.setText("File");

        newOption.setMnemonicParsing(false);
        newOption.setText("New");
        newOption.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN));

        openOption.setMnemonicParsing(false);
        openOption.setText("Open");
        openOption.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN));

        saveOption.setMnemonicParsing(false);
        saveOption.setText("Save");
        saveOption.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));

        fileSeparator.setMnemonicParsing(false);

        exitOption.setMnemonicParsing(false);
        exitOption.setText("Exit");
        exitOption.setAccelerator(new KeyCodeCombination(KeyCode.E, KeyCombination.CONTROL_DOWN));

        exitMenu.setMnemonicParsing(false);
        exitMenu.setText("Edit");

        undoOption.setMnemonicParsing(false);
        undoOption.setText("Undo");

        editSeparator1.setMnemonicParsing(false);

        cutOption.setMnemonicParsing(false);
        cutOption.setText("Cut");

        copyOption.setMnemonicParsing(false);
        copyOption.setText("Copy");

        pasteOption.setMnemonicParsing(false);
        pasteOption.setText("Paste");

        deleteOption.setMnemonicParsing(false);
        deleteOption.setText("Delete");

        separatorMenuItem1.setMnemonicParsing(false);

        selectOption.setMnemonicParsing(false);
        selectOption.setText("Select All");

        helpMenu.setMnemonicParsing(false);
        helpMenu.setText("Help");

        aboutOption.setMnemonicParsing(false);
        aboutOption.setText("About NotePad");
        setTop(menuBar);

        BorderPane.setAlignment(textArea, javafx.geometry.Pos.CENTER);
        textArea.setPrefHeight(200.0);
        textArea.setPrefWidth(200.0);

        textArea.setPrefRowCount(50);
        textArea.setPrefColumnCount(50);
        setCenter(textArea);

        fileMenu.getItems().add(newOption);
        fileMenu.getItems().add(openOption);
        fileMenu.getItems().add(saveOption);
        fileMenu.getItems().add(fileSeparator);
        fileMenu.getItems().add(exitOption);
        menuBar.getMenus().add(fileMenu);
        exitMenu.getItems().add(undoOption);
        exitMenu.getItems().add(editSeparator1);
        exitMenu.getItems().add(cutOption);
        exitMenu.getItems().add(copyOption);
        exitMenu.getItems().add(pasteOption);
        exitMenu.getItems().add(deleteOption);
        exitMenu.getItems().add(separatorMenuItem1);
        exitMenu.getItems().add(selectOption);
        menuBar.getMenus().add(exitMenu);
        helpMenu.getItems().add(aboutOption);
        menuBar.getMenus().add(helpMenu);

        // Handling the new option
        newOption.setOnAction(e -> {
            textArea.clear();
        });

        // Handiling the open option
        openOption.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open File");
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                    new FileChooser.ExtensionFilter("All Files", "*.*"));
            File selectedFile = fileChooser.showOpenDialog(null);
            if (selectedFile != null) {
                try (Scanner scanner = new Scanner(selectedFile);) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        textArea.appendText(line + "");
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(NotePadFXMLBase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        // Handling the save option
        saveOption.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save File");
            fileChooser.setInitialFileName("Untitled.txt");
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                    new FileChooser.ExtensionFilter("All Files", "*.*"));
            File selectedFile = fileChooser.showSaveDialog(null);
            if (selectedFile != null) {
                try {
                    FileWriter fileWriter = new FileWriter(selectedFile);
                    fileWriter.write(textArea.getText());
                    fileWriter.close();
                } catch (IOException ex) {
                    Logger.getLogger(NotePadFXMLBase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        // Handling the exit option
        exitOption.setOnAction(e -> {
            Platform.exit();
        });

        // Handling the cut option
        cutOption.setOnAction(e -> {
            textArea.cut();
        });

        // Handling the copy option
        copyOption.setOnAction(e -> {
            textArea.copy();
        });

        // Handling the paste option
        pasteOption.setOnAction(e -> {
            textArea.paste();
        });

        // Handling the delete option
        deleteOption.setOnAction(e -> {
            textArea.deleteText(textArea.getSelection());
        });

        // Handling the select all option
        selectOption.setOnAction(e -> {
            textArea.selectAll();
        });

        // Handling the about option
        aboutOption.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("About NotePad");
            alert.setHeaderText("About NotePad");
            alert.setContentText("This is a simple notepad application made using JavaFX");
            alert.showAndWait();
        });

    }
}
