package my_spring.iRobot;

public class WorkerImpl implements Worker {
    @Override
    public void work() {
        System.out.println("Working");
    }

    @Override
    @Benchmark
    public void drinkBeer() {
        System.out.println("Leff is good");
    }
}
