package design_patterns.heroesGame;

import lombok.Setter;

public class King extends Character {
    @Setter
    private Weapon weapon = new Sword();

    @Override
    protected int getInitialHp() {
        return RandomUtil.getRandomInRange(5,15);
    }

    @Override
    protected int getInitialPower() {
        return RandomUtil.getRandomInRange(5,15);
    }

    @Override
    public void kick(Character c) {
        weapon.kick(this,c);
    }
}
