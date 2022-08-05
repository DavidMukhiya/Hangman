package Hangman;

public class Hangman {
    public void startGame(){
        System.out.println("+----+");
        System.out.println("");
        System.out.println("     |");
        System.out.println("");
        System.out.println("     |");
        System.out.println("");
        System.out.println("     |");
        System.out.println("");
        System.out.println("    ====");
    }

    public static void main(String[] args) {
        Hangman hangman = new Hangman();
        hangman.startGame();
    }

}
