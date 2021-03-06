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
    private int getOutOfJailCards;
    private int numProperties;
    private boolean bankrupt;
    private boolean kickedFromGame;


    private boolean inJail;

    public Player(int newID) {
        // constructor
        currentBalance = 1500;  // Starting balance
        playerName = "";
        playerID = newID;
        getOutOfJailCards = 0;
        currentPosition = 0;
        numProperties = 0;
        inJail = false;
        bankrupt = false;
        kickedFromGame = false;
    }

    // draw Chance card
    public ChanceCard drawCard(ChanceCardsDeck chanceCardsDeck) {
        return chanceCardsDeck.getCard();
    }

    // draw Community Chest card
    public CommunityCard drawCard(CommunityCardsDeck communityCardsDeck) {
        return communityCardsDeck.getCard();
    }

    // ID
    public int getPlayerID() { return playerID; } // getter

    // Name
    public String getPlayerName() { return playerName; } // getter
    public void setPlayerName(String name) { playerName = name; } // setter

    //In Jail
    public boolean isInJail() {
        return inJail;
    }

    public void setInJail(boolean inJail) {
        this.inJail = inJail;
    }

    // Num Properties
    public int getNumProperties() { return numProperties; }
    public void setNumProperties(int num) { numProperties = num; }
    public void addProperty() { numProperties++; } // increment when player buys a property

    // Balance
    public int getCurrentBalance() { return currentBalance; } // getter
    public void setCurrentBalance(int money) { currentBalance = money; } // setter
    public void loseMoney(int money) { // player loses money
        if (currentBalance >= money) { currentBalance -= money; }
        else {
            bankrupt = true;
            currentBalance = 0;
            numProperties = 0;
        }
    }
    public void addMoney(int money) { currentBalance += money; } // player earns money

    // Position
    public int getCurrentPosition() { return currentPosition; } // getter
    public void setCurrentPosition(int position) { currentPosition = position; } // setter
    public void movePlayer(int num) { // can be used to move player forward or backward
        currentPosition += num;
        if (currentPosition > 39) // user is going past boardwalk, and back at the start
        {
            currentPosition -= 40;
            if (currentPosition != 0) {currentBalance += 200;} // for passing go
        }
    }

    // Get Out of Jail Cards
    public int getNumGetOutOfJailCards() { return getOutOfJailCards; } // getter
    public void addGetOutOfJailCard() { getOutOfJailCards++; } // player received get-out-of-jail card
    public void useGetOutOfJailCard() { getOutOfJailCards--; } // player uses get-out-of-jail card

    // Kicked out of game
    public boolean isBankrupt() { return bankrupt; } // getter, dont need setter cause thats handled by loseMoney()
    public boolean isKickedFromGame() { return kickedFromGame; }
    public void setKickedFromGame(boolean kickStatus) { kickedFromGame = kickStatus; }

}
