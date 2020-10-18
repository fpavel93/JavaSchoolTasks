package AnimalFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

import static java.util.Arrays.asList;

public class AnimalFactory {

    private List<Supplier<Animal>> suppliers = asList(Dog::new, Cat::new);

    private Random random = new Random();

    public Animal createRandomAnimal(){
        int i = random.nextInt(suppliers.size());
        return suppliers.get(i).get();
    }
}
