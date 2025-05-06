import java.util.Scanner;

public class Battle {
    public void startBattle (Character p1 , Character p2 , Scanner scanner) throws InvalidAction {
        System.out.println("====================================Battle====================================");

        while(p1.isAlive() && p2.isAlive()){
            int turn = randomTurn();
            System.out.println("Player 1 Character status");
            p1.showStats();
            System.out.println("Player 2 Character status");
            p2.showStats();

            if (turn == 1){
                p1Turn(p1,p2,scanner);
            }else {
                p2Turn(p2,p1,scanner);
            }
        }

        if (p1.isAlive()){
            System.out.println(p1.getName() + " Wins");
        }else{
            System.out.println(p2.getName() + " Wins");
        }
    }

    private void p1Turn(Character p1,Character p2, Scanner scanner){
        int abilitieSelected;
        System.out.println("=======================P1 TURN========================");

        System.out.println("What do yo want to do?");
        p1ShowAbilities(p1);
        abilitieSelected = scanner.nextInt();
        scanner.nextLine();
        if (abilitieSelected > p1.getAbilitiesSize() || abilitieSelected < 0){
            System.out.println("Select a valid option");
        }else{
            p1.getAbilitie(p2,abilitieSelected);
        }
    }

    private void p2Turn(Character p2 ,Character p1, Scanner scanner){
        int abilitieSelected;
        System.out.println("=======================P2 TURN========================");
        System.out.println("Your Character status");
        p2.showStats();
        System.out.println("What do yo want to do?");
        p1ShowAbilities(p2);
        abilitieSelected = scanner.nextInt();
        scanner.nextLine();
        if (abilitieSelected > p2.getAbilitiesSize() || abilitieSelected < 0){
            System.out.println("Select a valid option");
        }else{
            p2.getAbilitie(p1,abilitieSelected);
        }
    }

    private void checkStatus(Character player){
        player.showStats();
    }

    private void p1ShowAbilities(Character p1){
        p1.showHabilities();
    }

    private void p2ShowAbilities(Character p2){
        p2.showHabilities();
    }

    private int randomTurn(){
        int rand = (int) (Math.random() * 2) + 1;
        return rand;
    }
}
