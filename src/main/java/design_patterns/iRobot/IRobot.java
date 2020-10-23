package design_patterns.iRobot;

public class IRobot {
    private Speaker speaker = ObjectFactory.getInstance().createObject(Speaker.class);
    private Cleaner cleaner = ObjectFactory.getInstance().createObject(Cleaner.class);

    public void cleanRoom(){
        speaker.speak("Start clean");
        cleaner.clean();
        speaker.speak("Finish clean");
    }
}
