public class Mage extends Character{
    String [] abilities = {"Attack", "Fire Ball" , "Heal"};
    public Mage(String name) {
        super(name, 100, 50, 10,true);
    }

    @Override
    public void attack(Character enemy) throws EnemyDefeated {
        if (!enemy.isAlive()){
            throw new EnemyDefeated("The enemy has died");
        }
        else if (enemy.getDefense() > 0){
            int aux = enemy.getDefense();
            enemy.setDefense(aux =- attack);
            System.out.println("Mage has damaged: "+ attack);
        }
        else if (enemy.getDefense() == 0 && enemy.getHealth() > 0){
            int auxHealth = enemy.getHealth();
            enemy.setHealt(auxHealth -= this.attack);
            System.out.println("Mage has damaged: "+ attack);
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

    public void fireBallAttack(Character enemy) throws EnemyDefeated{
        if (!enemy.isAlive){
            throw new EnemyDefeated("The enemy has died");
        }
        else if (enemy.defense > 0){
            int aux = enemy.getDefense();
            enemy.setDefense(aux -= 30);
            System.out.println("Mage has damaged: "+ attack);
        }
        else if (enemy.defense == 0 && enemy.health > 0){
            int auxHealth = enemy.getHealth();
            enemy.setHealt(auxHealth -= 30);
            System.out.println("Mage has damaged: "+ attack);
        }
    }

    public void heal(){
        int max = 60;
        int min = 20;
        int range = max - min + 1;
        int rand = (int)(Math.random() * range) + min;
        this.health+=rand;
        System.out.println("Mage has used healing");
        System.out.println("Mage has increased their life by :" + rand);
    }


    @Override
    public void getAbilitie(Character enemy, int index) {
        switch (index){
            case 1:
                try {
                    attack(enemy);
                }catch (EnemyDefeated e){
                    System.out.println(e.getMessage());
                }
                break;
            case 2:
                try {
                    fireBallAttack(enemy);
                }catch (EnemyDefeated e){
                    System.out.println(e.getMessage());
                }
                break;
            case 3:
                heal();
                break;

        }
    }



}
