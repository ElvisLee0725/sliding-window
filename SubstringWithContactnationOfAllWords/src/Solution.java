import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
Sliding Window:
- Use a HashMap to store <Word, Frequency>
- Check if the substring from i to i + wordLen contains all words in hashmap
- If it contains, add the i index to result ArrayList
- Move index i by 1 and repeating the above process

Time: O((N*M) while N is the length of s and M is the length words array
Space: O(M)
*/
class Solution {
    public static void main(String[] args) {
        List<Integer> res = new Solution().findSubstring("barfoothefoobarman", new String[]{"bar", "foo"});
        System.out.println(res);
    }
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList();
        int wordsLen = words.length * words[0].length();
        if(s.length() < wordsLen) {
            return res;
        }

        HashMap<String, Integer> map = new HashMap();
        for(String str : words) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        HashMap<String, Integer> map2;
        for(int i = 0; i <= s.length() - wordsLen; i++) {
            map2 = new HashMap(map);

            for(int j = i; j < i + wordsLen; j += words[0].length()) {
                String tmp = s.substring(j, j + words[0].length());
                if(!map2.containsKey(tmp)) {
                    break;
                }
                else {
                    if(map2.get(tmp) == 1) {
                        map2.remove(tmp);
                    }
                    else {
                        map2.put(tmp, map2.get(tmp) - 1);
                    }
                }
            }
            if(map2.size() == 0) {
                res.add(i);
            }
        }
        return res;
    }
}
