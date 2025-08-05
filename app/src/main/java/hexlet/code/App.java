package hexlet.code;

public class App {
    public String getGreeting() {
        return "Hey, you!";
    }

    public static void main(String[] args) {
        System.out.println(new hexlet.code.App().getGreeting());
    }
}
