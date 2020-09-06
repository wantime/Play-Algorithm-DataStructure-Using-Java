import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode131 {

    private List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        if(s.length() == 0)
            return res;

        LinkedList<String> list = new LinkedList<>();
        getCombination(s, 0, list);
        return res;
    }
    private void getCombination(String s, int index, LinkedList<String> list){

        if(index == s.length()){
            res.add(new LinkedList<>(list));
            return;
        }


        for (int i = index; i < s.length(); i++) {

            if(!isPalindrome(s, index, i))
                continue;
            list.addLast(s.substring(index, i+1));
            getCombination(s, i+1, list);
            list.removeLast();
        }
    }
    private boolean isPalindrome(String s, int l, int r){
        if(s.length() == 0)
            return true;

        while (l< r) {
            if (s.charAt(l++) != s.charAt(r--))
                return false;
        }
        return true;
    }
}
