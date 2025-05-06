import java.util.Scanner;

public class MainGame {
    public static String [] characters = {"Warrior","Archer","Mage"};
    public static void showCharacters(){
        for (int i = 0; i < characters.length; i++) {
            System.out.println(i+1+") "+ characters[i]);
        }
    }

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int p1CharacterSelected;
        int p2CharacterSelected;
        Character p1 = null;
        Character p2 = null;
        System.out.println("Player 1 Select your character");
        Battle battle;

        showCharacters();
        p1CharacterSelected = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Player 2 Select your character");
        showCharacters();
        p2CharacterSelected = scanner.nextInt();
        scanner.nextLine();

        if (p1CharacterSelected < 0 || p1CharacterSelected > characters.length || p2CharacterSelected < 0 || p2CharacterSelected > characters.length ){
            System.out.println("Select a valid character");

        }else{


            switch (p1CharacterSelected){
                case 1:
                    p1 = new Warrior("P1 Warrior");
                    break;
                case 2:
                    p1 = new Archer("P1 Archer");
                    break;
                case 3:
                    p1 = new Mage("P1 Mage");
                    break;
            }

            switch (p2CharacterSelected){
                case 1:
                    p2 = new Warrior("P2 Warrior");
                    break;
                case 2:
                    p2 = new Archer("P2 Archer");
                    break;
                case 3:
                    p2 = new Mage("P2 Mage");
                    break;
            }

            battle = new Battle();
            try {
                battle.startBattle(p1,p2,scanner);
            }catch (InvalidAction e){
                e.getMessage();
            }
        }
    }
}
