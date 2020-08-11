// Given an array of n positive integers and a positive integer s, find the minimal length of
// a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

// Use concept of Sliding Window
// Create variable: sum, startIndex, minLen
// Iterate the input array and sum up the current element. While the sum is greater than target, do:
// 1. Check the current length and update minLen if possible
// 2. Minus the number at array[startIndex] from sum and move startIndex by 1
// Return the minLen if it's value is not Integer.MAX_VALUE
// Time: O(n), Space: O(1)

public class Solution {
    public static void main(String [] argvs) {
        int [] arr = new int[]{2, 3, 1, 2, 4, 3};
        System.out.println(new Solution().minSubarrayLen(7, arr));
    }

    public int minSubarrayLen(int s, int [] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int sum = 0;
        int startIndex = 0;
        int minLen = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];

            while(sum >= s) {
                minLen = Math.min(i - startIndex + 1, minLen);
                sum -= nums[startIndex];
                startIndex++;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
