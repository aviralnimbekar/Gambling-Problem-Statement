package com.bridgelabs;

public class GamblingProb {

    public static final int INITIAL_STAKE = 100;
    public static final int BET_STAKE = 1;
    public static int finalSakeForDay, initialStakeForDay;

    /**
     * making bet for win or lose
     *
     * @return final Stake after a bet
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
     * Betting for 20 days and adding each day's STAKE at the end of the day
     *
     * @return profitOrloss; (profit or loss for 20 day)
     */
    public static int stakeAtDay21() {

        int finalSakeAfterDay20 = 0;
        int profitOrloss;

        for (int i = 1; i <= 20; i++) {

            System.out.println("Day: " + i);
            resignationForDay();
            finalSakeAfterDay20 += finalSakeForDay;
        }
        profitOrloss = finalSakeAfterDay20 - INITIAL_STAKE * 20;
        return profitOrloss;
    }

    /**
     * Purpose - Execution of program by calling required method
     *
     * @param args resignationForDay
     */
    public static void main(String[] args) {
        System.out.println("Welcome to Gambling Problem");

        System.out.println("Profit or loss after day 20: " + stakeAtDay21());
    }
}

