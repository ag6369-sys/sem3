package programming_fundamentals.class_problems;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {
    public static char findFirstNonRepeatingChar(String text) {
        Map<Character, Integer> frequency = new HashMap<>();
        for (char ch : text.toCharArray()) frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        for (char ch : text.toCharArray()) if (frequency.get(ch) == 1) return ch;
        return '\0';
    }

    public static void main(String[] args) {
        char result = findFirstNonRepeatingChar("swiss");
        System.out.println(result == '\0' ? "No Non-Repeating Character Found"
                : "First Non-Repeating Character: '" + result + "'");
    }
}
