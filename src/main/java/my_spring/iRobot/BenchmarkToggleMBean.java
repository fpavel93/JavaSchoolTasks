package my_spring.iRobot;

public interface BenchmarkToggleMBean {

    boolean isEnabled();

    void setEnabled(boolean enabled);

    default void shutDown(int code) {
        System.out.println("code = "+code);
        System.exit(code);
    }
}
