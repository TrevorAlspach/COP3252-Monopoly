package com.monopoly.cop3252monopoly.models;

import java.util.Random;

public class Dice {
    final private int[] dice1;
    final private int[] dice2;
    private int lastRoll;
    private int DEBUGdice1;
    private int DEBUGdice2;
    private Random random;

    public Dice() {
        // constructor
        dice1 = new int[]{1, 2, 3, 4, 5, 6};
        dice2 = new int[]{1, 2, 3, 4, 5, 6};
        random = new Random();
        lastRoll = -1;
    }

    public boolean DiceRollTurn(Player player) {
        // for normal turns
        int sum, x, y;
        x = random.nextInt(6);
        y = random.nextInt(6);
        sum = dice1[x] + dice2[y];
        DEBUGdice1 = dice1[x];
        DEBUGdice2 = dice2[y];
        lastRoll = sum;
        player.movePlayer(sum);

        return x == y;
    }

    public int getLastRoll() { return lastRoll; }
    public int getDie1Roll() { return DEBUGdice1; }
    public int getDie2Roll() { return DEBUGdice2; }
    public boolean lastRollIsDouble() { return DEBUGdice2 == DEBUGdice1; }

    public int DiceRollMultiplied(Player sender, Player receiver, int mult) {
        // for utilities
        int sum;
        sum = 1 + random.nextInt(12);
        return (sum * mult);
    }
}