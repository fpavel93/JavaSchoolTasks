package design_patterns.heroesGame;

public class Hobbit extends Character {

    @Override
    protected int getInitialHp() {
        return 3;
    }

    @Override
    protected int getInitialPower() {
        return 0;
    }

    @Override
    public void kick(Character c) {
        toCry();
    }

    private void toCry() {
        System.out.println("Crying");
    }
}
