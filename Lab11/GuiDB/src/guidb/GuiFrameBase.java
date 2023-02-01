package guidb;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class GuiFrameBase extends Pane {

    protected final Label idLabel;
    protected final Label fNameLabel;
    protected final Label mNameLabel;
    protected final Label lNameLabel;
    protected final Label emailLabel;
    protected final Label phoneLable;
    protected final TextField idField;
    protected final TextField fNameField;
    protected final TextField mNameField;
    protected final TextField lNameField;
    protected final TextField emailField;
    protected final TextField phoneField;
    protected final Button newBtn;
    protected final Button lastBtn;
    protected final Button nextBtn;
    protected final Button prevBtn;
    protected final Button firstBtn;
    protected final Button delBtn;
    protected final Button updBtn;

    public GuiFrameBase() {

        idLabel = new Label();
        fNameLabel = new Label();
        mNameLabel = new Label();
        lNameLabel = new Label();
        emailLabel = new Label();
        phoneLable = new Label();
        idField = new TextField();
        fNameField = new TextField();
        mNameField = new TextField();
        lNameField = new TextField();
        emailField = new TextField();
        phoneField = new TextField();
        newBtn = new Button();
        lastBtn = new Button();
        nextBtn = new Button();
        prevBtn = new Button();
        firstBtn = new Button();
        delBtn = new Button();
        updBtn = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        idLabel.setLayoutX(37.0);
        idLabel.setLayoutY(28.0);
        idLabel.setPrefHeight(26.0);
        idLabel.setPrefWidth(79.0);
        idLabel.setText("ID");

        fNameLabel.setLayoutX(37.0);
        fNameLabel.setLayoutY(67.0);
        fNameLabel.setPrefHeight(26.0);
        fNameLabel.setPrefWidth(79.0);
        fNameLabel.setText("First Name");

        mNameLabel.setLayoutX(37.0);
        mNameLabel.setLayoutY(235.0);
        mNameLabel.setPrefHeight(26.0);
        mNameLabel.setPrefWidth(46.0);
        mNameLabel.setText("Phone");

        lNameLabel.setLayoutX(37.0);
        lNameLabel.setLayoutY(187.0);
        lNameLabel.setPrefHeight(26.0);
        lNameLabel.setPrefWidth(79.0);
        lNameLabel.setText("Email");

        emailLabel.setLayoutX(37.0);
        emailLabel.setLayoutY(146.0);
        emailLabel.setPrefHeight(26.0);
        emailLabel.setPrefWidth(79.0);
        emailLabel.setText("Last Name");

        phoneLable.setLayoutX(37.0);
        phoneLable.setLayoutY(104.0);
        phoneLable.setPrefHeight(26.0);
        phoneLable.setPrefWidth(79.0);
        phoneLable.setText("Middle Name");

        idField.setDisable(true);
        idField.setLayoutX(148.0);
        idField.setLayoutY(29.0);
        idField.setPrefHeight(25.0);
        idField.setPrefWidth(339.0);

        fNameField.setLayoutX(148.0);
        fNameField.setLayoutY(68.0);
        fNameField.setPrefHeight(25.0);
        fNameField.setPrefWidth(339.0);

        mNameField.setLayoutX(148.0);
        mNameField.setLayoutY(105.0);
        mNameField.setPrefHeight(25.0);
        mNameField.setPrefWidth(339.0);

        lNameField.setLayoutX(148.0);
        lNameField.setLayoutY(147.0);
        lNameField.setPrefHeight(25.0);
        lNameField.setPrefWidth(339.0);

        emailField.setLayoutX(148.0);
        emailField.setLayoutY(188.0);
        emailField.setPrefHeight(25.0);
        emailField.setPrefWidth(339.0);

        phoneField.setLayoutX(148.0);
        phoneField.setLayoutY(236.0);
        phoneField.setPrefHeight(25.0);
        phoneField.setPrefWidth(339.0);

        newBtn.setLayoutX(51.0);
        newBtn.setLayoutY(330.0);
        newBtn.setMnemonicParsing(false);
        newBtn.setText("New");

        lastBtn.setLayoutX(496.0);
        lastBtn.setLayoutY(330.0);
        lastBtn.setMnemonicParsing(false);
        lastBtn.setText("Last");

        nextBtn.setLayoutX(433.0);
        nextBtn.setLayoutY(330.0);
        nextBtn.setMnemonicParsing(false);
        nextBtn.setText("Next");

        prevBtn.setLayoutX(349.0);
        prevBtn.setLayoutY(330.0);
        prevBtn.setMnemonicParsing(false);
        prevBtn.setText("Previous");

        firstBtn.setLayoutX(290.0);
        firstBtn.setLayoutY(330.0);
        firstBtn.setMnemonicParsing(false);
        firstBtn.setText("First");

        delBtn.setLayoutX(191.0);
        delBtn.setLayoutY(330.0);
        delBtn.setMnemonicParsing(false);
        delBtn.setText("Delete");

        updBtn.setLayoutX(116.0);
        updBtn.setLayoutY(330.0);
        updBtn.setMnemonicParsing(false);
        updBtn.setText("Update");

        getChildren().add(idLabel);
        getChildren().add(fNameLabel);
        getChildren().add(mNameLabel);
        getChildren().add(lNameLabel);
        getChildren().add(emailLabel);
        getChildren().add(phoneLable);
        getChildren().add(idField);
        getChildren().add(fNameField);
        getChildren().add(mNameField);
        getChildren().add(lNameField);
        getChildren().add(emailField);
        getChildren().add(phoneField);
        getChildren().add(newBtn);
        getChildren().add(lastBtn);
        getChildren().add(nextBtn);
        getChildren().add(prevBtn);
        getChildren().add(firstBtn);
        getChildren().add(delBtn);
        getChildren().add(updBtn);

    }
}
