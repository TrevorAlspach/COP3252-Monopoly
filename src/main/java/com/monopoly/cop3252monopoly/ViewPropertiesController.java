package com.monopoly.cop3252monopoly;

import com.monopoly.cop3252monopoly.models.Player;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewPropertiesController implements Initializable {

    private Player player;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setPlayer(Player player){ this.player = player;}

}
