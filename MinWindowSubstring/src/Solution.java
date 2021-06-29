import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().minimumWindowSubstring("ADOBECODEBANC", "ABC"));
    }
    // "ADOBECODEBANC"  <'A', 0>, <'B', 0>, <'C', 0>, countMissing = 1
    //   i
    //        j
    // Sliding Window:
    // Use i and j representing the sliding window. HashMap<Character, Frequency> is the letters of chars string
    // Hunting Phase: Check the char at index j. If the map contains it, reduce its frequency
    // If a letter's frequency reaches 0, reduce countMissing by 1. Then, move index j
    // Catchup Phase: When countMissing is 0, we have possible result within i and j, update the possible range of result
    // Then, increase the frequency in map and countMissing, then move index i
    // Return the result within index start and end
    // Time: O(n), Space: O(1)
    public String minimumWindowSubstring(String fullString, String chars) {
        // Write your code here
        int i = 0;
        int j = 0;
        int start = 0;
        int end = fullString.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int k = 0; k < chars.length(); k++) {
            map.put(chars.charAt(k), map.getOrDefault(chars.charAt(k), 0) + 1);
        }

        int countMissing = map.size();
        while(j < fullString.length()) {
            while(countMissing > 0 && j < fullString.length()) {
                char ch = fullString.charAt(j);
                if(map.containsKey(ch)) {
                    if(map.get(ch) == 1) {
                        countMissing -= 1;
                    }
                    map.put(ch, map.get(ch) - 1);
                    if(countMissing == 0) break;
                }
                j++;
            }

            while(countMissing == 0 && j < fullString.length()) {
                if(j - i + 1 < end - start + 1) {
                    start = i;
                    end = j;
                }
                char ch = fullString.charAt(i);
                if(map.containsKey(ch)) {
                    if(map.get(ch) == 0) {
                        countMissing += 1;
                    }
                    map.put(ch, map.get(ch) + 1);
                }
                i++;
            }
            j++;
        }
        return end == fullString.length() ? "" : fullString.substring(start, end + 1);
    }
}
