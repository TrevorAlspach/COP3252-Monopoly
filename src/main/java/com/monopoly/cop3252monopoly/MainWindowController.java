package com.monopoly.cop3252monopoly;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainWindowController {
    private int playerCount;

    public MainWindowController(){}

    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }
}