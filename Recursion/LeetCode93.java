import java.util.LinkedList;
import java.util.List;

public class LeetCode93 {

    private List<String> res;
    public List<String> restoreIpAddresses(String s) {

        res = new LinkedList<>();
        if(s.length() < 4)
            return res;
        LinkedList<String> list = new LinkedList<>();
        dfs(s, 0, list);
        return res;
    }
    private void dfs(String s, int index, LinkedList<String> list){
        if(list.size() == 4) {
            res.add(list.get(0) + "." + list.get(1) + "." + list.get(2) + "." + list.get(3));
            return;
        }

        if(list.size() == 3){
            String tempS = s.substring(index);
            if( tempS.length() < 4) {
                int num = Integer.parseInt(tempS);
                if (num < 256) {
                    if (tempS.length() < 2 || tempS.charAt(0) != '0') {

                        list.addLast(tempS);
                        dfs(s, s.length() - 1, list);
                        list.removeLast();
                    }
                }
            }
            return;
        }
        for (int i = 1; i < 4 && index+i < s.length(); i++) {

            String tempS = s.substring(index, index+i);

            int num =  Integer.parseInt(tempS);

            if( num < 256 ) {
                if( tempS.length() < 2  || tempS.charAt(0) != '0'  ) {
                    list.addLast(tempS);
                    dfs(s, index + i, list);
                    list.removeLast();
                }
            }

        }
    }
}
