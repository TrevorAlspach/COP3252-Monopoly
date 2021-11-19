package com.monopoly.cop3252monopoly;

import com.monopoly.cop3252monopoly.models.*;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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
        put(10, new ArrayList<>(Arrays.asList(50, 695)));
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
        put(40, new ArrayList<>(Arrays.asList(100, 695)));                  // THIS IS JAIL
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
    @FXML
    private ListView<String> listView;
    @FXML
    private Label player1Balance;
    @FXML
    private Label player2Balance;
    @FXML
    private Label player3Balance;
    @FXML
    private Label player4Balance;
    //End FXML Elements-------------------------------------------------------------------------------------------------
    //Start Monopoly Objects--------------------------------------------------------------------------------------------
    private boolean canRollDice;
    private boolean nextTurnAvailable;
    private ObservableList<String> gameMessages;
    private int playerCount;
    private ArrayList<Player> players;
    private Player currentPlayer;
    private Dice dice;
    public static ArrayList<Property> properties;
    public ChanceCardsDeck chanceCardsDeck;
    public CommunityCardsDeck communityCardsDeck;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(this::initializePieces);
        Platform.runLater(this::initializeGame);

        gameMessages = FXCollections.observableArrayList();
        listView.setItems(gameMessages);
    }

    private void initializeGame(){
        properties = new ArrayList<>();
        chanceCardsDeck = new ChanceCardsDeck();
        communityCardsDeck = new CommunityCardsDeck();
        for (int i = 0; i < 40; i++){
            if (Property.propertyNames.containsKey(i)){
                properties.add(new Property(i));
            }
        }

        players = new ArrayList<>();
        for (int i = 1; i <= playerCount; i++){
            players.add(new Player(i));
        }
        currentPlayer = players.get(0);

        dice = new Dice();
        canRollDice = true;
        nextTurnAvailable = false;
    }

    public void rollDice(ActionEvent event)
    {
        if (!canRollDice)
            return;

        int i = 0;
        while (dice.DiceRollTurn(currentPlayer)) {
            i++;
            if (i == 3) {
                currentPlayer.setCurrentPosition(40);
                currentPlayer.setInJail(true);
            }
        }

        //dice.DiceRollTurn(currentPlayer);
        updatePlayerLocation(currentPlayer);
        infoMessage(String.format("Player %d rolled a %d and is now on position %d", currentPlayer.getPlayerID(), dice.getLastRoll(), currentPlayer.getCurrentPosition()));

        //Logic for what space you land on
        if (currentPlayer.getCurrentPosition() == 7 || currentPlayer.getCurrentPosition() == 22 || currentPlayer.getCurrentPosition() == 36) {
            // Player landed on Chance
            ChanceCard chanceCard = chanceCardsDeck.getCard();
            infoMessage(String.format("Player %d received a Chance Card: %s", currentPlayer.getPlayerID(), chanceCard.getTitle()));
            performChanceCard(chanceCard, currentPlayer, players);
            updatePlayer(currentPlayer);
        } else if (currentPlayer.getCurrentPosition() == 2 || currentPlayer.getCurrentPosition() == 17 || currentPlayer.getCurrentPosition() == 33) {
            // Player landed on Community Chest
            CommunityCard communityCard = communityCardsDeck.getCard();
            infoMessage(String.format("Player %d received a Community Chest Card: %s", currentPlayer.getPlayerID(), communityCard.getTitle()));
            performCommunityCard(communityCard, currentPlayer, players);
            updatePlayer(currentPlayer);
        } else if (currentPlayer.getCurrentPosition() == 0) { // Landed on go, give them $200
            currentPlayer.addMoney(200);
            updatePlayerBalance(currentPlayer);
        } else if (currentPlayer.getCurrentPosition() == 4) { // Landed on Income Tax
            currentPlayer.loseMoney(200);
            updatePlayerBalance(currentPlayer);
        } else if (currentPlayer.getCurrentPosition() == 10) { // Just visiting
            infoMessage("Say hi to the people in jail >:)");
        } else if (currentPlayer.getCurrentPosition() == 20) { // Free Parking
            infoMessage("Enjoy your free parking");
        } else if (currentPlayer.getCurrentPosition() == 30) { // Go To Jail
            infoMessage(String.format("Player %d committed tax fraud and got caught. Go directly to jail!", currentPlayer.getPlayerID()));
            currentPlayer.setCurrentPosition(40);
            currentPlayer.setInJail(true);
            updatePlayerLocation(currentPlayer);
        } else if (currentPlayer.getCurrentPosition() == 38) { // Luxury Tax
            currentPlayer.loseMoney(100);
            updatePlayerBalance(currentPlayer);
        } else { // Player lands on a property, needs logic
            infoMessage(String.format("Player %d landed on a property", currentPlayer.getPlayerID()));
        }


        nextTurnAvailable = true;
        canRollDice = false;
    }

    public void onNextTurn(ActionEvent event){
        if (!nextTurnAvailable)
            return;

        if (currentPlayer.getPlayerID() == playerCount){
            currentPlayer = players.get(0);
        }
        else{
            currentPlayer = players.get(currentPlayer.getPlayerID());
        }
        playerLabel.setText(String.format("Player %d Turn", currentPlayer.getPlayerID()));


        if (currentPlayer.isInJail()){
            currentPlayer.setCurrentPosition(10);
            if (currentPlayer.getNumGetOutOfJailCards() > 0){
                currentPlayer.useGetOutOfJailCard();
                infoMessage(String.format("Player %d used a get out of jail free card", currentPlayer.getPlayerID()));
            }
            else{
                currentPlayer.setCurrentBalance(currentPlayer.getCurrentBalance() - 50);
                infoMessage(String.format("Player %d paid $50 to get out of jail", currentPlayer.getPlayerID()));
            }
            currentPlayer.setInJail(false);
            updatePlayer(currentPlayer);
        }
        canRollDice = true;
        nextTurnAvailable = false;
    }

    // Update player location
    public void updatePlayerLocation(Player currentPlayer) {
        if (currentPlayer.getPlayerID() == 1){
            piece1.setX(xyValues.get(currentPlayer.getCurrentPosition()).get(0));
            piece1.setY(xyValues.get(currentPlayer.getCurrentPosition()).get(1));
        }
        else if (currentPlayer.getPlayerID() == 2){
            piece2.setX(xyValues.get(currentPlayer.getCurrentPosition()).get(0));
            piece2.setY(xyValues.get(currentPlayer.getCurrentPosition()).get(1));
        }
        else if (currentPlayer.getPlayerID() == 3){
            piece3.setX(xyValues.get(currentPlayer.getCurrentPosition()).get(0));
            piece3.setY(xyValues.get(currentPlayer.getCurrentPosition()).get(1));
        }
        else if (currentPlayer.getPlayerID() == 4){
            piece4.setX(xyValues.get(currentPlayer.getCurrentPosition()).get(0));
            piece4.setY(xyValues.get(currentPlayer.getCurrentPosition()).get(1));
        }
    }

    // Update player balance
    public void updatePlayerBalance(Player currentPlayer) {
        if (currentPlayer.getPlayerID() == 1){
            player1Balance.setText(String.format("$%d", currentPlayer.getCurrentBalance()));
        }
        else if (currentPlayer.getPlayerID() == 2){
            player2Balance.setText(String.format("$%d", currentPlayer.getCurrentBalance()));
        }
        else if (currentPlayer.getPlayerID() == 3){
            player3Balance.setText(String.format("$%d", currentPlayer.getCurrentBalance()));
        }
        else if (currentPlayer.getPlayerID() == 4){
            player4Balance.setText(String.format("$%d", currentPlayer.getCurrentBalance()));
        }
    }

    // Update location, balance, and properties of currentPlayer
    public void updatePlayer(Player currentPlayer) {
        updatePlayerLocation(currentPlayer);
        updatePlayerBalance(currentPlayer);
        // update properties
    }

    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }

    private void initializePieces()
    {
        //Set starting position of pieces
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

    private void infoMessage(String info){
        gameMessages.add(info);
        listView.scrollTo(gameMessages.size()-1);
    }

    public void performChanceCard(ChanceCard chanceCard, Player player, ArrayList<Player> players) {
        int id = chanceCard.getChanceID();

        if(id == 1) { player.setCurrentPosition(39); } // Advance to boardwalk
        else if (id == 2) { player.setCurrentPosition(0); } // Advance to go (collect $200)
        else if (id == 3) { // Advance to Illinois Avenue. If you pass Go, collect $200
            if (player.getCurrentPosition() > 25) { player.addMoney(200); } // passes go
            player.setCurrentPosition(24);
        }
        else if (id == 4) { // Advance to St. Charles Place. If you pass Go, collect $200
            if (player.getCurrentPosition() > 12) { player.addMoney(200); } // passes go
            player.setCurrentPosition(11);
        }
        else if (id == 5) { // Advance to the nearest Railroad. If unowned, you may buy it from the Bank. If owned, pay owner twice the rental to which they are otherwise entitled
            if (player.getCurrentPosition() == 7) { player.setCurrentPosition(15); } // first chance spot
            else if (player.getCurrentPosition() == 22) { player.setCurrentPosition(25); } // second chance spot
            else if (player.getCurrentPosition() == 36) { // third chance spot
                player.addMoney(200); // passes go
                player.setCurrentPosition(5);
            }
        }
        else if (id == 6) { // Advance to the nearest Railroad. If unowned, you may buy it from the Bank. If owned, pay owner twice the rental to which they are otherwise entitled
            if (player.getCurrentPosition() == 7) { player.setCurrentPosition(15); } // first chance spot
            else if (player.getCurrentPosition() == 22) { player.setCurrentPosition(25); } // second chance spot
            else if (player.getCurrentPosition() == 36) { // third chance spot
                player.addMoney(200); // passes go
                player.setCurrentPosition(5);
            }
        }
        else if (id == 7) { // Advance token to the nearest Utility. If unowned, you may buy it from the Bank. If owned, throw dice and pay owner a total ten times amount thrown
            if (player.getCurrentPosition() == 7) { player.setCurrentPosition(12); }
            else if (player.getCurrentPosition() == 22) { player.setCurrentPosition(28); }
            else if (player.getCurrentPosition() == 36) {
                player.addMoney(200); // passes go
                player.setCurrentPosition(12);
            }
        }
        else if (id == 8) { player.addMoney(50); } // Bank pays you dividend of $50
        else if (id == 9) { player.addGetOutOfJailCard(); } // Get Out of Jail Free
        else if (id == 10) { player.movePlayer(-3); } // Go Back 3 Spaces
        else if (id == 11) { player.setCurrentPosition(10); } // Go to Jail. Go directly to Jail, do not pass Go, do not collect $200
        else if (id == 12) { } // Make general repairs on all your property. For each house pay $25. For each hotel pay $100
        else if (id == 13) { player.loseMoney(15); } // Speeding fine $15
        else if (id == 14) { // Take a trip to Reading Railroad. If you pass Go, collect $200
            player.addMoney(200); // player always passes go
            player.setCurrentPosition(5);
        }
        else if (id == 15) { // You have been elected Chairman of the Board. Pay each player $50
            for (Player p : players) {
                if (p.getPlayerID() != player.getPlayerID()) { // pay money to everyone except yourself
                    player.loseMoney(50);
                    p.addMoney(50);
                }
            }
        }
        else if (id == 16) { player.addMoney(150); } // Your building loan matures. Collect $150
    }

    public void performCommunityCard(CommunityCard communityCard, Player player, ArrayList<Player> players) {
        int id = communityCard.getCommunityID();

        if (id == 1) { player.setCurrentPosition(0); } // Advance to Go (Collect $200)
        else if (id == 2) { player.addMoney(200); } // Bank error in your favor. Collect $200
        else if (id == 3) { player.loseMoney(50); } // Doctor’s fee. Pay $50
        else if (id == 4) { player.addMoney(50); } // From sale of stock you get $50
        else if (id == 5) { player.addGetOutOfJailCard(); } // Get Out of Jail Free
        else if (id == 6) { player.setCurrentPosition(10); } // Go to Jail. Go directly to jail, do not pass Go, do not collect $200
        else if (id == 7) { player.addMoney(100); } // Holiday fund matures. Receive $100
        else if (id == 8) { player.addMoney(20); } // Income tax refund. Collect $20
        else if (id == 9) { // It is your birthday. Collect $10 from every player
            for (Player p : players) {
                if (p.getPlayerID() != player.getPlayerID()) { // collect money from everyone except yourself
                    p.loseMoney(10);
                    player.addMoney(10);
                }
            }
        }
        else if (id == 10) { player.addMoney(100); } // Life insurance matures. Collect $100
        else if (id == 11) { player.loseMoney(100); } // Pay hospital fees of $100
        else if (id == 12) { player.loseMoney(50); } // Pay school fees of $50
        else if (id == 13) { player.addMoney(25); } // Receive $25 consultancy fee
        else if (id == 14) {  } // You are assessed for street repair. $40 per house. $115 per hotel
        else if (id == 15) { player.addMoney(10); } // You have won second prize in a beauty contest. Collect $10
        else if (id == 16) { player.addMoney(100); } // You inherit $100
    }

}