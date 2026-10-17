import java.util.*;

public class Leaderboard {
    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Riya", 90);
        scores.put("Aman", 85);
        scores.put("Dev", 90);
        scores.put("Neha", 78);
        List<Map.Entry<String, Integer>> players = new ArrayList<>(scores.entrySet());
        players.sort((a, b) -> {
            int result = b.getValue().compareTo(a.getValue());
            return result != 0 ? result : a.getKey().compareTo(b.getKey());
        });
        for (int i = 0; i < Math.min(3, players.size()); i++)
            System.out.println(players.get(i).getKey() + " : " + players.get(i).getValue());
    }
}
