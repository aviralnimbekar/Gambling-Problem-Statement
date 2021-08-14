package com.bridgelabs;

public class GamblingProb {

    public static final int INITIAL_STAKE = 100;
    public static final int BET_STAKE = 1;
    public static int finalSakeForDay, initialStakeForDay, LOWER_AMOUNT,
            UPPER_AMOUNT, winCountOfMonth, loseCountOfMonth;

    /**
     * making bet for win or lose
     *
     * @return final Stake after a bet
     * variable: initialStakeForDay
     */
    public static int makeBet() {

        int WIN = 1;
        int random = (int) (Math.random() * 2);

        if (random == WIN)
            initialStakeForDay++;
        else
            initialStakeForDay--;

        return initialStakeForDay;
    }

    /**
     * Betting for single day only
     *
     * @return finalStakeForDay
     */
    public static int resignationForDay() {

        LOWER_AMOUNT = INITIAL_STAKE - INITIAL_STAKE / 2;
        UPPER_AMOUNT = INITIAL_STAKE + INITIAL_STAKE / 2;
        initialStakeForDay = 100;
        boolean run = true;

        while (run) {

            makeBet();
            if (initialStakeForDay <= LOWER_AMOUNT)
                run = false;
            if (initialStakeForDay >= UPPER_AMOUNT)
                run = false;
        }
        finalSakeForDay = initialStakeForDay;
        return finalSakeForDay;
    }

    /**
     * Betting for a month (30 days), counting each day's profit/loss and adding each day's STAKE at the end of the day
     *
     * @return profitOrloss; (profit or loss for 30 day)
     */
    public static int stakeAfterMonth() {

        int finalSakeAfterDay20 = 0;
        int profitOrloss;

        for (int i = 1; i <= 30; i++) {

            System.out.println("Day: " + i);
            resignationForDay();

            if (finalSakeForDay == LOWER_AMOUNT) {
                System.out.println("Lose for day");
                loseCountOfMonth++;
            } else if (finalSakeForDay == UPPER_AMOUNT) {
                System.out.println("Win for day");
                winCountOfMonth++;
            }
            finalSakeAfterDay20 += finalSakeForDay;
        }

        System.out.println("Total WINS in a month: " + winCountOfMonth + "\n"
                + "Total LOSES in a month: " + loseCountOfMonth);

        profitOrloss = finalSakeAfterDay20 - INITIAL_STAKE * 30;
        return profitOrloss;
    }

    /**
     * Purpose - Execution of program by calling required method
     *
     * @param args stakeAfterMonth()
     */
    public static void main(String[] args) {
        System.out.println("Welcome to Gambling Problem");

        System.out.println("Profit or loss after a month(30 days): " + stakeAfterMonth());
    }
}