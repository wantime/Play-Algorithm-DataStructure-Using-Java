package LeetCode;

import java.util.*;

public class WaterPuzzle {

    int[] pre;
    int end = -1;

    public WaterPuzzle(){

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[100];

        pre = new int[100];

        q.add(0);
        visited[0] = true;

        while (!q.isEmpty()){

            int cur = q.remove();
            int a = cur / 10, b = cur % 10;
            //  max a =5, max b = 3

            ArrayList<Integer> nexts = new ArrayList<>();
            //  把a或者b倒满
            nexts.add(5 * 10 + b);
            nexts.add(a * 10 + 3);
            nexts.add(a * 10 + 0);
            nexts.add(0 * 10 + b);

            //  把其中一个桶导入另一个桶，比如说，把a到入b
            int x = Math.min(a, 3 - b);
            nexts.add( (a - x) * 10 + (b + x));

            int y = Math.min(5 - a, b);
            nexts.add( (a + y) * 10 + (b - y));

            for(int next: nexts){

                if(!visited[next]){
                    visited[next] = true;
                    q.add(next);
                    pre[next] = cur;
                    if(next / 10 == 4){
                        end = next;
                        return;
                    }
                }
            }
        }


    }

    public Iterable<Integer> result(){

        ArrayList<Integer> res = new ArrayList<>();
        if(end == -1) return res;

        int cur = end;
        while (cur != 0){
            res.add(cur);
            cur = pre[cur];
        }
        res.add(0);

        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new WaterPuzzle().result().toString());
    }
}
