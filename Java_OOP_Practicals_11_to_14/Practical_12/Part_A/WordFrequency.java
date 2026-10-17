import java.util.*;

public class WordFrequency {
    public static void main(String[] args) {
        String paragraph = "Java is simple and Java is useful. Java helps students learn programming.";
        Map<String, Integer> count = new HashMap<>();
        for (String word : paragraph.toLowerCase().replaceAll("[^a-z ]", "").split("\\s+")) {
            if (!word.isEmpty()) count.put(word, count.getOrDefault(word, 0) + 1);
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(count.entrySet());
        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        for (Map.Entry<String, Integer> entry : list)
            System.out.println(entry.getKey() + " : " + entry.getValue());
    }
}
