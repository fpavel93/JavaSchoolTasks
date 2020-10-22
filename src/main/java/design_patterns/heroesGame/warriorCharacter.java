package design_patterns.heroesGame;

import java.util.Random;

public abstract class warriorCharacter extends Character {

    Random random;
    private final int min;
    private final int max;

    warriorCharacter(int min, int max, String type){
        random = new Random();
        this.min = min;
        this.max = max;
        setType(type);
        setPower(random.nextInt(max-min) + min);
        setHp(random.nextInt(max-min) + min);
    }

    @Override
    public void kick(Character c) {
        int damage = random.nextInt(max-min) + min;
        int newHp = c.getHp() - damage;
        if(newHp < 0){
            newHp = 0;
        }
        c.setHp(newHp);
    }
}
