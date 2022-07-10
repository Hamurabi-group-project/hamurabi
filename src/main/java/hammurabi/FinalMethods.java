package hammurabi;
import java.util.Random;

public class FinalMethods {
    static Random rand = new Random();

    public Integer plagueDeaths(int population) {

        int plagueDeaths = 0;
        boolean isPlague;
        int plagueIndex = rand.nextInt(101);

        if (plagueIndex > 85) {
            isPlague = true;
        } else {
            isPlague = false;
        }
        if (isPlague) {
            plagueDeaths = (int) (0.5 * population);
        }

        return plagueDeaths;
    }

    public Integer starvationDeaths(int population, int bushelsFedToPeople) {

        int starvationDeaths = 0;
        int peopleFed = bushelsFedToPeople / 20;

        if (population > bushelsFedToPeople / 20) {

            starvationDeaths = population - bushelsFedToPeople / 20;
        }

        return starvationDeaths;
    }


    public Boolean uprising(int population, int howManyPeopleStarved) {

        boolean isRevolt = false;

        if (howManyPeopleStarved > population *0.45) {
            isRevolt = true;
        }

        return isRevolt;
    }

    public Integer immigrants(int population, int acresOwned, int grainInStorage) {
        return (20 * acresOwned + grainInStorage) / (100 * population) + 1;
    }

    public Integer harvest(int acres) {

        int bushels = 0;
        int cropYieldIndex = rand.nextInt(6) + 1;
        bushels = acres * cropYieldIndex;
        System.out.print(bushels);

        return bushels;
    }

    public Integer grainsEatenByRats(int bushels) {
     //40% chance of rat infestation
     //if so, rats will eat btwn 10%-30% of your grain
     //return amount of grain eaten by rats(possibly zero)
     //no need for boolean here because this method has already been established that there's a rat infestation

        double ratEats10 = 0.1;
        double ratEats20 = 0.2;
        double ratEats30 = 0.3;

        double grainsEaten = ratEats10 * bushels;


        return Math.toIntExact(Math.round(grainsEaten));
        //Math.toIntExact returns solution as an integer
    }

    public Integer newCostOfLand() {
    //price of land is random, ranges from 17 to 23 bushels/acre
    //return new price for next set of decisions player has to make
    //player will need this info to buy or sell land
    //get a random # generator
        int x = rand.nextInt(23 - 17 + 1) + 17;
                System.out.println(x);

        return x;
    }



}
