package com.monopoly.cop3252monopoly;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {
    private int playerCount;

    @FXML
    private ImageView ivBoard;
    @FXML
    private StackPane stackPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        stackPane = new StackPane();
        Image image = new Image(getClass().getResourceAsStream("monopoly_photoshop_template.jpg"));
        ivBoard = new ImageView(image);
        stackPane.getChildren().add(ivBoard);
    }



    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }


}