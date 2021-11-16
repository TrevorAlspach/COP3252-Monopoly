package com.monopoly.cop3252monopoly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Property {

    public static Map<Integer, ArrayList<Integer>> propertyValues = new HashMap<>(){{
        put(1, new ArrayList<>(Arrays.asList(2, 10, 30, 90, 160, 250, 1)));
        put(2, new ArrayList<>(Arrays.asList(4, 20, 60, 180, 320, 450, 3)));
        put(3, new ArrayList<>(Arrays.asList(6, 30, 90, 270, 400, 550, 6)));
        put(4, new ArrayList<>(Arrays.asList(6, 30, 90, 270, 400, 550, 8)));
        put(5, new ArrayList<>(Arrays.asList(8, 40, 100, 300, 450, 600, 9)));
        put(6, new ArrayList<>(Arrays.asList(10, 50, 150, 450, 625, 750, 11)));
        put(7, new ArrayList<>(Arrays.asList(10, 50, 150, 450, 625, 750, 13)));
        put(8, new ArrayList<>(Arrays.asList(12, 60, 180, 550, 700, 900, 14)));
        put(9, new ArrayList<>(Arrays.asList(14, 70, 200, 550, 750, 950, 16)));
        put(10, new ArrayList<>(Arrays.asList(14, 70, 200, 550, 750, 950, 18)));
        put(11, new ArrayList<>(Arrays.asList(16, 80, 220, 600, 800, 1000, 19)));
        put(12, new ArrayList<>(Arrays.asList(18, 90, 250, 700, 875, 1050, 21)));
        put(13, new ArrayList<>(Arrays.asList(18, 90, 250, 700, 875, 1050, 23)));
        put(14, new ArrayList<>(Arrays.asList(20, 100, 300, 750, 925, 1100, 24)));
        put(15, new ArrayList<>(Arrays.asList(22, 110, 330, 800, 975, 1150, 26)));
        put(16, new ArrayList<>(Arrays.asList(22, 110, 330, 800, 975, 1150, 27)));
        put(17, new ArrayList<>(Arrays.asList(24, 120, 360, 850, 1025, 1200, 29)));
        put(18, new ArrayList<>(Arrays.asList(26, 130, 390, 900, 1100, 1275, 31)));
        put(19, new ArrayList<>(Arrays.asList(26, 130, 390, 900, 1100, 1275, 32)));
        put(20, new ArrayList<>(Arrays.asList(28, 150, 450, 1000, 1200, 1400, 34)));
        put(21, new ArrayList<>(Arrays.asList(35, 175, 500, 1100, 1300, 1500, 37)));
        put(22, new ArrayList<>(Arrays.asList(50, 200, 600, 1400, 1700, 2000, 39)));
        //Need to add Railroads and Utilities
    }};

    public static Map<Integer, String> propertyNames = new HashMap<>(){{
        put(1, "Mediterranean Avenue");
        put(2, "Baltic Avenue");
        put(3, "Oriental Avenue");
        put(4, "Vermont Avenue");
        put(6, "St. Charles Place");
        put(7, "States Avenue");
        put(8, "Virginia Avenue");
        put(9, "St. James Place");
        put(10, "Tennessee Avenue");
        put(11, "New York Avenue");
        put(12, "Kentucky Avenue");
        put(13, "Indiana Avenue");
        put(14, "Illinois Avenue");
        put(15, "Atlantic Avenue");
        put(16, "Ventnor Avenue");
        put(17, "Marvin Gardens");
        put(18, "Pacific Avenue");
        put(19, "North Carolina Avenue");
        put(20, "Pennsylvania Avenue");
        put(21, "Park Place");
        put(22, "Boardwalk");
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

    public void setHouseCost(int houseCost) {
        this.houseCost = houseCost;
    }

    public boolean isRailroad() {
        return isRailroad;
    }

    public void setRailroad(boolean railroad) {
        isRailroad = railroad;
    }

    public boolean isUtility() {
        return isUtility;
    }

    public void setUtility(boolean utility) {
        isUtility = utility;
    }



    public Property(int propId){
        this.isOwned = false;
    }

}
