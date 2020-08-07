import java.util.HashMap;

public class LeetCode149 {

    public int maxPoints(int[][] points) {

        int m = points.length;
        if(m < 2)
            return m;
        int maxPoints = 2;

        for (int i = 0; i < m - 1; i++) {
            HashMap<Integer, HashMap<Integer, Integer>> record =
                    new HashMap<>();
            //  <a,<b,num of points>

            int x1 = points[i][0];
            int y1 = points[i][1];
            for (int j = i + 1; j < m; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];

                int a = (y1 - y2) / (x1 - x2);
                int b = a * (x1 - y1);

                if( record.containsKey(a) ) {
                    HashMap<Integer, Integer> bMap = record.get(a);
                    if(bMap.containsKey(b)) {
                        int num = bMap.get(b) + 1;
                        maxPoints = Math.max(maxPoints, num);
                        bMap.put(b, num);
                        record.put(a, bMap);
                    }
                    else{
                        bMap.put(b, 2);
                        record.put(a, bMap);
                    }
                }
                else {
                    HashMap<Integer, Integer> bMap = new HashMap<>();
                    bMap.put(b, 2);
                    record.put(a, bMap);
                }
            }
        }
        return maxPoints;
    }
}


