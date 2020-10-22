package design_patterns.heroesGame;

@CharacterId(2)
public class Elf extends Character {

    public Elf() {
        setPower(10);
        setHp(10);
        setType("Elf");
    }

    @Override
    public void kick(Character c) {
        if(c.getPower() < getPower()){
            c.setHp(0);
        }
        else {
            c.setHp(c.getHp()-1);
        }
    }
}
