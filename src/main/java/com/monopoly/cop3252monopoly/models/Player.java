package com.monopoly.cop3252monopoly.models;

import com.monopoly.cop3252monopoly.models.ChanceCard;
import com.monopoly.cop3252monopoly.models.ChanceCardsDeck;
import com.monopoly.cop3252monopoly.models.CommunityCard;
import com.monopoly.cop3252monopoly.models.CommunityCardsDeck;

public class Player {

    private int currentBalance;
    private String playerName;
    private int currentPosition;
    private int playerID;

    public Player(int newID) {
        // default constructor
        currentBalance = 1500;  // Starting balance
        playerName = "";
        playerID = newID;
    }

    // method to draw card and apply logic
    public ChanceCard drawCard(ChanceCardsDeck chanceCardsDeck) {
        return chanceCardsDeck.getCard();
    }

    public CommunityCard drawCard(CommunityCardsDeck communityCardsDeck) {
        return communityCardsDeck.getCard();
    }

    // ID
    public int getPlayerID() { return playerID; }

    // Name
    public String getPlayerName() { return playerName; }
    public void setPlayerName(String name) { playerName = name; }

    // Balance
    public int getCurrentBalance() { return currentBalance; }
    public void setCurrentBalance(int money) { currentBalance = money; }

    // Position
    public int getCurrentPosition() { return currentPosition; }
    public void setCurrentPosition(int position) { currentPosition = position; }

}
