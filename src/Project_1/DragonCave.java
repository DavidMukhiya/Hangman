package Project_1;

import java.util.Scanner;

public class DragonCave {
    //cave Method with take caveNum Input from user.
    public void cave(int caveNum) {
        switch (caveNum) {
            //for cave 1
            case 1:
                System.out.println("\nyou Approach the cave..\n" +
                        "It is dark and spooky..\n" +
                        "A large dragon jumps out in front of you!\n" +
                        "He opens his jaws and...\n" +
                        "Gobbles you down in one bite!");
                break;

            //for cave 2
            case 2:
                System.out.println("\nyou Approach the cave..\n" +
                        "It is warm and happy..\n" +
                        "the dragon is friendly..\n" +
                        "will share his treasure with you");
                break;
        }
    }
    public static void main(String[] args) {

        //Intro
        System.out.println("\nYou are in a Land full of Dragon.\n" +
                "In front you, you see two cave.\n" +
                "In one cave, the dragon is greedy\n" +
                "and hungry and will eat you on sight.\n" +
                "and In another cave it is dark and spooky.\n");

        System.out.println("Which cave will you go into?\n" +
                "Enter No '1' for Cave One\n" +
                "Enter No '2' for Cave Two\n");
        System.out.print("Enter the No: ");

        //Taking Input from user
        Scanner sc = new Scanner(System.in);
        int caveNum = 0;
        boolean status = true;

        while(status){
            try {
                if (sc.hasNextInt()) {
                    caveNum = sc.nextInt();
                    status = false;
                } else {
                    throw new DragonCaveCustomException("\n**Please Enter the Integer Only.**\n");
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
                System.out.print("Enter the No Please: ");
                //main(null);
                sc = new Scanner(System.in);
            }

        }
        System.out.print("You Enter the No: " + caveNum + "\n");

        //checking the number for cave
        if (caveNum == 1 || caveNum == 2) {
            //creating the DragonCave object and calling cave method.
            DragonCave dragonCave = new DragonCave();
            dragonCave.cave(caveNum);
        } else {
            //if user input anything other than 1 or 2.
            System.out.print("\nPlease Enter No 1 or 2: ");
            caveNum = sc.nextInt();
            System.out.print("You Enter the No: " + caveNum);
            //creating the DragonCave object and calling cave method.
            DragonCave dragonCave = new DragonCave();
            dragonCave.cave(caveNum);
        }
    }
}
