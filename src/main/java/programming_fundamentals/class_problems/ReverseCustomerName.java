package programming_fundamentals.class_problems;

public class ReverseCustomerName {
    public static String reverseCustomerName(String customerName) {
        char[] reversed = new char[customerName.length()];
        for (int i = 0; i < customerName.length(); i++) {
            reversed[i] = customerName.charAt(customerName.length() - 1 - i);
        }
        return new String(reversed);
    }

    public static void main(String[] args) {
        String customerName = "Sunil";
        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reverseCustomerName(customerName));
    }
}
