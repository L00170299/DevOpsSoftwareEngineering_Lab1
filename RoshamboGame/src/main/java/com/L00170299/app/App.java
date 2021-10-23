package com.L00170299.app;

import java.util.*;

/**
 * Hello Roshambo!
 *
 */
public class App 
{
    public static void main(String[] args)
    {
        try (Scanner sc = new Scanner(System.in)) {
            cls();
            System.out.println( "Hello, In some circles, the decisive game of Rock, Paper, Scissors goes by another name: Roshambo!!" );
            System.out.print("What is your name? : ");
            String userName = sc.nextLine();

            System.out.printf("Welcome to %s, let's play some Roshambo..\n", userName);
            System.out.print("Click enter to continue:");
            sc.nextLine(); //simulate pause and wait for user to click 'Enter'

            int userScore = 0;
            int roshamboScore = 0;

            play(userName, userScore, roshamboScore);
        }
    }

    public static void cls(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void showScore(String userName, int userScore, int roshamboScore){
        cls();
        System.out.printf("SCORE: %s: %d, Roshambo: %d \n", userName, userScore, roshamboScore);
        System.out.println("======================================================");
    }

    public static void play(String userName, int userScore, int roshamboScore){
        try (Scanner sc = new Scanner(System.in)) {
            showScore(userName, userScore, roshamboScore);
            System.out.print("What do you choose?\n" +
            "R = <Rock> | P = <Paper> | S = <Scissors> | E = <Exit> : "); //TODO: Validate if user put correct option.. but after

            String userHand = sc.nextLine();
            String roshamboHand = getRandomHand();

            if(userHand.equals("E")){
                return;
            } else {
                String handResult = testWinnerHand(userHand, roshamboHand);
                if(handResult.equals("User")){
                    userScore += 1;
                } else if (handResult.equals("Roshambo")) { //TODO: If not correct option by user... Roshambo wins everything. some day I'll fix
                    roshamboScore += 1;
                }

                play(userName, userScore, roshamboScore);
            }
        }
    }

    public static String getRandomHand(){
        Random rand = new Random();
        List<String> givenList = Arrays.asList("R", "P", "S");
        int randomIndex = rand.nextInt(givenList.size());
        String randomElement = givenList.get(randomIndex);

        return randomElement;
    }

    public static String testWinnerHand(String userHand, String roshamboHand){
        String winner;
        List<String> userWinsList = Arrays.asList("R:S", "S:P", "P:R");

        //If both have the same
        if(userHand.equals(roshamboHand)){
            winner = "Draw";
        } else if (userWinsList.contains(userHand+":"+roshamboHand)) {
            winner = "User";
        } else {
            winner = "Roshambo";
        }

        return winner;
    }
}
