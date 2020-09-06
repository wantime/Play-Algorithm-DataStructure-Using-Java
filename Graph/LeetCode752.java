package LeetCode;

import java.util.*;

public class LeetCode752 {


    public int openLock(String[] deadends, String target) {

        HashSet<String> deadset = new HashSet<>();
        for (int i = 0; i < deadends.length; i++) {
            deadset.add(deadends[i]);
        }

        if(deadset.contains(target)) return -1;
        if(deadset.contains("0000")) return -1;
        if(target.equals("0000")) return 0;

        //  BFS
        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        HashMap<String, Integer> dis = new HashMap<>();

        dis.put("0000", 0);
        q.add("0000");
        visited.add("0000");

        while (!q.isEmpty()){
            String  curs = q.remove();
            char[] curArray = curs.toCharArray();

            ArrayList<String> nexts = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                char o = curArray[i];

                curArray[i] = Character.forDigit( (curArray[i] - '0' + 1) % 10, 10 );
                nexts.add(new String(curArray));
                curArray[i] = o;

                curArray[i] = Character.forDigit( (curArray[i] - '0' + 9) % 10, 10 );
                        //(char)( (curArray[i] - '0' + 9) % 10) + '0' );
                nexts.add(new String(curArray));
                curArray[i] = o;
            }


            for (String next: nexts){
                if(!deadset.contains(next) && !visited.contains(next)){
                    q.add(next);
                    visited.add(next);
                    dis.put(next, dis.get(curs) + 1);
                    if(next.equals(target))
                        return dis.get(next);
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "0000";
        System.out.println((char)('0' - '0' + 1 + '0'));

    }
}
