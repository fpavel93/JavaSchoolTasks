package my_spring.iRobot;

public class Main {
    public static void main(String[] args) {
        ObjectFactory.getInstance().createObject(IRobot.class).cleanRoom();
    }
}
