package Hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("C:/Users/sherl/IdeaProjects/Assigments/src/Hangman/words_list.txt"));
        Scanner keyboard = new Scanner(System.in);

        List<String> words = new ArrayList<>();
        while (scanner.hasNext()) {
            //System.out.println(scanner.nextLine());
            words.add(scanner.nextLine());
        }

        Random random = new Random();
        String word = words.get(random.nextInt(words.size()));
        System.out.println(word);

        List<Character> playerGuesses = new ArrayList<>();


        printWordState(word, playerGuesses);

        while(true){
            getPlayerGuess(keyboard, word, playerGuesses);
            if(printWordState(word, playerGuesses)){
                break;
            }
        }
        System.out.println("You win!");
    }

    private static void getPlayerGuess(Scanner keyboard, String word, List<Character> playerGuesses) {
        System.out.println("Enter the Character:");
        playerGuesses.add(keyboard.next().charAt(0));

    }

    private static boolean printWordState(String word, List<Character> playerGuesses) {
        int correctCount = 0;
        for(int i = 0; i< word.length(); i++){
            if(playerGuesses.contains(word.charAt(i))){
                System.out.print(word.charAt(i));
                correctCount++;
            }else{
                System.out.print("-");
            }
        }
        System.out.println();
        return (word.length()==correctCount);
    }
}
