package design_patterns.iRobot;

import jdk.internal.ref.Cleaner;
import lombok.AllArgsConstructor;

import java.rmi.dgc.DGC;

public class IRobot {
    private Speaker speaker = new ConsoleSpeaker();
    private Cleaner cleaner = new CleanerImpl();

    public void cleanRoom(){


        speaker.speak("Start clean");
        cleaner.clean();
        speaker.speak("Finish clean");
    }
}
