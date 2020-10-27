package my_spring.iRobot;

@Benchmark
public class CleanerImpl implements Cleaner {
    @InjectRandomInt(min=3,max=7)
    private int repeat;

    @Override
    public void clean() {
        for (int i = 0; i < repeat; i++) {
            System.out.println("cleaning...");
        }
    }
}
