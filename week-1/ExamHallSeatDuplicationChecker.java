import java.util.Scanner;

public class ExamHallSeatDuplicationChecker {
    public static void checkDuplicateSeats(int[] seatNumbers) {
        boolean found = false;
        for (int i = 0; i < seatNumbers.length; i++) {
            // Report each duplicated number only at its first occurrence.
            boolean alreadyChecked = false;
            for (int j = 0; j < i; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    alreadyChecked = true;
                    break;
                }
            }
            if (alreadyChecked) continue;
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    found = true;
                    break;
                }
            }
        }
        if (!found) System.out.println("No Duplicate Seats Found");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        if (n < 0) throw new IllegalArgumentException("Seat count cannot be negative.");
        int[] seats = new int[n];
        for (int i = 0; i < n; i++) seats[i] = input.nextInt();
        checkDuplicateSeats(seats);
    }
}
