import java.util.Scanner;

public class TrafficSignalStreakAnalyzer {
    public static void findLongestStreak(String signalLog) {
        if (signalLog.isEmpty()) {
            System.out.println("No Signal Readings Found");
            return;
        }
        int currentLength = 0;
        int longestLength = 0;
        char previous = '\0';
        char longestColor = '\0';
        for (int i = 0; i < signalLog.length(); i++) {
            char color = signalLog.charAt(i);
            if (color != 'R' && color != 'Y' && color != 'G') {
                throw new IllegalArgumentException("Signal readings must be R, Y, or G.");
            }
            currentLength = color == previous ? currentLength + 1 : 1;
            // A strict comparison preserves the earliest streak on ties.
            if (currentLength > longestLength) {
                longestLength = currentLength;
                longestColor = color;
            }
            previous = color;
        }
        System.out.println("Longest Streak: '" + longestColor + "' repeated " + longestLength + " times");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        findLongestStreak(input.nextLine());
    }
}
