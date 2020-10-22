package design_patterns.heroesGame;

@CharacterId(1)
public class Hobbit extends Character {

    public Hobbit() {
        setPower(0);
        setHp(3);
        setType("Hobbit");
    }

    public void kick(Character c) {
        toCry();
    }

    private void toCry() {
        System.out.println("Crying");
    }
}
