public class Archer extends Character {
    String [] abilities = {"Attack","Rain of Arrows","Increase Damage"};
    public Archer(String name) {
        super(name, 100, 40, 20,true);
    }

    @Override
    public void attack(Character enemy) throws EnemyDefeated {
        if (!enemy.isAlive()){
            throw new EnemyDefeated("The enemy has died");
        }
        else if (enemy.getDefense() > 0){
            int aux = enemy.getDefense();
            enemy.setDefense(aux =- attack);
            System.out.println("Archer has damaged: "+ attack);
        }
        else if (enemy.getDefense() == 0 && enemy.getHealth() > 0){
            int auxHealth = enemy.getHealth();
            enemy.setHealt(auxHealth -= this.attack);
            System.out.println("Archer has damaged: "+ attack);
        }
    }

    public void rainOfArrows(Character enemy) throws EnemyDefeated{
        if (!enemy.isAlive){
            throw new EnemyDefeated("The enemy has died");
        }
        else if (enemy.defense > 0){
            int aux = enemy.getDefense();
            enemy.setDefense(aux -= 30);
            System.out.println("Archer has damaged: "+ attack);
        }
        else if (enemy.defense == 0 && enemy.health > 0){
            int auxHealth = enemy.getHealth();
            enemy.setHealt(auxHealth -= 30);
            System.out.println("Archer has damaged: "+ attack);
        }
        System.out.println("Archer used Rain of Arrows");
    }

    public void increaseDamage(){
        int max = 60;
        int min = 30;
        int range = max - min + 1;
        int rand = (int)(Math.random() * range) + min;
        this.attack += rand;
        System.out.println("Archer has increased their attack by" + rand);
        System.out.println("Archer attack is: " + attack);

    }

    @Override
    public void showHabilities() {
        System.out.println("====================================="+this.name+" Abilities============================================");
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
        return this.abilities.length;
    }

    @Override
    public void getAbilitie(Character enemy,  int index) {
        switch (index){
            case 1:
                try{
                    attack(enemy);
                }catch (EnemyDefeated e){
                    System.out.println(e.getMessage());
                }
                break;
            case 2:
                try{
                    rainOfArrows(enemy);
                }catch (EnemyDefeated e){
                    System.out.println(e.getMessage());
                }
                break;
            case 3:
                increaseDamage();
                break;

        }
    }


}
