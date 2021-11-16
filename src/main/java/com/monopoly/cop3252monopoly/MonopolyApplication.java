package com.monopoly.cop3252monopoly;

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
        Scanner input = new Scanner(System.in);
        int numPlayers;
        ArrayList<Player> playerList = new ArrayList<>();

        System.out.print("Enter number of players: ");
        numPlayers = input.nextInt();

        for (int i = 1; i <= numPlayers; i++) {
            Player player = new Player(i);
            playerList.add(player);
        }



    }
}