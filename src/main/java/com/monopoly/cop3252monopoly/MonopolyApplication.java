package com.monopoly.cop3252monopoly;

import com.monopoly.cop3252monopoly.models.ChanceCard;
import com.monopoly.cop3252monopoly.models.ChanceCardsDeck;
import com.monopoly.cop3252monopoly.models.CommunityCardsDeck;
import com.monopoly.cop3252monopoly.models.Player;
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
}