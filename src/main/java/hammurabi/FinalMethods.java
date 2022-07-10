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
        return null;
    }

    public Integer newCostOfLand() {
        return null;
    }



}
