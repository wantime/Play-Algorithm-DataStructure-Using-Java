import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LeetCode49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new LinkedList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        for(int i = 0; i < strs.length; i ++){

            String s = strs[i];
            char[] c = s.toCharArray();
            Arrays.sort(c);
            s = new String(c);
            if(map.containsKey(s)){
                List<String> list = map.get(s);
                list.add(strs[i]);
                map.put(s, list);
            }
            else {
                List<String> list = new LinkedList<>();
                list.add(strs[i]);
                map.put(s, list);
            }
        }

        for(List list : map.values())
            res.add(list);

        return res;
    }
}
