import java.util.Scanner;

public class WarehouseInventoryBalancer {
    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        if (sectionA.length != sectionB.length) {
            throw new IllegalArgumentException("The two arrays must have equal length.");
        }
        long totalA = 0;
        long totalB = 0;
        int highest = Integer.MIN_VALUE;
        int highestIndex = -1;
        char highestSection = 'A';
        // Scan all of A first so ties prefer A, then the earliest item.
        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            if (highestIndex == -1 || sectionA[i] > highest) {
                highest = sectionA[i];
                highestIndex = i;
            }
        }
        for (int i = 0; i < sectionB.length; i++) {
            totalB += sectionB[i];
            if (sectionB[i] > highest) {
                highest = sectionB[i];
                highestIndex = i;
                highestSection = 'B';
            }
        }
        String status = totalA == totalB ? "Balanced" : "Not Balanced";
        System.out.print("Section A Total: " + totalA + " | Section B Total: " + totalB
                + " | Status: " + status + " | ");
        if (highestIndex == -1) System.out.println("No Inventory Items Found");
        else System.out.println("Highest Quantity: " + highest + " (Section "
                + highestSection + ", Item " + (highestIndex + 1) + ")");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        if (n < 0) throw new IllegalArgumentException("Item count cannot be negative.");
        int[] sectionA = new int[n];
        int[] sectionB = new int[n];
        for (int i = 0; i < n; i++) sectionA[i] = input.nextInt();
        for (int i = 0; i < n; i++) sectionB[i] = input.nextInt();
        analyzeInventory(sectionA, sectionB);
    }
}
