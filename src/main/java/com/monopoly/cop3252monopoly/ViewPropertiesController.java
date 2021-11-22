package com.monopoly.cop3252monopoly;

import com.monopoly.cop3252monopoly.models.Player;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewPropertiesController implements Initializable {

    @FXML
    public ImageView MediterraneanAvenue;
    @FXML
    public ImageView BalticAvenue;
    @FXML
    public ImageView ReadingRailroad;
    @FXML
    public ImageView OrientalAvenue;
    @FXML
    public ImageView VermontAvenue;
    @FXML
    public ImageView ConnecticutAvenue;
    @FXML
    public ImageView StCharlesPlace;
    @FXML
    public ImageView ElectricCompany;
    @FXML
    public ImageView StatesAvenue;
    @FXML
    public ImageView VirginiaAvenue;
    @FXML
    public ImageView PennsylvaniaRailroad;
    @FXML
    public ImageView StJamesPlace;
    @FXML
    public ImageView TennesseeAvenue;
    @FXML
    public ImageView NewYorkAvenue;
    @FXML
    public ImageView KentuckyAvenue;
    @FXML
    public ImageView IndianaAvenue;
    @FXML
    public ImageView IllinoisAvenue;
    @FXML
    public ImageView BORailroad;
    @FXML
    public ImageView AtlanticAvenue;
    @FXML
    public ImageView VentnorAvenue;
    @FXML
    public ImageView WaterWorks;
    @FXML
    public ImageView MarvinGardens;
    @FXML
    public ImageView PacificAvenue;
    @FXML
    public ImageView NorthCarolinaAvenue;
    @FXML
    public ImageView PennsylvaniaAvenue;
    @FXML
    public ImageView ShortLineRR;
    @FXML
    public ImageView ParkPlace;
    @FXML
    public ImageView Boardwalk;

    private Player player;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setPlayer(Player player){ this.player = player;}

}
