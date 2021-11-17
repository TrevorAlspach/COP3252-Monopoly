package com.monopoly.cop3252monopoly;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {
    private int playerCount;

    @FXML
    private ImageView ivBoard;
    @FXML
    private StackPane stackPane;

    public MainWindowController(){
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        stackPane = new StackPane();
        ivBoard = new ImageView();

        stackPane.getChildren().add(ivBoard);
    }



    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }


}