package design_patterns.radioAlarm;

public class RadioAlarm implements Radio,Alarm {
    @Override
    public void a() {
        System.out.println("do first radio function");
    }

    @Override
    public void b() {
        System.out.println("do second radio function");
    }

    @Override
    public void c() {
        System.out.println("do first alarm function");
    }

    @Override
    public void d() {
        System.out.println("do second alarm function");
    }
}
