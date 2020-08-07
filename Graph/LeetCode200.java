package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode200 {

    private int d[][] = {{-1,0},{0,1}, {1,0}, {0,-1}};
    private int m, n;
    boolean[][] visited;

    public int numIslands(char[][] grid) {

        m = grid.length;
        if(m == 0)
            return 0;
        n = grid[0].length;

        visited = new boolean[m][n];

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    res ++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }
    private void dfs(char[][] grid, int startx, int starty){

        visited[startx][starty] = true;
        for (int i = 0; i < 4; i++) {
            int newx = startx + d[i][0];
            int newy = starty + d[i][1];
            if(inArea(newx, newy) && grid[newx][newy] == '1' && !visited[newx][newy]) {
                dfs(grid, newx, newy);
            }
        }
    }

    private void bfs(char[][] grid, int startx, int starty){

        visited[startx][starty] = true;

        Queue<Integer> queueX = new LinkedList<>();
        Queue<Integer> queueY = new LinkedList<>();

        queueX.add(startx);
        queueY.add(starty);

        while (!queueX.isEmpty()){

            int x = queueX.remove();
            int y = queueY.remove();
            for (int i = 0; i < 4; i++) {
                int nextX = x + d[i][0];
                int nextY = y + d[i][1];
                if(inArea(nextX, nextY) && !visited[nextX][nextY] && grid[nextX][nextY] == '1' ){
                    visited[nextX][nextY] = true;
                    queueX.add(nextX);
                    queueY.add(nextY);
                }
            }
        }
    }

    private boolean inArea(int x, int y){
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
