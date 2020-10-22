package design_patterns.radioAlarm;

import lombok.experimental.Delegate;

public class RadioAlarm implements Radio,Alarm {

    @Delegate
    RadioImpl radio = new RadioImpl();
    @Delegate(excludes = AlarmExclusions.class)
    AlarmImpl alarm = new AlarmImpl();

    @Override
    public void c() {
        System.out.println("do first alarm function in other way");
    }
}
