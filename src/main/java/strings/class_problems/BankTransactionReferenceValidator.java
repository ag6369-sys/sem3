package strings.class_problems;

public class BankTransactionReferenceValidator {
    public static String normalizeReference(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() < 3) return trimmed;
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    public static String validateAndFormat(String reference) {
        if (reference.length() != 14) return "Invalid: reference must be exactly 14 characters";
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) return "Invalid: bank code must be 3 letters";
        }
        for (int i = 3; i < reference.length(); i++) {
            if (!Character.isDigit(reference.charAt(i))) return "Invalid: reference body must contain only digits";
        }
        return "[" + reference.substring(0, 3) + "] DATE: "
                + reference.substring(3, 5) + "/" + reference.substring(5, 7) + "/"
                + reference.substring(7, 9) + " | SEQ: " + reference.substring(9);
    }

    public static void main(String[] args) {
        System.out.println(validateAndFormat(normalizeReference(" hdf03022600042 ")));
    }
}
