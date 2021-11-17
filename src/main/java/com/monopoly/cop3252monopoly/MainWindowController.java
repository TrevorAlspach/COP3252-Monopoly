package com.monopoly.cop3252monopoly;

import com.monopoly.cop3252monopoly.models.Player;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.*;

public class MainWindowController implements Initializable {
    public static Map<Integer, ArrayList<Integer>> xyValues = new HashMap<>(){{
        put(0, new ArrayList<>(Arrays.asList(845, 715)));
        put(1, new ArrayList<>(Arrays.asList(785, 715)));
        put(2, new ArrayList<>(Arrays.asList(720, 715)));
        put(3, new ArrayList<>(Arrays.asList(655, 715)));
        put(4, new ArrayList<>(Arrays.asList(590, 715)));
        put(5, new ArrayList<>(Arrays.asList(525, 715)));
        put(6, new ArrayList<>(Arrays.asList(460, 715)));
        put(7, new ArrayList<>(Arrays.asList(395, 715)));
        put(8, new ArrayList<>(Arrays.asList(330, 715)));
        put(9, new ArrayList<>(Arrays.asList(265, 715)));
        put(10, new ArrayList<>(Arrays.asList(140, 715)));
        put(11, new ArrayList<>(Arrays.asList(140, 650)));
        put(12, new ArrayList<>(Arrays.asList(140, 585)));
        put(13, new ArrayList<>(Arrays.asList(140, 520)));
        put(14, new ArrayList<>(Arrays.asList(140, 455)));
        put(15, new ArrayList<>(Arrays.asList(140, 390)));
        put(16, new ArrayList<>(Arrays.asList(140, 325)));
        put(17, new ArrayList<>(Arrays.asList(140, 260)));
        put(18, new ArrayList<>(Arrays.asList(140, 195)));
        put(19, new ArrayList<>(Arrays.asList(140, 130)));
        put(20, new ArrayList<>(Arrays.asList(140, 45)));
        put(21, new ArrayList<>(Arrays.asList(265, 45)));
        put(22, new ArrayList<>(Arrays.asList(330, 45)));
        put(23, new ArrayList<>(Arrays.asList(395, 45)));
        put(24, new ArrayList<>(Arrays.asList(460, 45)));
        put(25, new ArrayList<>(Arrays.asList(525, 45)));
        put(26, new ArrayList<>(Arrays.asList(590, 45)));
        put(27, new ArrayList<>(Arrays.asList(655, 45)));
        put(28, new ArrayList<>(Arrays.asList(710, 45)));
        put(29, new ArrayList<>(Arrays.asList(775, 45)));
        put(30, new ArrayList<>(Arrays.asList(855, 45)));
        put(31, new ArrayList<>(Arrays.asList(855, 130)));
        put(32, new ArrayList<>(Arrays.asList(855, 195)));
        put(33, new ArrayList<>(Arrays.asList(855, 260)));
        put(34, new ArrayList<>(Arrays.asList(855, 325)));
        put(35, new ArrayList<>(Arrays.asList(855, 390)));
        put(36, new ArrayList<>(Arrays.asList(855, 455)));
        put(37, new ArrayList<>(Arrays.asList(855, 520)));
        put(38, new ArrayList<>(Arrays.asList(855, 585)));
        put(39, new ArrayList<>(Arrays.asList(855, 650)));
        //Need to add Railroads and Utilities
    }};
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
    @FXML
    private Label playerLabel;

    private Player currentPlayer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(this::initializePieces);
        Platform.runLater(this::initializeGame);
    }

    public void initializeGame(){
        ArrayList<Player> players = new ArrayList<>();
        for (int i = 1; i <= playerCount; i++){
            players.add(new Player(i));
        }
        currentPlayer = players.get(0);
    }

    public void rollDice(ActionEvent event)
    {
        currentPlayer.movePlayer(1);
        if (currentPlayer.getPlayerID() == 1){
            piece1.setX(xyValues.get(currentPlayer.getCurrentPosition()).get(0));
            piece1.setY(xyValues.get(currentPlayer.getCurrentPosition()).get(1));
        }
    }


    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }

    private void initializePieces()
    {
        piece1.setX(875);
        piece1.setY(715);
        piece2.setX(875);
        piece2.setY(735);
        if (playerCount == 3 || playerCount == 4){
            piece3.setX(875);
            piece3.setY(755);
        }
        if (playerCount == 4){
            piece4.setX(875);
            piece4.setY(775);
        }
        if (playerCount == 2){
            //make first two dissapear
        }
    }


}