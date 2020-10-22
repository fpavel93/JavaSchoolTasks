package design_patterns.heroesGame;

import lombok.SneakyThrows;

public class GameManager {
    @SneakyThrows
    public void fight(Character c1, Character c2){
        Character attacking = c1;
        Character attacked = c2;

        if(c1.getType().equals("Hobbit") && c2.getType().equals("Hobbit"))
        {
            System.out.println("Hobbits cannot fight each other");
        }
        else {
            while (c1.isAlive() && c2.isAlive()) {
                attacking.kick(attacked);
                System.out.println(attacking.getType() + " kicked " + attacked.getType());
                Character tmp = attacking;
                attacking = attacked;
                attacked = tmp;
                Thread.sleep(1000);
            }


            if (!c1.isAlive()) {
                System.out.println(c1.getType() + " is dead");
            }
            else {
                System.out.println(c2.getType() + " is dead");
            }
        }
    }
}
