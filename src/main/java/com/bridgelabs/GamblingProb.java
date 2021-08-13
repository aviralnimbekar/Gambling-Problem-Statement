package com.bridgelabs;

public class GamblingProb {

    public static final int INITIAL_STAKE = 100;
    public static final int BET_STAKE = 1;
    public static int finalSakeForDay, initialStakeForDay;


    /**
     * making bet for win or lose
     *
     * @return finalSakeForDay
     * variable: initialStakeForDay
     */
    public static int makeBet() {

        int WIN = 1;
        int random = (int) (Math.random() * 2);

        if (random == WIN) {
            System.out.println("***WON***");
            initialStakeForDay++;
        } else {
            System.out.println("***LOSE***");
            initialStakeForDay--;
        }
        return initialStakeForDay;
    }

    /**
     * Betting for single day only
     *
     * @return finalStakeForDay
     */
    public static int resignationForDay() {

        int lowerAmount = INITIAL_STAKE - INITIAL_STAKE / 2;
        int upperAmount = INITIAL_STAKE + INITIAL_STAKE / 2;
        initialStakeForDay = 100;
        boolean run = true;

        while (run) {

            makeBet();
            if (initialStakeForDay <= lowerAmount)
                run = false;
            if (initialStakeForDay >= upperAmount)
                run = false;
        }
        finalSakeForDay = initialStakeForDay;
        return finalSakeForDay;
    }

    /**
     * Purpose - Execution of program by calling required method
     * @param args resignationForDay
     */
    public static void main(String[] args) {
        System.out.println("Welcome to Gambling Problem");

        System.out.println("Gambler reached to " + resignationForDay() + " and stopped for day");
    }
}

