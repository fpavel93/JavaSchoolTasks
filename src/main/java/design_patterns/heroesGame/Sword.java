package design_patterns.heroesGame;

public class Sword implements Weapon {
    @Override
    public void kick(Character attacker, Character defender) {
        int damage = RandomUtil.getRandomInRange(0, attacker.getPower());
        defender.decreaseHp(damage);
    }
}
