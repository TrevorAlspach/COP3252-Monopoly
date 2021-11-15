package com.monopoly.cop3252monopoly;

import java.util.ArrayList;

public class Player {

    private int currentBalance;
    private String playerName;
    private int currentPosition;
    private int playerID;

    public Player(int newID) {
        // default constructor
        currentBalance = 1500;
        playerName = "";
        playerID = newID;
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
