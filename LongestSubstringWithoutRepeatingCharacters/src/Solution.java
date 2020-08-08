// Given a string, find the length of the longest substring without repeating characters.

// Use a Deque as the sliding window
// Iterate the input string, check if the deque contains the current character? If so, keep popping the deque until
// the the same character already in deque is popped out.
// Then, Add new character into the deque.
// Update the maxLen of the deque. Return the maxLen at the end
// Time: O(n), Space: O(n)

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public static void main(String [] args) {
        System.out.println(new Solution().longestSubstring("pwwkew"));
    }

    public int longestSubstring(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        Deque<Character> deque = new LinkedList();
        int maxLen = 0;

        for(int i = 0; i < s.length(); i++) {
            while(deque.contains(s.charAt(i))) {
                deque.pollFirst();
            }
            deque.offerLast(s.charAt(i));
            maxLen = Math.max(maxLen, deque.size());
        }
        return maxLen;
    }
}
