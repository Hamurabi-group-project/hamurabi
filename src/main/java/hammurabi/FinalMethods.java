package hammurabi;
import java.util.Random;

public class FinalMethods {
    static Random rand = new Random();

    public Integer plagueDeaths(int population) {

        if (rand.nextInt(100) > 15) {
            return population / 2;
        }
        return 0;
    }

    public Integer starvationDeaths(int population, int bushelsFedToPeople) {

        return null;
    }


    public Boolean uprising(int population, int howManyPeopleStarved) {

        int i = 0;

        while ((double)howManyPeopleStarved / population > 0.45) {

            i++;

        }
        return true;
    }

    public Integer immigrants(int population, int acresOwned, int grainInStorage) {
        return (20 * acresOwned + grainInStorage) / (100 * population);
    }

    public Integer harvest(int acres, int bushelsIsUsedAsSeed) {


        return null;
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
