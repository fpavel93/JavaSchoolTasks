package design_patterns.heroesGame;

public class Elf extends Character {

    @Override
    protected int getInitialHp() {
        return 10;
    }

    @Override
    protected int getInitialPower() {
        return 10;
    }

    @Override
    public void kick(Character c) {
        if(c.getPower() < getPower()){
            c.die();
        }
        else {
            c.decreasePower(1);
        }
    }
}
