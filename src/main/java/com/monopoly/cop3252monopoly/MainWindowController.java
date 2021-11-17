package com.monopoly.cop3252monopoly;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {
    private int playerCount;

    @FXML
    private ImageView ivBoard;
    @FXML
    private ImageView piece1;
    @FXML
    private ImageView piece2;
    @FXML
    private ImageView piece3;
    @FXML
    private ImageView piece4;



    public MainWindowController(){

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(this::initializePieces);
    }

    public void runGame(){

    }


    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }

    private void initializePieces()
    {
        piece1.setX(575);
        piece1.setY(465);
        piece2.setX(575);
        piece2.setY(485);
        if (playerCount == 3 || playerCount == 4){
            piece3.setX(575);
            piece3.setY(505);
        }
        if (playerCount == 4){
            piece4.setX(575);
            piece4.setY(515);
        }
        if (playerCount == 2){
            //make first two dissapear
        }
    }


}