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
        int acres = 1000;
        int acresPlanted = 0;
        int price = 19;
        int year = 1;



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
        System.out.println("O great Hammurabi!\n" +
                    "You are in year " + year + " of your ten year rule.\n" +
                    "In the previous year 0 people starved to death.\n" +
                    "In the previous year 5 people entered the kingdom.\n" +
                    "The population is now " + people + ".\n" +
                    "We harvested 3000 bushels at 3 bushels per acre.\n" +
                    "Rats destroyed 200 bushels, leaving " + bushelsOwned + " bushels in storage.\n" +
                    "The city owns " + acres + " acres of land.\n" +
                    "Land is currently worth " + price + " bushels per acre.\n");

        while (year <= 10) {
            System.out.println("Are you looking to buy or sell land?\n" +
                                "(1) to buy, (2) to sell, (3) to bypass");
            int userInput = scanner.nextInt();
                if (userInput == 1 || userInput == 2) {
                    if (userInput == 1) {
                        System.out.println("How many acres would you like to buy?");
                        int acresToBuy = scanner.nextInt();
                        if ((acresToBuy * price) < bushelsOwned) {
                            acres += Methods.askHowManyAcresToBuy(acresToBuy);
                            bushelsOwned -= (acresToBuy * price);
                        }
                    } else if (userInput == 2) {
                        System.out.println("How many acres would you like to sell?");
                        int acresToSell = scanner.nextInt();
                        acres -= Methods.askHowManyAcresToSell(acresToSell);
                        bushelsOwned += (acresToSell * price);
                    }
                }

            System.out.println("How many bushels of grain would you like to use to feed your people?");
            int howMany = scanner.nextInt();
            bushelsOfFood = Methods.askHowMuchGrainToFeedPeople(howMany, bushelsOwned);
            bushelsOwned -= bushelsOfFood;

            System.out.println("How many acres would you like to plant with grain?");
            int howMuch = scanner.nextInt();
            acresPlanted = Methods.askHowManyAcresToPlant(howMuch, people, bushelsOwned);
            bushelsOwned -= (acresPlanted * 2);


            int plagueDeaths = FinalMethods.plagueDeaths(people);
            int starvationDeaths = FinalMethods.starvationDeaths(people, bushelsOfFood);
            boolean revolt = FinalMethods.uprising(people, starvationDeaths);
            int immigrants = FinalMethods.immigrants(people, acres, bushelsOwned);
            int[] harvestArray = FinalMethods.harvest(acresPlanted);
            int harvest = harvestArray[0];
            int harvestRate = harvestArray[1];
//harvest tests only have one parameter, so we removed it here
            int grainEatenByRats = FinalMethods.grainEatenByRats(bushelsOwned);
            people = people - plagueDeaths - starvationDeaths + immigrants;
            price = FinalMethods.newCostOfLand();
            bushelsOwned = (bushelsOwned - grainEatenByRats + harvest);
            year++;
            if (revolt == true) {
                System.out.println("Run Hammurabi! There's an uprising, the kingdom has been overthrown!");
                break;
            }
            System.out.println("O great Hammurabi!\n" +
                    "You are in year " + year + " of your ten year rule.\n" +
                    "In the previous year " + plagueDeaths + " people died of the plague.\n" +
                    "In the previous year " + starvationDeaths + " people starved to death.\n" +
                    "In the previous year " + immigrants + " people entered the kingdom.\n" +
                    "The population is now " + people + ".\n" +
                    "We harvested " + harvest + " bushels at " + harvestRate + " bushels per acre.\n" +
                    "Rats destroyed " + grainEatenByRats + " bushels, leaving " + bushelsOwned + " bushels in storage.\n" +
                    "The city owns " + acres + " acres of land.\n" +
                    "Land is currently worth " + price + " bushels per acre.\n");
        }
    }
}
