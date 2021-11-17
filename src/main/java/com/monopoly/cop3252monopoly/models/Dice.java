package com.monopoly.cop3252monopoly.models;

import java.util.Random;

public class Dice {
    final private int[] dice1;
    final private int[] dice2;
    private Random random;

    public Dice() {
        // constructor
        dice1 = new int[]{1, 2, 3, 4, 5, 6};
        dice2 = new int[]{1, 2, 3, 4, 5, 6};
        random = new Random();
    }

    public void DiceRollTurn(Player player) {
        // for normal turns
        int sum, x, y;
        x = random.nextInt(6);
        y = random.nextInt(6);
        sum = dice1[x] + dice2[y];
        player.movePlayer(sum);

        if (x == y)
        {
            // doubles get you out of jail!
            if (player.getCurrentPosition() == 10)
            {
                // let them out of jail :0
            }

            // doubles! notify player that they can go again
            x = random.nextInt(6);
            y = random.nextInt(6);
            sum = dice1[x] + dice2[y];
            player.movePlayer(sum);

            if (x == y)
            {
                // doubles! notify player that they can go again (the final time)
                x = random.nextInt(6);
                y = random.nextInt(6);
                if (x == y)
                {
                    player.setCurrentPosition(10);
                    // you're in jail >:)
                }
                player.movePlayer(sum);
            }
        }
    }

    public int DiceRollMultiplied(Player sender, Player receiver, int mult) {
        // for utilities
        int sum;
        sum = 1 + random.nextInt(12);
        return (sum * mult);
    }
}