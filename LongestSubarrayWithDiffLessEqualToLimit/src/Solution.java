// Given an array of integers nums and an integer limit, return the size of the longest non-empty subarray such that the
// absolute difference between any two elements of this subarray is less than or equal to limit.

// Sliding Window
// Use indices i and j to represent the start and end indices of a sliding window. Any number in the SW has absolute
// difference less than or equal to the limit
// Create a min heap and a max heap to store all numbers in current sliding window
// While j is less than the input array's length, do:
// 1. Get the difference from cur max - cur min
// 2. If the diff is smaller or equal to limit, update the max length and move j by 1. Put nums[j] into both min and max heap
// if j is still within array range
// 3. Else, it means the max - min diff in current sliding window is over the limit. Remove nums[i] from min and max heap,
// and move i by 1
// Return the max length in the end

// Time: O(nlogn), Space: O(n)

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        int [] nums = new int[]{4,2,2,2,4,4,2,2};
        System.out.print(new Solution().longestSubarray(nums, 0));
    }

    public int longestSubarray(int[] nums, int limit) {
        int maxLen = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue();
        PriorityQueue<Integer> maxHeap = new PriorityQueue(Collections.reverseOrder());
        minHeap.offer(nums[0]);
        maxHeap.offer(nums[0]);
        int i = 0;
        int j = 0;

        while(j < nums.length) {
            int diff = maxHeap.peek() - minHeap.peek();
            if(diff <= limit) {
                maxLen = Math.max(maxLen, j-i+1);
                j++;
                if(j < nums.length) {
                    minHeap.offer(nums[j]);
                    maxHeap.offer(nums[j]);
                }
            }
            else {
                minHeap.remove(nums[i]);
                maxHeap.remove(nums[i]);
                i++;
            }
        }
        return maxLen;
    }
}
