import java.util.*;

public class Solution {
    public static void main(String[] args) {
        List<String> codes = new ArrayList<>(Arrays.asList("TWLO", "CODE", "HTCH"));
        List<String> phones = new ArrayList<>(Arrays.asList("+17474824380", "+14157088956", "+919810155555", "+15109926333", "+1415123456"));
        List<String> res = new Solution().findPhoneNumbers(codes, phones);
        System.out.println(res);
    }

    private List<String> findPhoneNumbers(List<String> codes, List<String> phoneNumbers) {
        HashMap<Character, List<Character>> map = new HashMap();
        map.computeIfAbsent('2', x -> new ArrayList(Arrays.asList('A', 'B', 'C')));
        map.computeIfAbsent('3', x -> new ArrayList(Arrays.asList('D', 'E', 'F')));
        map.computeIfAbsent('4', x -> new ArrayList(Arrays.asList('G', 'H', 'I')));
        map.computeIfAbsent('5', x -> new ArrayList(Arrays.asList('J', 'K', 'L')));
        map.computeIfAbsent('6', x -> new ArrayList(Arrays.asList('M', 'N', 'O')));
        map.computeIfAbsent('7', x -> new ArrayList(Arrays.asList('P', 'Q', 'R', 'S')));
        map.computeIfAbsent('8', x -> new ArrayList(Arrays.asList('T', 'U', 'V')));
        map.computeIfAbsent('9', x -> new ArrayList(Arrays.asList('W', 'X', 'Y', 'Z')));

        List<String> res = new ArrayList<>();
        for(String phone : phoneNumbers) {
            for(String code : codes) {
                int i = 0;
                boolean found = false;
                while(i <= phone.length() - code.length()) {
                    for(int j = 0; j < code.length(); j++) {
                        char pChar = phone.charAt(i + j);
                        char cChar = code.charAt(j);
                        if(pChar == '+' || pChar == '0' || pChar == '1' || !map.get(pChar).contains(cChar)) {
                            break;
                        }

                        if(j == code.length()-1) {
                            found = true;
                        }
                    }
                    if(found) {
                        res.add(phone);
                        break;
                    }
                    i++;
                }
                if(found) {
                    break;
                }
            }
        }
        Collections.sort(res);
        return res;
    }
}
