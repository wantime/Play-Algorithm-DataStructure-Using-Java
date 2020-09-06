package LeetCode;

import java.util.Arrays;

public class LeetCode980 {

    private int[][] grid;
    private int row, col;
    private int start, end;
    private int[][] d = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
    private int[][] memo;


    public int uniquePathsIII(int[][] grid) {

        this.grid = grid;
        row = grid.length;
        col = grid[0].length;
        memo = new int[1 << row * col][ row * col];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }


        int left = row * col;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if( grid[i][j] == 1) {
                    start = i * col + j;
                    grid[i][j] = 0;
                }
                else if(grid[i][j] == 2){
                    end = i * col + j;
                    grid[i][j] = 0;
                }
                else if(grid[i][j] == -1)
                    left --;
            }
        }

        return dfs(0, start, left);
    }

    private int dfs(int visited, int v, int left){

        if(memo[visited][v] != -1)
            return memo[visited][v];

        int x = v / col,y = v % col;
        visited += (1 << v);
        left --;

        if(left == 0 && v == end) {
            memo[visited][v] = 1;
            return 1;
        }

        int res = 0;

        for (int i = 0; i < 4; i ++){
            int nextX = x + d[i][0];
            int nextY = y + d[i][1];
            int next = nextX * col + nextY;
            if(inArea(nextX, nextY) && grid[nextX][nextY] == 0 && (visited & ( 1 << next )) == 0)
                res += dfs(visited, next, left);
        }
        return memo[visited][v] = res;
    }
    private boolean inArea(int x, int y){

        return x >= 0 && y >= 0 && x < row && y < col;
    }
}
