package com.monopoly.cop3252monopoly;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class StartWindowController {
    @FXML
    private Label title;
    private Button button2 = new Button("2 Players");
    private Button button3 = new Button("3 Players");
    private Button button4 = new Button("4 Players");



    @FXML
    protected void onButton2Click(ActionEvent event) {
        title.setText("Button 2 Clicked");
        try{
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("main-window.fxml"));
            MainWindowController controller = fxmlLoader.getController();
            controller.setPlayerCount(2);
            Scene scene = new Scene(fxmlLoader.load(), 720, 720);
            Stage stage = new Stage();
            stage.setTitle("Monopoly");
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void onButton3Click(ActionEvent event) {
        title.setText("Button 3 Clicked");
        try{
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("main-window.fxml"));
            //MainWindowController controller = fxmlLoader.getController();
            //controller.setPlayerCount(3);
            Scene scene = new Scene(fxmlLoader.load(), 720, 720);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void onButton4Click(ActionEvent event) {
        title.setText("Button 4 Clicked");
        try{
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("main-window.fxml"));
            MainWindowController controller = fxmlLoader.getController();
            controller.setPlayerCount(4);
            Scene scene = new Scene(fxmlLoader.load(), 720, 720);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
