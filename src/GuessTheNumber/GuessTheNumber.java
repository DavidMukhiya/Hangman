package Project_2;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

    //check for play again
    public static void checkPlayAgain(Scanner sc) {
        System.out.println("\nWould you like to play again?(y or n)");
        String userInput = sc.next();

        //taking specific input 'y' or 'n' only
        //while(((userInput.equalsIgnoreCase("y")) || (userInput.equalsIgnoreCase("n"))) != true)
        while (!((userInput.equalsIgnoreCase("y")) || (userInput.equalsIgnoreCase("n")))){
            System.out.println("\nPlease Enter 'y' or 'n'.");
            userInput = sc.next();
        }
        // for condition userInput = y
        if (userInput.equalsIgnoreCase("y")) {
            System.out.println("\n!!!Wow!!! - Thank you.. for Playing Again!!!");
            //GuessTheNumber.newGame();
            main(null);

        //for condition userInput = n
        } else {
            System.out.println("\nThank you for Playing. See you soon!!!");
        }
    }

    //guess method
    public int guess() {
        //generating Random number (1-20) from random class.
        Random random = new Random();
        int comSecretNum = random.nextInt(20) + 1;
        //System.out.println(comSecretNum); //for checking

        //taking user input
        Scanner sc = new Scanner(System.in);
        System.out.println("\nHello! What is your Name?");
        String name = "";

        try {
            //only check if whether the input is fully Integer or not.
            if (!sc.hasNextInt()) {
                name = sc.next();
                if (name.length() < 2) {
                    throw new GuessTheNumberCustomException("Name should be at least of length 2");
                }
            } else {
                throw new GuessTheNumberCustomException("Please enter your name. You type only Number.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("try Again");
            main(null);
        }

        System.out.println("\nWell " + name + ", I am thinking of a number between 1 and 20.\n" +
                "Take a guess.");

        int i = 1;
        //checking for 6 tires and also guessing the number.
        while (i < 7) {
            System.out.print("\nEnter Your Number: ");
            try {
                if (sc.hasNextInt()) {
                    int guessNum = sc.nextInt();
                    if (guessNum == comSecretNum) {
                        System.out.println("\nGood Job, " + name + "! You guessed my number in " + i + " guesses!.");
                        //if user wants to play again
                        GuessTheNumber.checkPlayAgain(sc);
                        break;
                        //GuessTheNumber.newGame();
                    } else if (guessNum > comSecretNum) {
                        System.out.println("Your guess is too high.");
                        i++;
                    } else {
                        System.out.println("Your guess is too low");
                        i++;
                    }
                } else {
                    throw new GuessTheNumberCustomException("You didn't Enter the no. Please Enter the Number.");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                sc= new Scanner(System.in);
            }
        }
            //return no of tries.
        return i;
    }

    public static void main(String[] args) {
        GuessTheNumber guessTheNumber = new GuessTheNumber();
        int tries = guessTheNumber.guess();
        //Checking if no of tires is greater than 6.
        if (tries > 6) {
            System.out.println("You couldn't guess in six tries you loss.");
            checkPlayAgain(new Scanner(System.in));
        }
    }
}
