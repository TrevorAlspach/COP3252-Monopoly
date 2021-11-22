package com.monopoly.cop3252monopoly;

import com.monopoly.cop3252monopoly.models.*;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
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
    private ImageView dice1;
    @FXML
    private ImageView dice2;
    @FXML
    private ImageView dice3;
    @FXML
    private ImageView dice4;
    @FXML
    private ImageView dice5;
    @FXML
    private ImageView dice6;
    @FXML
    private ImageView dice11;
    @FXML
    private ImageView dice22;
    @FXML
    private ImageView dice33;
    @FXML
    private ImageView dice44;
    @FXML
    private ImageView dice55;
    @FXML
    private ImageView dice66;
    @FXML
    private ImageView chance;
    @FXML
    private ImageView community;
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
    @FXML
    private Label player1PropertyCount;
    @FXML
    private Label player2PropertyCount;
    @FXML
    private Label player3PropertyCount;
    @FXML
    private Label player4PropertyCount;
    //End FXML Elements-------------------------------------------------------------------------------------------------
    //Start Monopoly Objects--------------------------------------------------------------------------------------------
    private boolean canRollDice;
    private boolean nextTurnAvailable;
    private boolean buyChoiceAvailable;
    private ObservableList<String> gameMessages;
    private int playerCount;
    private ArrayList<Player> players;
    private Player currentPlayer;
    private Dice dice;
    public static HashMap<Integer, Property> properties;
    public ChanceCardsDeck chanceCardsDeck;
    public CommunityCardsDeck communityCardsDeck;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        chance.setX(515);
        chance.setY(500);
        chance.setRotate(-45);
        community.setX(205);
        community.setY(180);
        community.setRotate(135);

        Platform.runLater(this::initializePieces);
        Platform.runLater(this::initializeDice);
        Platform.runLater(this::initializeGame);

        gameMessages = FXCollections.observableArrayList();
        listView.setItems(gameMessages);
    }

    private void initializeGame(){
        properties = new HashMap<Integer, Property>();
        chanceCardsDeck = new ChanceCardsDeck();
        communityCardsDeck = new CommunityCardsDeck();
        for (int i = 0; i < 40; i++){
            if (Property.propertyNames.containsKey(i)){
                properties.put(i, new Property(i));
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
        buyChoiceAvailable = false;
    }

    public void rollDice(ActionEvent event)
    {
        if (!canRollDice)
            return;

        dice1.setVisible(false);
        dice2.setVisible(false);
        dice3.setVisible(false);
        dice4.setVisible(false);
        dice5.setVisible(false);
        dice6.setVisible(false);
        dice11.setVisible(false);
        dice22.setVisible(false);
        dice33.setVisible(false);
        dice44.setVisible(false);
        dice55.setVisible(false);
        dice66.setVisible(false);

  /*      int i = 0;
        while (dice.DiceRollTurn(currentPlayer)) {
            i++;
            updatePlayer(currentPlayer);
            infoMessage(String.format("Player %d rolled a %d and is now on position %d", currentPlayer.getPlayerID(), dice.getLastRoll(), currentPlayer.getCurrentPosition()));
            performSpaceLogic(dice.getLastRoll());
            if (i == 3) {
                currentPlayer.setCurrentPosition(40);
                currentPlayer.setInJail(true);
                updatePlayer(currentPlayer);
                infoMessage(String.format("Player %d rolled 3 doubles in a row and is now in jail", currentPlayer.getPlayerID()));
                break;
            }
        }*/

        boolean rollAgain = dice.DiceRollTurn(currentPlayer);
        if (dice.getDoublesCount() == 3){
            dice.setDoublesCount(0);
            currentPlayer.setCurrentPosition(40);
            currentPlayer.setInJail(true);
            infoMessage(String.format("Player %d rolled 3 doubles in a row and is now in jail", currentPlayer.getPlayerID()));
            return;
        }

        switch (dice.getDie1Roll()) {
            case 1:
                dice1.setVisible(true);
                if (dice.lastRollIsDouble())
                {
                    dice11.setVisible(true);
                }
                break;
            case 2: dice2.setVisible(true);
                if (dice.lastRollIsDouble())
                {
                    dice22.setVisible(true);
                }
                break;
            case 3: dice3.setVisible(true);
                if (dice.lastRollIsDouble())
                {
                    dice33.setVisible(true);
                }
                break;
            case 4: dice4.setVisible(true);
                if (dice.lastRollIsDouble())
                {
                    dice44.setVisible(true);
                }
                break;
            case 5: dice5.setVisible(true);
                if (dice.lastRollIsDouble())
                {
                    dice55.setVisible(true);
                }break;
            case 6: dice6.setVisible(true);
                if (dice.lastRollIsDouble())
                {
                    dice66.setVisible(true);
                }
                break;
        }
        switch (dice.getDie2Roll()) {
            case 1: dice1.setVisible(true);
                if (dice.lastRollIsDouble())
                {
                    dice11.setVisible(true);
                }
                break;
            case 2: dice2.setVisible(true);
                if (dice.lastRollIsDouble())
                {
                    dice22.setVisible(true);
                }
                break;
            case 3: dice3.setVisible(true);
                if (dice.lastRollIsDouble())
                {
                    dice33.setVisible(true);
                }
                break;
            case 4: dice4.setVisible(true);
                if (dice.lastRollIsDouble())
                {
                    dice44.setVisible(true);
                }
                break;
            case 5: dice5.setVisible(true);
                if (dice.lastRollIsDouble())
                {
                    dice55.setVisible(true);
                }
                break;
            case 6: dice6.setVisible(true);
                if (dice.lastRollIsDouble())
                {
                    dice66.setVisible(true);
                }
                break;
        }

        updatePlayer(currentPlayer);
        if (!currentPlayer.isInJail()) {
            infoMessage(String.format("Player %d rolled a %d and is now on position %d", currentPlayer.getPlayerID(), dice.getLastRoll(), currentPlayer.getCurrentPosition()));
        }

        performSpaceLogic(dice.getLastRoll());

        if (rollAgain){
            infoMessage(String.format("Player %d rolled doubles, roll again!", currentPlayer.getPlayerID()));
            return;
        }
        else{
            dice.setDoublesCount(0);
        }

        nextTurnAvailable = true;
        canRollDice = false;
    }

    //Logic for what space you land on
    public void performSpaceLogic(int lastRoll) {
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
            Property propertyLandedOn = properties.get(currentPlayer.getCurrentPosition());
            if (!propertyLandedOn.isOwned()){
                //Property isn't owned, you can buy it.
                if (propertyLandedOn.getPropertyCost() < currentPlayer.getCurrentBalance()) {
                    //You can afford the property
                    infoMessage(String.format("%s is unowned, Player %d would you like to buy it for $%d?",
                            propertyLandedOn.getPropertyTitle(), currentPlayer.getPlayerID(), propertyLandedOn.getPropertyCost()));
                    buyChoiceAvailable = true;
                }
                else{
                    //You can't afford the property
                    infoMessage(String.format("%s is unowned, but Player %d cannot afford to buy it",
                            propertyLandedOn.getPropertyTitle(), currentPlayer.getPlayerID()));
                    return;
                }
            }
            else {
                Player propertyOwner = players.get(propertyLandedOn.getOwner() - 1);
                int rent = 0;
                //Property is already owned, pay rent.
                if (propertyOwner != currentPlayer) {
                    if (propertyLandedOn.isRailroad()) {
                        //Railroad logic
                        int railroadsOwned = 0;
                        for (int i = 5; i <= 35; i += 10) {
                            if (properties.get(i).getOwner() == propertyOwner.getPlayerID()) {
                                railroadsOwned++;
                            }
                        }
                        rent = Property.propertyValues.get(currentPlayer.getCurrentPosition()).get(railroadsOwned);
                        currentPlayer.loseMoney(rent);
                        propertyOwner.addMoney(rent);
                    } else if (propertyLandedOn.isUtility()) {
                        //Utility Logic
                        int utilitiesOwned = 0;
                        if (properties.get(12).getOwner() == propertyOwner.getPlayerID()) {
                            utilitiesOwned++;
                        }
                        if (properties.get(28).getOwner() == propertyOwner.getPlayerID()) {
                            utilitiesOwned++;
                        }
                        if (utilitiesOwned == 1) {
                            rent = 4 * lastRoll;
                            currentPlayer.loseMoney(rent);
                            propertyOwner.addMoney(rent);
                        } else {
                            rent = 10 * lastRoll;
                            currentPlayer.loseMoney(rent);
                            propertyOwner.addMoney(rent);
                        }
                    } else {
                        //Normal Property Logic
                        rent = Property.propertyValues.get(currentPlayer.getCurrentPosition()).get(propertyLandedOn.getHouseCount());
                        currentPlayer.loseMoney(rent);
                        propertyOwner.addMoney(rent);
                    }
                    infoMessage(String.format("Player %d paid Player %d $%d in rent", currentPlayer.getPlayerID(), propertyOwner.getPlayerID(), rent));
                    updatePlayerBalance(propertyOwner);
                }
            }
            updatePlayerBalance(currentPlayer);
        }
    }

    public void onBuyProperty(ActionEvent event){
        //Will execute if player clicks yes button when prompted to buy a property
        if (!buyChoiceAvailable){
            return;
        }
        Property propertyToBuy = properties.get(currentPlayer.getCurrentPosition());
        infoMessage(String.format("Player %d bought %s for $%d",
                currentPlayer.getPlayerID(), propertyToBuy.getPropertyTitle(), propertyToBuy.getPropertyCost()));
        propertyToBuy.setOwner(currentPlayer.getPlayerID());
        propertyToBuy.setOwned(true);
        currentPlayer.loseMoney(propertyToBuy.getPropertyCost());
        updatePlayerBalance(currentPlayer);
        currentPlayer.addProperty(); // property counter
        updatePropertiesOwned(currentPlayer);

        buyChoiceAvailable = false;
    }

    public void onRefuseProperty(ActionEvent event){
        if (!buyChoiceAvailable){
            return;
        }
        Property propertyToBuy = properties.get(currentPlayer.getCurrentPosition());
        infoMessage(String.format("Player %d decided to not buy %s",
                currentPlayer.getPlayerID(), propertyToBuy.getPropertyTitle()));
        buyChoiceAvailable = false;
    }


    public void onNextTurn(ActionEvent event){
        if (!nextTurnAvailable || buyChoiceAvailable)
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
                currentPlayer.loseMoney(50);
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

    public void updatePropertiesOwned(Player currentPlayer){
        if (currentPlayer.getPlayerID() == 1){
            player1PropertyCount.setText(String.format("%d", currentPlayer.getNumProperties()));
        }
        else if (currentPlayer.getPlayerID() == 2){
            player2PropertyCount.setText(String.format("%d", currentPlayer.getNumProperties()));
        }
        else if (currentPlayer.getPlayerID() == 3){
            player3PropertyCount.setText(String.format("%d", currentPlayer.getNumProperties()));
        }
        else if (currentPlayer.getPlayerID() == 4){
            player4PropertyCount.setText(String.format("%d", currentPlayer.getNumProperties()));
        }
    }

    // Update location, balance, and properties of currentPlayer
    public void updatePlayer(Player currentPlayer) {
        updatePlayerLocation(currentPlayer);
        updatePlayerBalance(currentPlayer);
        updatePropertiesOwned(currentPlayer);
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

    private void initializeDice()
    {
        dice1.setX(400);
        dice1.setY(400);
        dice2.setX(450);
        dice2.setY(450);
        dice3.setX(400);
        dice3.setY(300);
        dice4.setX(300);
        dice4.setY(400);
        dice5.setX(300);
        dice5.setY(300);
        dice6.setX(350);
        dice6.setY(350);
        dice11.setX(320);
        dice11.setY(320);
        dice22.setX(370);
        dice22.setY(370);
        dice33.setX(320);
        dice33.setY(420);
        dice44.setX(420);
        dice44.setY(320);
        dice55.setX(420);
        dice55.setY(420);
        dice66.setX(470);
        dice66.setY(470);


        dice1.setVisible(false);
        dice2.setVisible(false);
        dice3.setVisible(false);
        dice4.setVisible(false);
        dice5.setVisible(false);
        dice6.setVisible(false);
        dice11.setVisible(false);
        dice22.setVisible(false);
        dice33.setVisible(false);
        dice44.setVisible(false);
        dice55.setVisible(false);
        dice66.setVisible(false);
    }

    private void infoMessage(String info){
        gameMessages.add(info);
        listView.scrollTo(gameMessages.size()-1);
    }

    // Debug message to show various data in the text box. Strictly for testing only, should not be called in final product
    public void debugMessage() {
        infoMessage(String.format("%d = %d + %d", dice.getLastRoll(), dice.getDie1Roll(), dice.getDie2Roll()));
        if (dice.lastRollIsDouble()) {
            infoMessage("Double!");
        } else {
            infoMessage("Not Double!");
        }
    }

    public void performChanceCard(ChanceCard chanceCard, Player player, ArrayList<Player> players) {
        int id = chanceCard.getChanceID();

        if(id == 1) { player.setCurrentPosition(39); performSpaceLogic(dice.getLastRoll());} // Advance to boardwalk
        else if (id == 2) { player.setCurrentPosition(0); player.addMoney(200);} // Advance to go (collect $200)
        else if (id == 3) { // Advance to Illinois Avenue. If you pass Go, collect $200
            if (player.getCurrentPosition() > 25) { player.addMoney(200); } // passes go
            player.setCurrentPosition(24);
            performSpaceLogic(dice.getLastRoll());
        }
        else if (id == 4) { // Advance to St. Charles Place. If you pass Go, collect $200
            if (player.getCurrentPosition() > 12) { player.addMoney(200); } // passes go
            player.setCurrentPosition(11);
            performSpaceLogic(dice.getLastRoll());
        }
        else if (id == 5) { // Advance to the nearest Railroad. If unowned, you may buy it from the Bank. If owned, pay owner twice the rental to which they are otherwise entitled
            if (player.getCurrentPosition() == 7) { player.setCurrentPosition(15); } // first chance spot
            else if (player.getCurrentPosition() == 22) { player.setCurrentPosition(25); } // second chance spot
            else if (player.getCurrentPosition() == 36) { // third chance spot
                player.addMoney(200); // passes go
                player.setCurrentPosition(5);
            }
            performSpaceLogic(dice.getLastRoll());
        }
        else if (id == 6) { // Advance to the nearest Railroad. If unowned, you may buy it from the Bank. If owned, pay owner twice the rental to which they are otherwise entitled
            if (player.getCurrentPosition() == 7) { player.setCurrentPosition(15); } // first chance spot
            else if (player.getCurrentPosition() == 22) { player.setCurrentPosition(25); } // second chance spot
            else if (player.getCurrentPosition() == 36) { // third chance spot
                player.addMoney(200); // passes go
                player.setCurrentPosition(5);
            }
            performSpaceLogic(dice.getLastRoll());
        }
        else if (id == 7) { // Advance token to the nearest Utility. If unowned, you may buy it from the Bank. If owned, throw dice and pay owner a total ten times amount thrown
            if (player.getCurrentPosition() == 7) { player.setCurrentPosition(12); }
            else if (player.getCurrentPosition() == 22) { player.setCurrentPosition(28); }
            else if (player.getCurrentPosition() == 36) {
                player.addMoney(200); // passes go
                player.setCurrentPosition(12);
            }
            performSpaceLogic(dice.getLastRoll());
        }
        else if (id == 8) { player.addMoney(50); } // Bank pays you dividend of $50
        else if (id == 9) { player.addGetOutOfJailCard(); } // Get Out of Jail Free
        else if (id == 10) { player.movePlayer(-3); performSpaceLogic(dice.getLastRoll()); } // Go Back 3 Spaces
        else if (id == 11) { // Go to Jail. Go directly to Jail, do not pass Go, do not collect $200
            player.setCurrentPosition(40);
            player.setInJail(true);
        }
        else if (id == 12) { } // Make general repairs on all your property. For each house pay $25. For each hotel pay $100
        else if (id == 13) { player.loseMoney(15); } // Speeding fine $15
        else if (id == 14) { // Take a trip to Reading Railroad. If you pass Go, collect $200
            player.addMoney(200); // player always passes go
            player.setCurrentPosition(5);
            performSpaceLogic(dice.getLastRoll());
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

        if (id == 1) { player.setCurrentPosition(0); player.addMoney(200); } // Advance to Go (Collect $200)
        else if (id == 2) { player.addMoney(200); } // Bank error in your favor. Collect $200
        else if (id == 3) { player.loseMoney(50); } // Doctor’s fee. Pay $50
        else if (id == 4) { player.addMoney(50); } // From sale of stock you get $50
        else if (id == 5) { player.addGetOutOfJailCard(); } // Get Out of Jail Free
        else if (id == 6) { // Go to Jail. Go directly to jail, do not pass Go, do not collect $200
            player.setCurrentPosition(40);
            player.setInJail(true);
        }
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
        else if (id == 13) { player.loseMoney(25); } // Receive $25 consultancy fee
        else if (id == 14) {  } // You are assessed for street repair. $40 per house. $115 per hotel
        else if (id == 15) { player.addMoney(10); } // You have won second prize in a beauty contest. Collect $10
        else if (id == 16) { player.addMoney(100); } // You inherit $100
    }

    public void viewProperties(ActionEvent event){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("view-properties.fxml"));
            Parent parent = fxmlLoader.load();
            ViewPropertiesController controller = fxmlLoader.getController();
            controller.setPlayer(currentPlayer);
            Scene scene = new Scene(parent, 1340, 940);
            Stage stage = new Stage();
            stage.setTitle("Monopoly");
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


}