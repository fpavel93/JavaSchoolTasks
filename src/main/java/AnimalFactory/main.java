package AnimalFactory;

public class main {
    public static void main(String[] args) {
        AnimalFactory f = new AnimalFactory();
        for (int i = 0; i < 10; i++) {
            f.createRandomAnimal().makeVoice();
        }
    }
}
