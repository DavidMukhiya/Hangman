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
        List<String> words = new ArrayList<>();
        while(scanner.hasNext()){
            //System.out.println(scanner.nextLine());
            words.add(scanner.nextLine());
        }

        Random random = new Random();
        String word = words.get(random.nextInt(words.size()+1));
        System.out.println(word);
    }
}
