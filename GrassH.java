// Grasshopper Jump Problem
// Use prefix sum technique.
// Track minimum prefix sum.
// Starting stair = 1 - minimum prefix sum.
// Description:
//  A grasshopper is jumping on a number line.
//  The grasshopper starts at some position and makes a series of jumps.
//  Each jump is represented by an integer in an array,
//  where a positive integer indicates a jump to the right
// and a negative integer indicates a jump to the left.
//  The goal is to determine the minimum starting position on the number line
//  such that the grasshopper never lands on or below position 0 during its jumps.

public class GrassH {

    public static int minStairs(int[] jumps) {
        int prefixSum = 0;
        int minPrefixSum = 0;

        for (int jump : jumps) {
            prefixSum += jump;
            if (prefixSum < minPrefixSum) {
                minPrefixSum = prefixSum;
            }
        }
        return 1 - minPrefixSum;
    }

    public static void Run(String[] args) {
        int[] jumps = {-2, 3, -5, 1, -1}; // Example input
        int result = minStairs(jumps);
        System.out.println("Minimum starting stair: " + result); //expected output: 3
    }
}