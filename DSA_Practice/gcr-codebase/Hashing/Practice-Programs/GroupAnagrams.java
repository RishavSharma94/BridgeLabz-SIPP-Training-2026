import java.util.*;

public class GroupAnagrams {

    static List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            char[] ch = str.toCharArray();
            Arrays.sort(ch);

            String key = new String(ch);

            map.putIfAbsent(key, new ArrayList<>());

            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {

        String[] strs = {
                "eat", "tea", "tan",
                "ate", "nat", "bat"
        };

        List<List<String>> result = groupAnagrams(strs);

        System.out.println(result);
    }
}