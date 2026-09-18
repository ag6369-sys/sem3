package strings.assigment_problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StopWordFilteredFrequencyReport {
    public static void printFilteredWordFrequency(String feedback) {
        String[] stopWords = {"the","was","and","a","is","of","in"};
        String cleaned = feedback.toLowerCase().replace(".", "").replace(",", "");
        String[] words = cleaned.trim().split("\\s+");
        Map<String,Integer> frequency = new HashMap<>();
        for (String word : words) {
            if (word.isEmpty() || isStopWord(word, stopWords)) continue;
            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }
        List<Map.Entry<String,Integer>> entries = new ArrayList<>(frequency.entrySet());
        entries.sort((a,b) -> {
            int byCount = Integer.compare(b.getValue(), a.getValue());
            return byCount != 0 ? byCount : a.getKey().compareTo(b.getKey());
        });
        for (Map.Entry<String,Integer> entry : entries) System.out.println(entry.getKey() + ": " + entry.getValue());
    }

    private static boolean isStopWord(String word, String[] stopWords) {
        for (String stopWord : stopWords) if (word.equals(stopWord)) return true;
        return false;
    }

    public static void main(String[] args) {
        printFilteredWordFrequency("The mentor was great, the session was great and clear.");
    }
}
