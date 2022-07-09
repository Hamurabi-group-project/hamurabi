package hammurabi;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Hammurabi {
    Random rand = new Random();
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new Hammurabi().playGame();
    }

    void playGame() {
        int people = 100;
        int bushelsOwned = 2800;
        int bushelsOfFood = 0;
        int bushelsOfSeed = 0;
        int acres = 1000;
        int acresPlanted = 0;
        int price = 19;
        int year = 1;
        boolean gameOn = true;


        System.out.println("""
                Congratulations, you are the newest ruler of ancient Sumer, elected for a ten year term of office.
                Your duties are to dispense food, direct farming, and buy and sell land as needed to support your people.
                Watch out for rat infestations and the plague! Grain is the general currency, measured in bushels.
                The following will help you in your decisions:

                Each person needs at least 20 bushels of grain per year to survive
                Each person can farm at most 10 acres of land
                It takes 2 bushels of grain to farm an acre of land
                The market price for land fluctuates yearly
                Rule wisely and you will be showered with appreciation at the end of your term. Rule poorly and you will be kicked out of office!
                
                Ready to play?
                """);
        String ready = scanner.next();
        System.out.println("O great Hammurabi!\n" +
                    "You are in year " + year + " of your ten year rule.\n" +
                    "In the previous year 0 people starved to death.\n" +
                    "In the previous year 5 people entered the kingdom.\n" +
                    "The population is now " + people + ".\n" +
                    "We harvested 3000 bushels at 3 bushels per acre.\n" +
                    "Rats destroyed 200 bushels, leaving " + bushelsOwned + " bushels in storage.\n" +
                    "The city owns " + acres + " acres of land.\n" +
                    "Land is currently worth " + price + " bushels per acre.\n");

        while (gameOn) {
            System.out.println("Are you looking to buy or sell land?\n" +
                                "(1) to buy, (2) to sell, (3) to bypass");
            int userInput = scanner.nextInt();
                while (userInput == 1 || userInput == 2) {
                    if (userInput == 1) {
                        System.out.println("How many acres would you like to buy?");
                        int acresToBuy = scanner.nextInt();
                        if ((acresToBuy * price) < bushelsOwned) {
                            acres += Methods.askHowManyAcresToBuy(acresToBuy);
                            break;
                        }
                    } else if (userInput == 2) {
                        System.out.println("How many acres would you like to sell?");
                        int acresToSell = scanner.nextInt();
                        acres -= Methods.askHowManyAcresToSell(acresToSell);
                        break;
                    }
                }

            System.out.println("How many bushels of grain would you like to use to feed your people?");
            userInput = scanner.nextInt();
            bushelsOfFood = Methods.askHowMuchGrainToFeedPeople(userInput);

            System.out.println("How many acres would you like to plant with grain?");
            userInput = scanner.nextInt();
            acresPlanted = Methods.askHowManyAcresToPlant(acres, people, bushelsOwned);

//            int plagueDeaths = finalMethods.plagueDeaths(people);
//            int starvationDeaths = finalMethods.starvationDeaths(people, bushelsOfFood);
//            boolean uprising = finalMethods.uprising(people, starvationDeaths);
//            int immigrants = finalMethods.immigrants(people, acres, bushels);
//            int harvest = finalMethods.harvest(acres, bushelsOfSeed);
//            int grainEatenByRats = finalMethods.grainEatenByRats(bushels);
//            price = finalMethods.newCostOfLand();
//            year++;
//            System.out.println("O great Hammurabi!\n" +
//                    "You are in year " + year + " of your ten year rule.\n" +
//                    "In the previous year " + starvationDeaths + " people starved to death.\n" +
//                    "In the previous year " + immigrants + " people entered the kingdom.\n" +
//                    "The population is now " + people + ".\n" +
//                    "We harvested " + harvest + " bushels at " + harvestRate + " bushels per acre.\n" +
//                    "Rats destroyed " + grainEatenByRats + " bushels, leaving " + bushelsOwned + " bushels in storage.\n" +
//                    "The city owns " + acres + " acres of land.\n" +
//                    "Land is currently worth " + price + " bushels per acre.\n");
        }
    }
}
