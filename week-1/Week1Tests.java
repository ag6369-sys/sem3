import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/** Dependency-free regression checks. Run with: java Week1Tests */
public class Week1Tests {
    private static int passed = 0;

    private static void expect(String expected, Runnable action) {
        PrintStream original = System.out;
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        PrintStream capture = new PrintStream(bytes);
        try {
            System.setOut(capture);
            action.run();
        } finally {
            System.setOut(original);
            capture.close();
        }
        String actual = bytes.toString().replace("\r\n", "\n").trim();
        if (!actual.equals(expected)) {
            throw new AssertionError("Expected: " + expected + "\nActual: " + actual);
        }
        passed++;
    }

    private static void rejects(Runnable action) {
        try {
            action.run();
        } catch (IllegalArgumentException expected) {
            passed++;
            return;
        }
        throw new AssertionError("Expected IllegalArgumentException");
    }

    public static void main(String[] args) {
        expect("Duplicate Seat Number Found: 102", () ->
                ExamHallSeatDuplicationChecker.checkDuplicateSeats(new int[]{101, 102, 103, 102, 105}));
        expect("No Duplicate Seats Found", () ->
                ExamHallSeatDuplicationChecker.checkDuplicateSeats(new int[]{101, 102, 103, 104, 105}));
        expect("Duplicate Seat Number Found: 2\nDuplicate Seat Number Found: 1", () ->
                ExamHallSeatDuplicationChecker.checkDuplicateSeats(new int[]{2, 1, 2, 2, 1}));
        expect("No Duplicate Seats Found", () ->
                ExamHallSeatDuplicationChecker.checkDuplicateSeats(new int[]{}));
        expect("Matched: 10/11 | Accuracy: 90.91% | First Mismatch at position 11 ('d' vs 't')", () ->
                TypingSpeedAccuracyChecker.checkTypingAccuracy("hello world", "hello worlt"));
        expect("Matched: 6/6 | Accuracy: 100.00% | No Mismatches", () ->
                TypingSpeedAccuracyChecker.checkTypingAccuracy("coding", "coding"));
        expect("Matched: 0/0 | Accuracy: 100.00% | No Mismatches", () ->
                TypingSpeedAccuracyChecker.checkTypingAccuracy("", ""));
        expect("Matched: 0/3 | Accuracy: 0.00% | First Mismatch at position 1 ('a' vs 'x')", () ->
                TypingSpeedAccuracyChecker.checkTypingAccuracy("abc", "xyz"));
        rejects(() -> TypingSpeedAccuracyChecker.checkTypingAccuracy("a", "ab"));
        expect("Longest Streak: 'G' repeated 3 times", () ->
                TrafficSignalStreakAnalyzer.findLongestStreak("RRGGGYRR"));
        expect("Longest Streak: 'R' repeated 4 times", () ->
                TrafficSignalStreakAnalyzer.findLongestStreak("RRRRYYGG"));
        expect("Longest Streak: 'R' repeated 2 times", () ->
                TrafficSignalStreakAnalyzer.findLongestStreak("RRGG"));
        expect("Longest Streak: 'G' repeated 3 times", () ->
                TrafficSignalStreakAnalyzer.findLongestStreak("RYGGG"));
        expect("Longest Streak: 'Y' repeated 1 times", () ->
                TrafficSignalStreakAnalyzer.findLongestStreak("Y"));
        expect("No Signal Readings Found", () -> TrafficSignalStreakAnalyzer.findLongestStreak(""));
        rejects(() -> TrafficSignalStreakAnalyzer.findLongestStreak("RX"));
        expect("Section A Total: 65 | Section B Total: 65 | Status: Balanced | Highest Quantity: 30 (Section A, Item 3)", () ->
                WarehouseInventoryBalancer.analyzeInventory(new int[]{20, 15, 30}, new int[]{25, 10, 30}));
        expect("Section A Total: 10 | Section B Total: 11 | Status: Not Balanced | Highest Quantity: 10 (Section A, Item 2)", () ->
                WarehouseInventoryBalancer.analyzeInventory(new int[]{0, 10}, new int[]{10, 1}));
        expect("Section A Total: 3 | Section B Total: 18 | Status: Not Balanced | Highest Quantity: 9 (Section B, Item 1)", () ->
                WarehouseInventoryBalancer.analyzeInventory(new int[]{1, 2}, new int[]{9, 9}));
        expect("Section A Total: 0 | Section B Total: 0 | Status: Balanced | No Inventory Items Found", () ->
                WarehouseInventoryBalancer.analyzeInventory(new int[]{}, new int[]{}));
        expect("Section A Total: 4294967294 | Section B Total: 0 | Status: Not Balanced | Highest Quantity: 2147483647 (Section A, Item 1)", () ->
                WarehouseInventoryBalancer.analyzeInventory(new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE}, new int[]{0, 0}));
        expect("Section A Total: -2147483648 | Section B Total: -2147483648 | Status: Balanced | Highest Quantity: -2147483648 (Section A, Item 1)", () ->
                WarehouseInventoryBalancer.analyzeInventory(new int[]{Integer.MIN_VALUE}, new int[]{Integer.MIN_VALUE}));
        rejects(() -> WarehouseInventoryBalancer.analyzeInventory(new int[]{1}, new int[]{}));
        expect("Short: 3 | Medium: 1 | Long: 3", () ->
                MovieReviewWordLengthProfiler.classifyWordLengths("This movie was absolutely fantastic and thrilling"));
        expect("Short: 2 | Medium: 2 | Long: 1", () ->
                MovieReviewWordLengthProfiler.classifyWordLengths("a abcd abcde abcdefgh abcdefghi"));
        expect("Short: 0 | Medium: 0 | Long: 0", () -> MovieReviewWordLengthProfiler.classifyWordLengths(""));
        expect("Short: 1 | Medium: 1 | Long: 0", () ->
                MovieReviewWordLengthProfiler.classifyWordLengths("  Good!\t movie...  !!!  "));
        System.out.println("All " + passed + " checks passed.");
    }
}
