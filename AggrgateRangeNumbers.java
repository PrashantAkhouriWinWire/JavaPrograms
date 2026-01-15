// Aggregate Range of Numbers
// Problem:
// Input: ["81", "82-100", "81-90", "84", "85"]
// Output: Aggregate overlapping ranges into a single range.
// Expected Output: ["81-100"]
// If there is any gap, return the list as is.
// Key Concepts: Interval merging, Sorting, Edge cases.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class AggrgateRangeNumbers {
    public static List<String> aggregateRanges(String[] ranges) {
        List<int[]> intervals = new ArrayList<>();

        // Parse input strings into intervals
        for (String range : ranges) {
            String[] parts = range.split("-");
            int start = Integer.parseInt(parts[0]);
            int end = parts.length > 1 ? Integer.parseInt(parts[1]) : start;
            intervals.add(new int[]{start, end});
        }

        // Sort intervals based on the start value
        Collections.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] current = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            int[] next = intervals.get(i);
            if (current[1] >= next[0] - 1) { // Overlapping or contiguous
                current[1] = Math.max(current[1], next[1]);
            } else {
                merged.add(current);
                current = next;
            }
        }
        merged.add(current);

        // Convert merged intervals back to string format
        List<String> result = new ArrayList<>();
        for (int[] interval : merged) {
            if (interval[0] == interval[1]) {
                result.add(String.valueOf(interval[0]));
            } else {
                result.add(interval[0] + "-" + interval[1]);
            }
        }

        return result;
    }

    public static void Run(String[] args) {
        String[] ranges = {"81", "82-100", "81-90", "84", "85"};
        List<String> result = aggregateRanges(ranges);
        System.out.println("Aggregated Ranges: " + result); // Expected output: ["81-100"]
    }
}