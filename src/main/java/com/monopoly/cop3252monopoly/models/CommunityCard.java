package com.monopoly.cop3252monopoly.models;

public class CommunityCard {

    private String title;
    private final int communityID;

    public CommunityCard(int id) {
        communityID = id;
        title = "";
    }

    public String getTitle() {return title;}
    public void setTitle(String cardTitle) {title = cardTitle;}

    public int getCommunityID() {return communityID;}
    public String getCardType() {return "Community Chest";}
}
