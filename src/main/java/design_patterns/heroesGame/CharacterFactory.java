package design_patterns.heroesGame;

import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

public class CharacterFactory {
    Random random = new Random();

    private Map<Integer, Class<? extends Character>> map = new HashMap<>();

    CharacterFactory(){
        Reflections scanner = new Reflections("design_patterns.heroesGame");
        Set<Class<? extends Character>> set = scanner.getSubTypesOf(Character.class);

        map = set.stream()
                .filter(aClass -> !Modifier.isAbstract(aClass.getModifiers()))
                .filter(aClass -> aClass.isAnnotationPresent(CharacterId.class))
                .collect(toMap(CharacterFactory::getCharacterId, Function.identity()));
    }

    private static int getCharacterId(Class<? extends Character> c){
        return c.getAnnotation(CharacterId.class).value();
    }

    @SneakyThrows
    public Character createCharacter(){
        return map.get(random.nextInt(4) + 1).getDeclaredConstructor().newInstance();
    }
}
