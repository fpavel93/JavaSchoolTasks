package my_spring.iRobot;

import lombok.SneakyThrows;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        //ApplicationContext context = new ApplicationContext(new javaConfig("my_spring"));
        //context.getBean(IRobot.class).cleanRoom();
        //IRobot iRobot = ObjectFactory.getInstance().createObject(IRobot.class);
        //iRobot.cleanRoom();
        WorkerImpl worker = ObjectFactory.getInstance().createObject(WorkerImpl.class);
        while (true) {
            worker.drinkBeer();
            worker.work();
            Thread.sleep(1000);
        }
    }
}
