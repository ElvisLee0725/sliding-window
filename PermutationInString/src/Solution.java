// Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
// In other words, one of the first string's permutations is the substring of the second string.
// The input strings only contain lower case letters.

// Sliding Window
// Create an array of length 26. Loop s1 and get the frequency of each letter
// Loop through s2 with a sliding window of s1's length. For each letter in s2 in sliding window, minus 1 in array
// For each letter that's outside of sliding window, plus 1 in array
// Check if the array is all 0. If so, return true
// After the loop, return false

// Time: O(n), Space: O(1)

public class Solution {

    public static void main(String [] argvs) {
        System.out.println(new Solution().checkInclusion("ab", "eidboaoo"));
    }

    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return false;
        }

        int [] arr = new int[26];
        for(int i = 0; i < s1.length(); i++) {
            arr[s1.charAt(i) - 'a'] += 1;
        }

        for(int i = 0; i < s2.length(); i++) {
            // Add in sliding window
            arr[s2.charAt(i) - 'a'] -= 1;

            // Pop out if exceed the size of sliding window
            if(i - s1.length() + 1 > 0) {
                arr[s2.charAt(i - s1.length()) - 'a'] += 1;
            }

            if(checkArrayZero(arr)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkArrayZero(int [] arr) {
        for(int num : arr) {
            if(num != 0) {
                return false;
            }
        }
        return true;
    }
}
