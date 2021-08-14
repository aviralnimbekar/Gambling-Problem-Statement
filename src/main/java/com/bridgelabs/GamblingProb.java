package com.bridgelabs;

import java.util.Scanner;

public class GamblingProb {

    public static final int INITIAL_STAKE = 100;
    public static final int BET_STAKE = 1;
    public static int finalSakeForDay, initialStakeForDay, LOWER_AMOUNT,
            UPPER_AMOUNT, winCountOfMonth, loseCountOfMonth, TOTAL_DAYS = 30;
    public static int arr[] = new int[TOTAL_DAYS];

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

        for (int i = 1; i <= TOTAL_DAYS; i++) {

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
            arr[i - 1] = finalSakeAfterDay20 - INITIAL_STAKE * i;
        }

        System.out.println("Total WINS in a month: " + winCountOfMonth + "\n"
                + "Total LOSES in a month: " + loseCountOfMonth);

        profitOrloss = finalSakeAfterDay20 - INITIAL_STAKE * TOTAL_DAYS;
        return profitOrloss;
    }

    /**
     * To get the luckiest day i.e.  he/she won the most or unluckiest day i.e. he/she lost the most
     */
    public static void luckyUnluckyDay() {

        int max = 0;
        int min = 1500;
        int luckiestDay = 0, unluckiestDay = 0;

        for (int arr : arr) {

            if (max < arr) {
                max = arr;
            }
            if (min > arr)
                min = arr;
        }

        for (int i = 0; i < TOTAL_DAYS; i++) {

            if (arr[i] == max) {
                luckiestDay = i + 1;
                System.out.println("Luckiest day: day:" + luckiestDay);
            }
            if (arr[i] == min) {
                unluckiestDay = i + 1;
                System.out.println("Unluckiest day: day:" + unluckiestDay);
            }
        }
        System.out.println("Profit on luckiest day: " + max + "\n"
                + "Loss on unluckiest day: " + min);
    }

    /**
     *Ask user whether he/she wants to continue the game to quite
     */
    public static void continuation() {

        boolean playAgain = true;

        while (playAgain) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Play Again y/n");
            char ans = sc.next().charAt(0);
            if (ans == 'y') {
                System.out.println("Profit or loss after a month(30 days): " + stakeAfterMonth());
                luckyUnluckyDay();
            } else if (ans == 'n') {
                break;
            } else {
                System.out.println("Please enter y or n");
                continue;
            }
        }
    }

    /**
     * Purpose - Execution of program by calling required method
     *
     * @param args stakeAfterMonth(), luckyUnluckyDay(), continuation()
     */
    public static void main(String[] args) {
        System.out.println("Welcome to Gambling Problem");

        System.out.println("Profit or loss after a month(30 days): " + stakeAfterMonth());
        luckyUnluckyDay();
        continuation();
    }
}