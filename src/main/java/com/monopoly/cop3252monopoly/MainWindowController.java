package com.monopoly.cop3252monopoly;

import com.monopoly.cop3252monopoly.models.Dice;
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
        put(0, new ArrayList<>(Arrays.asList(750, 695)));
        //put(0, new int[]{845, 715});
        put(1, new ArrayList<>(Arrays.asList(670, 695)));
        put(2, new ArrayList<>(Arrays.asList(610, 695)));
        put(3, new ArrayList<>(Arrays.asList(550, 695)));
        put(4, new ArrayList<>(Arrays.asList(490, 695)));
        put(5, new ArrayList<>(Arrays.asList(430, 695)));
        put(6, new ArrayList<>(Arrays.asList(370, 695)));
        put(7, new ArrayList<>(Arrays.asList(310, 695)));
        put(8, new ArrayList<>(Arrays.asList(250, 695)));
        put(9, new ArrayList<>(Arrays.asList(190, 695)));
        put(10, new ArrayList<>(Arrays.asList(100, 695)));
        put(11, new ArrayList<>(Arrays.asList(100, 633)));
        put(12, new ArrayList<>(Arrays.asList(100, 571)));
        put(13, new ArrayList<>(Arrays.asList(100, 509)));
        put(14, new ArrayList<>(Arrays.asList(100, 447)));
        put(15, new ArrayList<>(Arrays.asList(100, 385)));
        put(16, new ArrayList<>(Arrays.asList(100, 323)));
        put(17, new ArrayList<>(Arrays.asList(100, 261)));
        put(18, new ArrayList<>(Arrays.asList(100, 199)));
        put(19, new ArrayList<>(Arrays.asList(100, 137)));
        put(20, new ArrayList<>(Arrays.asList(100, 50)));
        put(21, new ArrayList<>(Arrays.asList(190, 50)));
        put(22, new ArrayList<>(Arrays.asList(250, 50)));
        put(23, new ArrayList<>(Arrays.asList(310, 50)));
        put(24, new ArrayList<>(Arrays.asList(370, 50)));
        put(25, new ArrayList<>(Arrays.asList(430, 50)));
        put(26, new ArrayList<>(Arrays.asList(490, 50)));
        put(27, new ArrayList<>(Arrays.asList(550, 50)));
        put(28, new ArrayList<>(Arrays.asList(610, 50)));
        put(29, new ArrayList<>(Arrays.asList(670, 50)));
        put(30, new ArrayList<>(Arrays.asList(750, 50)));
        put(31, new ArrayList<>(Arrays.asList(750, 137)));
        put(32, new ArrayList<>(Arrays.asList(750, 199)));
        put(33, new ArrayList<>(Arrays.asList(750, 261)));
        put(34, new ArrayList<>(Arrays.asList(750, 323)));
        put(35, new ArrayList<>(Arrays.asList(750, 385)));
        put(36, new ArrayList<>(Arrays.asList(750, 447)));
        put(37, new ArrayList<>(Arrays.asList(750, 509)));
        put(38, new ArrayList<>(Arrays.asList(750, 571)));
        put(39, new ArrayList<>(Arrays.asList(750, 633)));
        //Need to add Railroads and Utilities
    }};

    //FXML Elements-----------------------------------------------------------------------------------------------------
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
    //End FXML Elements-------------------------------------------------------------------------------------------------
    //Start Monopoly Objects--------------------------------------------------------------------------------------------
    private int playerCount;
    private Player currentPlayer;
    private Dice dice;

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

        dice = new Dice();
    }

    public void rollDice(ActionEvent event)
    {
        //dice.DiceRollTurn(currentPlayer);
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
        piece1.setX(720);
        piece1.setY(695);
        piece2.setX(720);
        piece2.setY(710);
        if (playerCount == 3 || playerCount == 4){
            piece3.setX(720);
            piece3.setY(725);
        }
        if (playerCount == 4){
            piece4.setX(720);
            piece4.setY(740);
        }
        if (playerCount == 2){
            piece3.setVisible(false);
            piece4.setVisible(false);
        }
    }


}