package com.bridgelabs;

public class GamblingProb {

    public static final int INITIALSTAKE = 100;
    public static final int BETSTAKE = 1;

    /**
     * making bet
     *
     * @return totalStake
     */
    public int makeBet() {

        int win = 1;
        int totalStake = 100;
        int random = (int) (Math.random() * 2);

        if (random == win) {
            totalStake++;
        } else {
            totalStake--;
        }
        return totalStake;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Gambling Problem");
    }
}