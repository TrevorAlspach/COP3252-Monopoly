package com.monopoly.cop3252monopoly;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainWindowController {
    @FXML
    private Label welcomeText;


    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    public void myButton(ActionEvent actionEvent) {
        welcomeText.setText("TREVOR CREATED THIS BUTTON");
    }
}