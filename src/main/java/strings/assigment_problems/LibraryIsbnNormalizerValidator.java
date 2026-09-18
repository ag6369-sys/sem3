package strings.assigment_problems;

public class LibraryIsbnNormalizerValidator {
    public static String normalizeCode(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() < 3) return trimmed;
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    public static String validateAndFormat(String code) {
        if (code.length() != 13) return "Invalid: code must be exactly 13 characters";
        for (int i = 0; i < 3; i++) if (!Character.isLetter(code.charAt(i))) return "Invalid: publisher code must be 3 letters";
        for (int i = 3; i < code.length(); i++) if (!Character.isDigit(code.charAt(i))) return "Invalid: code body must contain only digits";
        return "[" + code.substring(0, 3) + "] YEAR: " + code.substring(3, 7) + " | CATALOG: " + code.substring(7);
    }

    public static void main(String[] args) {
        System.out.println(validateAndFormat(normalizeCode(" pen2026004251 ")));
    }
}
