package com.monopoly.cop3252monopoly;

import com.monopoly.cop3252monopoly.models.Player;
import com.monopoly.cop3252monopoly.models.Property;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.HashMap;
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
    @FXML
    public Label propertySelectedLabel;

    private Player player;
    public HashMap<Integer, Property> map;
    private Property selectedProperty;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(this::initializeCards);
    }

    public void initializeCards(){
        int id = player.getPlayerID();
        if (map.get(1).getOwner() == id){
            MediterraneanAvenue.setVisible(true);
        }
        if (map.get(3).getOwner() == id){
            BalticAvenue.setVisible(true);
        }
        if (map.get(5).getOwner() == id){
            ReadingRailroad.setVisible(true);
        }
        if (map.get(6).getOwner() == id){
            OrientalAvenue.setVisible(true);
        }
        if (map.get(8).getOwner() == id){
            VermontAvenue.setVisible(true);
        }
        if (map.get(9).getOwner() == id){
            ConnecticutAvenue.setVisible(true);
        }
        if (map.get(11).getOwner() == id){
            StCharlesPlace.setVisible(true);
        }
        if (map.get(12).getOwner() == id){
            ElectricCompany.setVisible(true);
        }
        if (map.get(13).getOwner() == id){
            StatesAvenue.setVisible(true);
        }
        if (map.get(14).getOwner() == id){
            VirginiaAvenue.setVisible(true);
        }
        if (map.get(15).getOwner() == id){
            PennsylvaniaRailroad.setVisible(true);
        }
        if (map.get(16).getOwner() == id){
            StJamesPlace.setVisible(true);
        }
        if (map.get(18).getOwner() == id){
            TennesseeAvenue.setVisible(true);
        }
        if (map.get(19).getOwner() == id){
            NewYorkAvenue.setVisible(true);
        }
        if (map.get(21).getOwner() == id){
            KentuckyAvenue.setVisible(true);
        }
        if (map.get(23).getOwner() == id){
            IndianaAvenue.setVisible(true);
        }
        if (map.get(24).getOwner() == id){
            IllinoisAvenue.setVisible(true);
        }
        if (map.get(25).getOwner() == id){
            BORailroad.setVisible(true);
        }
        if (map.get(26).getOwner() == id){
            AtlanticAvenue.setVisible(true);
        }
        if (map.get(27).getOwner() == id){
            VentnorAvenue.setVisible(true);
        }
        if (map.get(28).getOwner() == id){
            WaterWorks.setVisible(true);
        }
        if (map.get(29).getOwner() == id){
            MarvinGardens.setVisible(true);
        }
        if (map.get(31).getOwner() == id){
            PacificAvenue.setVisible(true);
        }
        if (map.get(32).getOwner() == id){
            NorthCarolinaAvenue.setVisible(true);
        }
        if (map.get(34).getOwner() == id){
            PennsylvaniaAvenue.setVisible(true);
        }
        if (map.get(35).getOwner() == id){
            ShortLineRR.setVisible(true);
        }
        if (map.get(37).getOwner() == id){
            ParkPlace.setVisible(true);
        }
        if (map.get(39).getOwner() == id){
            Boardwalk.setVisible(true);
        }
    }
    
    public void setPlayer(Player player){ this.player = player;}

    public void setHashMap(HashMap<Integer, Property> map){
        this.map = map;
    }

    public void buyHouse(ActionEvent event){
        boolean canBuyHouses;
        int propertyId = selectedProperty.getBoardPosition();
        if (propertyId == 1 || propertyId == 3){
            if (map.get(1).getOwner() == map.get(3).getOwner()){
                selectedProperty.setHouseCount(selectedProperty.getHouseCount() + 1);
                player.loseMoney(selectedProperty.getHouseCost());
            }
        }
        if (propertyId == 6 || propertyId == 8 || propertyId == 9){
            if (map.get(6).getOwner() == map.get(8).getOwner() && map.get(6).getOwner() == map.get(9).getOwner()){
                selectedProperty.setHouseCount(selectedProperty.getHouseCount() + 1);
                player.loseMoney(selectedProperty.getHouseCost());
            }
        }
        if (propertyId == 11 || propertyId == 13 || propertyId == 14){
            if (map.get(11).getOwner() == map.get(13).getOwner() && map.get(11).getOwner() == map.get(14).getOwner()){
                selectedProperty.setHouseCount(selectedProperty.getHouseCount() + 1);
                player.loseMoney(selectedProperty.getHouseCost());
            }
        }
        if (propertyId == 16 || propertyId == 18 || propertyId == 19){
            if (map.get(16).getOwner() == map.get(18).getOwner() && map.get(16).getOwner() == map.get(19).getOwner()){
                selectedProperty.setHouseCount(selectedProperty.getHouseCount() + 1);
                player.loseMoney(selectedProperty.getHouseCost());
            }
        }
        if (propertyId == 21 || propertyId == 23 || propertyId == 24){
            if (map.get(21).getOwner() == map.get(23).getOwner() && map.get(21).getOwner() == map.get(24).getOwner()){
                selectedProperty.setHouseCount(selectedProperty.getHouseCount() + 1);
                player.loseMoney(selectedProperty.getHouseCost());
            }
        }
        if (propertyId == 26 || propertyId == 27 || propertyId == 29){
            if (map.get(26).getOwner() == map.get(27).getOwner() && map.get(26).getOwner() == map.get(29).getOwner()){
                selectedProperty.setHouseCount(selectedProperty.getHouseCount() + 1);
                player.loseMoney(selectedProperty.getHouseCost());
            }
        }
        if (propertyId == 31 || propertyId == 32 || propertyId == 34){
            if (map.get(31).getOwner() == map.get(32).getOwner() && map.get(31).getOwner() == map.get(34).getOwner()){
                selectedProperty.setHouseCount(selectedProperty.getHouseCount() + 1);
                player.loseMoney(selectedProperty.getHouseCost());
            }
        }
        if (propertyId == 37 || propertyId == 39){
            if (map.get(37).getOwner() == map.get(39).getOwner()){
                selectedProperty.setHouseCount(selectedProperty.getHouseCount() + 1);
                player.loseMoney(selectedProperty.getHouseCost());
            }
        }


    }

    public void selectMediterraneanAvenue(ActionEvent event) {
        selectedProperty = map.get(1);
        propertySelectedLabel.setText("Property Selected: Mediterranean Avenue");
    }

    public void selectBalticAvenue(ActionEvent event) {
        selectedProperty = map.get(3);
        propertySelectedLabel.setText("Property Selected: Baltic Avenue");
    }

    public void selectReadingRailroad(ActionEvent event) {
        selectedProperty = map.get(5);
        propertySelectedLabel.setText("Property Selected: Reading Railroad");
    }

    public void selectOrientalAvenue(MouseEvent event) {
        selectedProperty = map.get(6);
        propertySelectedLabel.setText("Property Selected: Oriental Avenue");}

    public void selectVermontAvenue(MouseEvent event) {
        selectedProperty = map.get(8);
        propertySelectedLabel.setText("Property Selected: Vermont Avenue");}

    public void selectConnecticutAvenue(MouseEvent event) {
        selectedProperty = map.get(9);
        propertySelectedLabel.setText("Property Selected: Connecticut Avenue");}

    public void selectStCharlesPlace(ActionEvent event) {
        selectedProperty = map.get(11);
        propertySelectedLabel.setText("Property Selected: St. Charles Place");}

    public void selectElectricCompany(ActionEvent event) {
        selectedProperty = map.get(12);
        propertySelectedLabel.setText("Property Selected: Electric Company");}

    public void selectStatesAvenue(MouseEvent event) {
        selectedProperty = map.get(13);
        propertySelectedLabel.setText("Property Selected: States Avenue");}

    public void selectVirginiaAvenue(MouseEvent event) {
        selectedProperty = map.get(14);
        propertySelectedLabel.setText("Property Selected: Virginia Avenue");}

    public void selectPennsylvaniaRailroad(ActionEvent event) {
        selectedProperty = map.get(15);
        propertySelectedLabel.setText("Property Selected: Pennsylvania Railroad");}

    public void selectStJamesPlace(ActionEvent event) {
        selectedProperty = map.get(16);
        propertySelectedLabel.setText("Property Selected: St. James Place");}

    public void selectTennesseeAvenue(MouseEvent event) {
        selectedProperty = map.get(18);
        propertySelectedLabel.setText("Property Selected: Tennessee Avenue");}

    public void selectNewYorkAvenue(MouseEvent event) {
        selectedProperty = map.get(19);
        propertySelectedLabel.setText("Property Selected: New York Avenue");}

    public void selectKentuckyAvenue(MouseEvent event) {
        selectedProperty = map.get(21);
        propertySelectedLabel.setText("Property Selected: Kentucky Avenue");}

    public void selectIndianaAvenue(MouseEvent event) {
        selectedProperty = map.get(23);
        propertySelectedLabel.setText("Property Selected: Indiana Avenue");}

    public void selectIllinoisAvenue(MouseEvent event) {
        selectedProperty = map.get(24);
        propertySelectedLabel.setText("Property Selected: Illinois Avenue");}

    public void selectBORailroad(ActionEvent event) {
        selectedProperty = map.get(25);
        propertySelectedLabel.setText("Property Selected: B&O Railroad");}

    public void selectAtlanticAvenue(MouseEvent event) {
        selectedProperty = map.get(26);
        propertySelectedLabel.setText("Property Selected: Atlantic Avenue");}

    public void selectVentnorAvenue(MouseEvent event) {
        selectedProperty = map.get(27);
        propertySelectedLabel.setText("Property Selected: Ventnor Avenue");}

    public void selectWaterWorks(MouseEvent event) {
        selectedProperty = map.get(28);
        propertySelectedLabel.setText("Property Selected: Water Works");}

    public void selectMarvinGardens(MouseEvent event) {
        selectedProperty = map.get(29);
        propertySelectedLabel.setText("Property Selected: Marvin Gardens");}

    public void selectPacificAvenue(MouseEvent event) {
        selectedProperty = map.get(31);
        propertySelectedLabel.setText("Property Selected: Pacific Avenue");}

    public void selectNorthCarolinaAvenue(MouseEvent event) {
        selectedProperty = map.get(32);
        propertySelectedLabel.setText("Property Selected: North Carolina Avenue");}

    public void selectPennsylvaniaAvenue(MouseEvent event) {
        selectedProperty = map.get(34);
        propertySelectedLabel.setText("Property Selected: Pennsylvania Avenue");}

    public void selectShortLineRR(ActionEvent event) {
        selectedProperty = map.get(35);
        propertySelectedLabel.setText("Property Selected: Short Line R.R.");}

    public void selectParkPlace(MouseEvent event) {
        selectedProperty = map.get(37);
        propertySelectedLabel.setText("Property Selected: Park Place");}

    public void selectBoardwalk(MouseEvent event) {
        selectedProperty = map.get(39);
        propertySelectedLabel.setText("Property Selected: Boardwalk");}
}
