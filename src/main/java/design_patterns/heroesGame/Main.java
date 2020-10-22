package design_patterns.heroesGame;

import lombok.SneakyThrows;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        CharacterFactory characterFactory = new CharacterFactory();

        for (int i = 0; i < 10; i++) {
            Character c1 = characterFactory.createRandomCharacter();
            Character c2 = characterFactory.createRandomCharacter();

            gameManager.fight(c1,c2);

            if (!c1.isAlive()) {
                c1 = c2;
            }
            c2 = characterFactory.createRandomCharacter();

            Thread.sleep(1000);
        }
    }
}
