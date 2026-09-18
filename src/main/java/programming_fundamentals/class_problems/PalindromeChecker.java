package programming_fundamentals.class_problems;

public class PalindromeChecker {
    public static boolean isPalindromeIterative(String text) {
        int left = 0, right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        return isPalindromeRecursive(text, 0, text.length() - 1);
    }

    private static boolean isPalindromeRecursive(String text, int left, int right) {
        if (left >= right) return true;
        if (text.charAt(left) != text.charAt(right)) return false;
        return isPalindromeRecursive(text, left + 1, right - 1);
    }

    public static boolean isPalindromeArrayReversal(String text) {
        char[] chars = text.toCharArray();
        for (int left = 0, right = chars.length - 1; left < right; left++, right--) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
        }
        return text.equals(new String(chars));
    }

    public static void main(String[] args) {
        String text = "madam";
        System.out.println("Iterative: " + label(isPalindromeIterative(text))
                + " | Recursive: " + label(isPalindromeRecursive(text))
                + " | Array Reversal: " + label(isPalindromeArrayReversal(text)));
    }

    private static String label(boolean palindrome) {
        return palindrome ? "Palindrome" : "Not Palindrome";
    }
}
