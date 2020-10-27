package my_spring.iRobot;

public class Main {
    public static void main(String[] args) {
        //ApplicationContext context = new ApplicationContext(new javaConfig("my_spring"));
        //context.getBean(IRobot.class).cleanRoom();
        //IRobot iRobot = ObjectFactory.getInstance().createObject(IRobot.class);
        //iRobot.cleanRoom();
        Worker worker = ObjectFactory.getInstance().createObject(Worker.class);
        worker.drinkBeer();
        worker.work();
    }
}
