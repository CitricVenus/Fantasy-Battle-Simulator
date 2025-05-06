public abstract class Character {
    protected String name;
    protected int health;
    protected int attack;
    protected int defense;
    protected boolean isAlive;

    public Character(String name, int health, int attack, int defense,boolean isAlive) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.isAlive = true;
    }

    public abstract void attack (Character enemy) throws EnemyDefeated;

    public abstract void showHabilities();

    public abstract void showStats();


    public void receiveDamage(int damage){
        this.health -= damage;
        if (this.health < 0){
            this.health = 0;
        }
    }

    public boolean isAlive(){
        if (this.health >0){
            return true;
        }else {
            return false;
        }
    }

    public String getName(){
        return this.name;
    }

    public int getHealth(){
        return this.health;
    }

    public void setDefense(int defense){
        if (defense <= 0){
            this.defense = 0;
        }else{
            this.defense = defense;
        }
    }

    public void setHealt(int health){
        if (this.health <= 0){
            this.health = 0;
        }
        else {
            this.health = health;
        }
    }

    public int getDefense(){
        return this.defense;
    }

    public abstract int getAbilitiesSize();

    public abstract void getAbilitie(Character enemy,int index);


}
