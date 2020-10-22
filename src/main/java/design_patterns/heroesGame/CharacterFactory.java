package design_patterns.heroesGame;

import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.lang.reflect.Modifier;
import java.util.*;

import static java.util.stream.Collectors.toList;

public class CharacterFactory {
    Random random = new Random();

    private List<Class<? extends Character>> heroClasses;

    CharacterFactory(){
        Reflections scanner = new Reflections("design_patterns.heroesGame");
        Set<Class<? extends Character>> set = scanner.getSubTypesOf(Character.class);

        heroClasses = set.stream()
                .filter(aClass -> !Modifier.isAbstract(aClass.getModifiers()))
                .collect(toList());
    }

    @SneakyThrows
    public Character createRandomCharacter(){
        int i = RandomUtil.getRandomInRange(0, heroClasses.size());
        return heroClasses.get(i).getDeclaredConstructor().newInstance();
    }
}
