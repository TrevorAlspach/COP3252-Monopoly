package com.monopoly.cop3252monopoly.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Property {
    //board Position -> base rent, rent w/1 house, rent w/2 houses, rent w/3 houses, rent w/4 houses, rent w/hotel, house cost
    public static Map<Integer, ArrayList<Integer>> propertyValues = new HashMap<>(){{
        put(1, new ArrayList<>(Arrays.asList(2, 10, 30, 90, 160, 250, 1, 50)));
        put(3, new ArrayList<>(Arrays.asList(4, 20, 60, 180, 320, 450, 3, 50)));
        put(5, new ArrayList<>(Arrays.asList(25,50,100,200)));
        put(6, new ArrayList<>(Arrays.asList(6, 30, 90, 270, 400, 550, 6, 50)));
        put(8, new ArrayList<>(Arrays.asList(6, 30, 90, 270, 400, 550, 8, 50)));
        put(9, new ArrayList<>(Arrays.asList(8, 40, 100, 300, 450, 600, 9, 50)));
        put(11, new ArrayList<>(Arrays.asList(10, 50, 150, 450, 625, 750, 11, 100)));
        put(13, new ArrayList<>(Arrays.asList(10, 50, 150, 450, 625, 750, 13, 100)));
        put(14, new ArrayList<>(Arrays.asList(12, 60, 180, 550, 700, 900, 14, 100)));
        put(15, new ArrayList<>(Arrays.asList(25,50,100,200)));
        put(16, new ArrayList<>(Arrays.asList(14, 70, 200, 550, 750, 950, 16, 100)));
        put(18, new ArrayList<>(Arrays.asList(14, 70, 200, 550, 750, 950, 18, 100)));
        put(19, new ArrayList<>(Arrays.asList(16, 80, 220, 600, 800, 1000, 19, 100)));
        put(21, new ArrayList<>(Arrays.asList(18, 90, 250, 700, 875, 1050, 21, 150)));
        put(23, new ArrayList<>(Arrays.asList(18, 90, 250, 700, 875, 1050, 23, 150)));
        put(24, new ArrayList<>(Arrays.asList(20, 100, 300, 750, 925, 1100, 24, 150)));
        put(25, new ArrayList<>(Arrays.asList(25,50,100,200)));
        put(26, new ArrayList<>(Arrays.asList(22, 110, 330, 800, 975, 1150, 26, 150)));
        put(27, new ArrayList<>(Arrays.asList(22, 110, 330, 800, 975, 1150, 27, 150)));
        put(29, new ArrayList<>(Arrays.asList(24, 120, 360, 850, 1025, 1200, 29, 150)));
        put(31, new ArrayList<>(Arrays.asList(26, 130, 390, 900, 1100, 1275, 31, 200)));
        put(32, new ArrayList<>(Arrays.asList(26, 130, 390, 900, 1100, 1275, 32, 200)));
        put(34, new ArrayList<>(Arrays.asList(28, 150, 450, 1000, 1200, 1400, 34, 200)));
        put(35, new ArrayList<>(Arrays.asList(25,50,100,200)));
        put(37, new ArrayList<>(Arrays.asList(35, 175, 500, 1100, 1300, 1500, 37, 200)));
        put(39, new ArrayList<>(Arrays.asList(50, 200, 600, 1400, 1700, 2000, 39, 200)));
        //Railroads and Utilities
    }};

    public static Map<Integer, String> propertyNames = new HashMap<>(){{
        put(1, "Mediterranean Avenue");
        put(3, "Baltic Avenue");
        put(5, "Reading Railroad");
        put(6, "Oriental Avenue");
        put(8, "Vermont Avenue");
        put(9, "Connecticut Avenue");
        put(11, "St. Charles Place");
        put(13, "States Avenue");
        put(14, "Virginia Avenue");
        put(15, "Pennsylvania Railroad");
        put(16, "St. James Place");
        put(18, "Tennessee Avenue");
        put(19, "New York Avenue");
        put(21, "Kentucky Avenue");
        put(23, "Indiana Avenue");
        put(24, "Illinois Avenue");
        put(25, "B&O Railroad");
        put(26, "Atlantic Avenue");
        put(27, "Ventnor Avenue");
        put(29, "Marvin Gardens");
        put(31, "Pacific Avenue");
        put(32, "North Carolina Avenue");
        put(34, "Pennsylvania Avenue");
        put(35, "Short Line R.R.");
        put(37, "Park Place");
        put(39, "Boardwalk");
    }};

    private boolean isOwned;
    private int owner;
    private String propertyTitle;
    private int houseCount;
    private int houseCost;
    private boolean isRailroad;
    private boolean isUtility;

    private Map<Integer, Integer> rentCost;

    private int boardPosition;

    public int getBoardPosition() {
        return boardPosition;
    }

    public void setBoardPosition(int boardPosition) {
        this.boardPosition = boardPosition;
    }

    public boolean isOwned() {
        return isOwned;
    }

    public void setOwned(boolean owned) {
        isOwned = owned;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public String getPropertyTitle() {
        return propertyTitle;
    }

    public void setPropertyTitle(String propertyTitle) {
        this.propertyTitle = propertyTitle;
    }

    public int getHouseCount() {
        return houseCount;
    }

    public void setHouseCount(int houseCount) {
        this.houseCount = houseCount;
    }

    public int getHouseCost() {
        return houseCost;
    }


    public Property(int propId){
        this.isOwned = false;
        this.owner = 0;
        this.isUtility = propId == 12 || propId == 28;
        this.isRailroad = propId == 5 || propId == 15 || propId == 25 || propId == 35;
        this.propertyTitle = propertyNames.get(propId);
        this.houseCount = 0;
        this.boardPosition = propId;

        if (isRailroad || isUtility){
            this.houseCost = 0;
        }
        else{
            this.houseCost = propertyValues.get(propId).get(7);
        }
    }

}
