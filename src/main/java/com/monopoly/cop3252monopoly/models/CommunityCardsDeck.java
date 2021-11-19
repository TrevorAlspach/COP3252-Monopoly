package com.monopoly.cop3252monopoly.models;

import com.monopoly.cop3252monopoly.models.CommunityCard;

import java.util.ArrayList;
import java.util.Random;

public class CommunityCardsDeck {

    private ArrayList<CommunityCard> theDeck;

    public CommunityCardsDeck() {
        // create a new, randomized deck of Community Chest cards
        theDeck = new ArrayList<>();
        theDeck = initializeCommunityCards();
    }

    // Get a random card, 1 - 16
    public CommunityCard getCard() {
        Random random = new Random();
        int cardID = random.nextInt(16);
        return theDeck.get(cardID);
    }

    private ArrayList<CommunityCard> initializeCommunityCards() {
        ArrayList<CommunityCard> cards = new ArrayList<>();

        for(int x = 1; x <= 16; x++) {
            CommunityCard communityCard = new CommunityCard(x);
            if(x == 1) { communityCard.setTitle("Advance to Go (Collect $200)");}
            else if (x == 2) { communityCard.setTitle("Bank error in your favor. Collect $200");}
            else if (x == 3) { communityCard.setTitle("Doctor’s fee. Pay $50");}
            else if (x == 4) { communityCard.setTitle("From sale of stock you get $50");}
            else if (x == 5) { communityCard.setTitle("Get Out of Jail Free");}
            else if (x == 6) { communityCard.setTitle("Go to Jail. Go directly to jail, do not pass Go, do not collect $200");}
            else if (x == 7) { communityCard.setTitle("Holiday fund matures. Receive $100");}
            else if (x == 8) { communityCard.setTitle("Income tax refund. Collect $20");}
            else if (x == 9) { communityCard.setTitle("It is your birthday. Collect $10 from every player");}
            else if (x == 10) { communityCard.setTitle("Life insurance matures. Collect $100");}
            else if (x == 11) { communityCard.setTitle("Pay hospital fees of $100");}
            else if (x == 12) { communityCard.setTitle("Pay school fees of $50");}
            else if (x == 13) { communityCard.setTitle("Receive $25 consultancy fee");}
            else if (x == 14) { communityCard.setTitle("You are assessed for street repair. $40 per house. $115 per hotel");}
            else if (x == 15) { communityCard.setTitle("You have won second prize in a beauty contest. Collect $10");}
            else if (x == 16) { communityCard.setTitle("You inherit $100");}
            cards.add(communityCard);
        }
        return cards;
    }
}
