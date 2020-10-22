package design_patterns.heroesGame;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
public abstract class Character {

    @Setter(AccessLevel.PROTECTED)
    private int power;
    @Setter
    private int hp;
    @Setter
    private String type;

    public abstract void kick(Character c);

    public boolean isAlive() {
        return hp!=0;
    }
}
