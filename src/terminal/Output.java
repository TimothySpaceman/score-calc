package terminal;

public class Output {
    public void log(String message) {
        System.out.print(message);
    }

    public void logln(String message) {
        System.out.println(message);
    }

    public void logf(String format, Object... args) {
        System.out.printf(format, args);
    }
}
