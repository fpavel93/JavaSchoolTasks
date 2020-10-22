package design_patterns.heroesGame;

import lombok.SneakyThrows;

public class GameManager {
    @SneakyThrows
    public void fight(Character c1, Character c2){
        Character attacking = c1;
        Character attacked = c2;

        if(c1.getClass().getSimpleName().equals("Hobbit") && c2.getClass().getSimpleName().equals("Hobbit"))
        {
            System.out.println("Hobbits cannot fight each other");
        }
        else {
            while (c1.isAlive() && c2.isAlive()) {
                attacking.kick(attacked);
                System.out.println(attacking.getClass().getSimpleName() + " kicked " + attacked.getClass().getSimpleName());
                Character tmp = attacking;
                attacking = attacked;
                attacked = tmp;
                Thread.sleep(1000);
            }


            if (!c1.isAlive()) {
                printDead(c1);
            }
            else {
                printDead(c2);
            }
        }
    }

    private void printDead(Character c1) {
        System.out.println(c1.getClass().getSimpleName() + " is dead");
    }
}
