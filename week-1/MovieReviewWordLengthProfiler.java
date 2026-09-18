import java.util.Scanner;

public class MovieReviewWordLengthProfiler {
    public static void classifyWordLengths(String review) {
        int shortWords = 0;
        int mediumWords = 0;
        int longWords = 0;
        String[] words = review.trim().split("\\s+");
        for (String word : words) {
            int letters = 0;
            for (int i = 0; i < word.length(); i++) {
                if (Character.isLetter(word.charAt(i))) letters++;
            }
            if (letters == 0) continue;
            if (letters <= 4) shortWords++;
            else if (letters <= 8) mediumWords++;
            else longWords++;
        }
        System.out.println("Short: " + shortWords + " | Medium: " + mediumWords + " | Long: " + longWords);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        classifyWordLengths(input.nextLine());
    }
}
