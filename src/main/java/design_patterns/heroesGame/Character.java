package design_patterns.heroesGame;

import lombok.Data;


@Data
public abstract class Character {

    private int power;
    private int hp;

    Character(){
        hp = getInitialHp();
        power = getInitialPower();
    }

    protected abstract int getInitialHp();
    protected abstract int getInitialPower();

    public abstract void kick(Character c);

    public boolean isAlive() {
        return hp > 0;
    }

    protected void die(){
        hp = 0;
    }

    protected void decreasePower(int delta){
        power-=delta;
    }

    public void decreaseHp(int damage){
        hp-=damage;
    }
}
