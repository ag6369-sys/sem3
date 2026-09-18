package arrays.assigment_problems;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixFrequency = new HashMap<>();
        prefixFrequency.put(0, 1);
        int currentSum = 0, count = 0;
        for (int value : nums) {
            currentSum += value;
            count += prefixFrequency.getOrDefault(currentSum - k, 0);
            prefixFrequency.put(currentSum, prefixFrequency.getOrDefault(currentSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
    }
}
