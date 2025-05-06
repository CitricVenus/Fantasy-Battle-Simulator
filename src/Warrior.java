public class Warrior extends Character{
    String [] abilities = {"Attack","Increaase deffense","Increase attack"};
    public Warrior(String name) {
        super(name, 100, 10, 30,true);
    }

    @Override
    public void attack(Character enemy) throws EnemyDefeated {
        if (!enemy.isAlive()){
            throw new EnemyDefeated("The enemy has died");
        }
        else if (enemy.getDefense() > 0){
            System.out.println("Warrior has damaged:" + attack);
            enemy.setDefense(enemy.defense =- attack);
        }
        else if (enemy.getDefense() == 0 && enemy.getHealth() > 0){
            enemy.setHealt(enemy.health -= this.attack);
            System.out.println("Warrior has damaged:" + attack);
        }
    }

    @Override
    public void showHabilities() {
        System.out.println("====================================="+this.name+" Habilities============================================");
        int i = 1 ;
        for (String items : abilities){
            System.out.println(i+") "+items);
            i++;
        }
    }

    @Override
    public void showStats() {
        System.out.println("Health: "+this.health+"\n"+"Defense: "+this.defense+"\n"+"Attack: "+this.attack+"\n");
    }

    @Override
    public int getAbilitiesSize() {
        return abilities.length;
    }

    public void increaseDefense(){
        int max = 30;
        int min = 10;
        int range = max - min + 1;
        this.defense += range;
        System.out.println("Warrior has increased their defense by: " + range);
        System.out.println("The new defense is: " + this.defense);
    }

    public void increaseAttack(){
        int max = 10;
        int min = 5;
        int range = max - min + 1;
        this.attack += range;
        System.out.println("Warrior has increased their Attack by: " + range);
        System.out.println("The new attack is: " +this.attack);;
    }

    @Override
    public void getAbilitie(Character enemy, int index) {

        switch (index){
            case 1:
                try{
                    attack(enemy);
                }catch (EnemyDefeated e){
                    System.out.println(e.getMessage());
                }
                break;

            case 2:
                increaseDefense();
                break;

            case 3:
                increaseAttack();
                break;
        }

    }







}
