package com.monopoly.cop3252monopoly;

import com.monopoly.cop3252monopoly.models.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MonopolyApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MonopolyApplication.class.getResource("start-screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 480, 480);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();

        // Example code if inside console
        /*
        Scanner input = new Scanner(System.in);
        CommunityCardsDeck communityCardsDeck = new CommunityCardsDeck();
        ChanceCardsDeck chanceCardsDeck = new ChanceCardsDeck();
        int numPlayers;
        ArrayList<Player> playerList = new ArrayList<>();

        System.out.print("Enter number of players: ");
        numPlayers = input.nextInt();

        for (int i = 1; i <= numPlayers; i++) {
            Player player = new Player(i);
            playerList.add(player);
        }

        ChanceCard drawnCard = playerList.get(0).drawCard(chanceCardsDeck);
        System.out.println(drawnCard.getCardType() + " Card: " + drawnCard.getTitle());
        */


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