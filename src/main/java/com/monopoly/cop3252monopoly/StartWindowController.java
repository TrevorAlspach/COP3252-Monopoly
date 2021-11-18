package com.monopoly.cop3252monopoly;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StartWindowController implements Initializable {

    @FXML
    private Label title;
    @FXML
    private Button button2 = new Button();
    @FXML
    private Button button3 = new Button();
    @FXML
    private Button button4 = new Button();

    @FXML
    protected void onButton2Click(ActionEvent event) {
        startGame(2);
    }
    @FXML
    protected void onButton3Click(ActionEvent event) {
        startGame(3);
    }
    @FXML
    protected void onButton4Click(ActionEvent event) {
        startGame(4);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        button2.setText("2 Players");
        button3.setText("3 Players");
        button4.setText("4 Players");
    }


    private void startGame(int playerCount) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main-window.fxml"));
            Parent parent = fxmlLoader.load();
            MainWindowController controller = fxmlLoader.getController();
            controller.setPlayerCount(playerCount);
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
