package hexlet.code;

import java.util.List;
import java.util.Map;

public class App {
    public String getGreeting() {
        return "Hey, you!";
    }

    public static void main(String[] args) {
        Map<String, List<String>> index = Map.of(
                "some", List.of("doc1", "doc2"),
                "text", List.of("doc1", "doc4")
        );
        System.out.print(index);
    }
}
