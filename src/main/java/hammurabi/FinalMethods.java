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
        return null;
    }

    public Integer newCostOfLand() {
        return null;
    }



}
