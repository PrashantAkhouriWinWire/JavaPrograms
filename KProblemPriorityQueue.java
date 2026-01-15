// K Operations on List
// Problem:
// Given a list of numbers, perform the following operation K times:
// Remove the largest element, divide it by 2, take the ceiling, and insert it back into the list.
// At the end, compute the minimum possible sum of the list.
// Example:
// Input: [7, 10, 20]
// Steps:
// 20 → 10 → 5
// 10 → 5
// 7 → 4
// Final Sum = 5 + 5 + 4 = 14.
// Key Concepts: Priority Queue / Max Heap, Ceiling function, Iterative updates.

import java.util.Collections;
import java.util.PriorityQueue;

public class KProblemPriorityQueue {
    public static int minSumAfterKOperations(int[] nums, int K) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        // Add all numbers to the max heap
        for (int num : nums) {
            maxHeap.add(num);
        }
        
        // Perform K operations
        for (int i = 0; i < K; i++) {
            int largest = maxHeap.poll();
            int reduced = (int) Math.ceil(largest / 2.0);
            maxHeap.add(reduced);
        }
        
        // Calculate the sum of the remaining elements
        int sum = 0;
        while (!maxHeap.isEmpty()) {
            sum += maxHeap.poll();
        }
        
        return sum;
    }

    public static void Run(String[] args) {
        int[] nums = {7, 10, 20};
        int K = 3;
        int result = minSumAfterKOperations(nums, K);
        System.out.println("Minimum possible sum after " + K + " operations: " + result); // Expected output: 14
    }
}