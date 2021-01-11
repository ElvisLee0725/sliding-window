// Given a string s and an integer k.
// Return the maximum number of vowel letters in any substring of s with length k.
// Vowel letters in English are (a, e, i, o, u).
// 1 <= s.length <= 10^5
// s consists of lowercase English letters.
// 1 <= k <= s.length

import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        System.out.print(new Solution().maxVowels("abciiidef", 3));
    }
    // Use a hashset to store the vowels
    // Use 2 pointers i and j to represent a sliding window and the range of it is k
    // Ex. aeiou, k = 2
    //     ij
    // Use a for loop to move j until the last index:
    // At each round, move j by 1 and see if there is a new vowel? If so, add counter by 1
    // Then, check if i is pointing at a vowel? If so, counter minus by 1 and move i by 1
    // Update the max vowels at the end of each iteration
    // Time: O(n), Space: O(1)
    public int maxVowels(String s, int k) {
        HashSet<Character> hs = new HashSet();
        hs.add('a');
        hs.add('e');
        hs.add('i');
        hs.add('o');
        hs.add('u');

        int max = 0;
        int curVowels = 0;
        int i = 0;
        for(int j = 0; j < s.length(); j++) {
            if(j < k) {
                if(hs.contains(s.charAt(j))) {
                    curVowels++;
                }
            }
            else {
                if(hs.contains(s.charAt(j))) {
                    curVowels++;
                }
                if(hs.contains(s.charAt(i))) {
                    curVowels--;
                }
                i++;
            }
            if(curVowels == k) {
                return k;
            }
            max = Math.max(max, curVowels);
        }
        return max;
    }
}
