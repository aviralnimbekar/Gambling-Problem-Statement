package com.bridgelabs;

public class GamblingProb {

    public static final int INITIALSTAKE = 100;
    public static final int BETSTAKE = 1;

    /**
     * making bet
     *
     * @return totalStake
     */
    public void makeBet() {

        int win = 1;
        int random = (int) (Math.random() * 2);

        if (random == win) {
            System.out.println("WON");;
        } else {
            System.out.println("LOSE");
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Gambling Problem");

        GamblingProb game = new GamblingProb();
        game.makeBet();
    }
}