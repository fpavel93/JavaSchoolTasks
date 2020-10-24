package my_spring.iRobot;

public class IRobot {

    @InjectByType
    private Speaker speaker;
    @InjectByType
    private Cleaner cleaner;

    public void init(){
        System.out.println(speaker.getClass().getName());
    }

    public void cleanRoom(){
        speaker.speak("Start clean");
        cleaner.clean();
        speaker.speak("Finish clean");
    }
}
