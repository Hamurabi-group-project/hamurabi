package hammurabi;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Methods {

    static Scanner scanner = new Scanner(System.in);
    static int userInput = scanner.nextInt();

    static int getNumber(String message) {
        while (true) {
            System.out.print(message);
            try {
                return userInput;
            } catch (InputMismatchException e) {
                System.out.println("\"" + userInput + "\" isn't a number!");
            }
        }
    }
    static int askHowManyAcresToBuy(int acresToBuy) {
        return acresToBuy;
    }
    static int askHowManyAcresToSell(int acresToSell) {
        return acresToSell;
    }
    static int askHowMuchGrainToFeedPeople(int input) {
        return input;
    }
    static int askHowManyAcresToPlant(int acres, int population, int bushels) {
        return acres;
    }
}


