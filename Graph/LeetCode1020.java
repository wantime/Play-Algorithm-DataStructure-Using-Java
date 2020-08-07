package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode1020 {

    //  首先把把所有边界上的岛屿全部下沉(访问一边)，然后判断图中还剩多少岛屿

    private boolean[][] visited;

    private int rows;
    private int cols;

    private int[][] d = {{-1,0}, {0, -1}, {1, 0}, {0, 1}};

    public int numEnclaves(int[][] A) {

        rows = A.length;
        if(rows == 0) return 0;
        cols = A[0].length;
        if(cols == 0) return 0;
        visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            if (!visited[i][0] && A[i][0] == 1)
                dfs(i, 0, A);
            if (!visited[i][cols - 1] && A[i][cols - 1] == 1)
                dfs(i, cols - 1, A);
        }

        for (int i = 0; i < cols; i++) {
            if(!visited[0][i] && A[0][i] == 1)
                dfs(0, i, A);
            if(!visited[rows-1][i] && A[rows-1][i] == 1)
                dfs(rows-1, i, A);
        }

        int res = 0;
        for (int i = 1; i < rows; i++)
            for (int j = 1; j < cols; j++)
                if(!visited[i][j] && A[i][j] == 1){
                    res += bfs(i, j, res, A);
                }
        return res;
    }

    private void dfs(int x, int y, int[][] A){

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + d[i][0];
            int nextY = y + d[i][1];
            if(inArea(nextX, nextY) && !visited[nextX][nextY] && A[nextX][nextY] == 1)
                dfs(nextX, nextY, A);
        }

    }

    private int bfs(int x, int y, int res , int[][] A){

        visited[x][y] = true;
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();

        qx.add(x);
        qy.add(y);
        while (!qx.isEmpty()){
            res ++;
            x = qx.remove();
            y = qy.remove();
            for (int i = 0; i < 4; i++) {
                int nextX = x + d[i][0];
                int nextY = y + d[i][1];
                if(inArea(nextX, nextY) && !visited[nextX][nextY] && A[nextX][nextY] == 1) {
                    visited[nextX][nextY] = true;
                    qx.add(nextX);
                    qy.add(nextY);
                }
            }
        }
        return res;
    }

    private boolean inArea(int x, int y){
        return( x >= 0 && x < rows && y >= 0 && y < cols);
    }

    public static void main(String[] args) {
        int[][] A = {   {0,0,0,0},
                        {1,0,1,0},
                        {0,1,1,0},
                        {0,0,0,0}};
        new LeetCode1020().numEnclaves(A);
    }
}
