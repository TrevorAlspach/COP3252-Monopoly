package com.monopoly.cop3252monopoly.models;

import com.monopoly.cop3252monopoly.models.ChanceCard;

import java.util.ArrayList;
import java.util.Random;

public class ChanceCardsDeck {

    private ArrayList<ChanceCard> theDeck;

    public ChanceCardsDeck() {
        // create a new, randomized deck of Chance cards
        theDeck = new ArrayList<>();
        theDeck = initializeChanceCards();
    }

    // Get a random card, 1 - 16
    public ChanceCard getCard() {
        Random random = new Random();
        int cardID = random.nextInt(16);
        return theDeck.get(cardID);
    }

    private ArrayList<ChanceCard> initializeChanceCards() {
        ArrayList<ChanceCard> cards = new ArrayList<>();

        for(int x = 1; x <= 16; x++) {
            ChanceCard chanceCard = new ChanceCard(x);
            if(x == 1) { chanceCard.setTitle("Advance to Boardwalk");}
            else if (x == 2) { chanceCard.setTitle("Advance to Go (Collect $200)");}
            else if (x == 3) { chanceCard.setTitle("Advance to Illinois Avenue. If you pass Go, collect $200");}
            else if (x == 4) { chanceCard.setTitle("Advance to St. Charles Place. If you pass Go, collect $200");}
            else if (x == 5) { chanceCard.setTitle("Advance to the nearest Railroad. If unowned, you may buy it from the Bank. If owned, pay owner twice the rental to which they are otherwise entitled");}
            else if (x == 6) { chanceCard.setTitle("Advance to the nearest Railroad. If unowned, you may buy it from the Bank. If owned, pay owner twice the rental to which they are otherwise entitled");}
            else if (x == 7) { chanceCard.setTitle("Advance token to the nearest Utility. If unowned, you may buy it from the Bank. If owned, throw dice and pay owner a total ten times amount thrown");}
            else if (x == 8) { chanceCard.setTitle("Bank pays you dividend of $50");}
            else if (x == 9) { chanceCard.setTitle("Get Out of Jail Free");}
            else if (x == 10) { chanceCard.setTitle("Go Back 3 Spaces");}
            else if (x == 11) { chanceCard.setTitle("Go to Jail. Go directly to Jail, do not pass Go, do not collect $200");}
            else if (x == 12) { chanceCard.setTitle("Get Out of Jail Free");} // Make general repairs on all your property. For each house pay $25. For each hotel pay $100
            else if (x == 13) { chanceCard.setTitle("Speeding fine $15");}
            else if (x == 14) { chanceCard.setTitle("Take a trip to Reading Railroad. If you pass Go, collect $200");}
            else if (x == 15) { chanceCard.setTitle("You have been elected Chairman of the Board. Pay each player $50");}
            else if (x == 16) { chanceCard.setTitle("Your building loan matures. Collect $150");}
            cards.add(chanceCard);
        }
        return cards;
    }
}
