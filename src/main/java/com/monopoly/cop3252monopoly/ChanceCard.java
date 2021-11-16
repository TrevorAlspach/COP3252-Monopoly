package com.monopoly.cop3252monopoly;

public class ChanceCard {

    private String title;
    private int chanceID;

    public ChanceCard(int id) {
        chanceID = id;
        title = "";
    }

    public String getTitle() {return title;}
    public void setTitle(String cardTitle) {title = cardTitle;}

    public int getChanceID() {return chanceID;}
}
