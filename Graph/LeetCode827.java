package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode827 {

    private boolean[][] visited;
    private int rows;
    private int cols;
    private int[][] componet;
    private int[][] d = {{1,0},{-1,0},{0,1},{0,-1}};

    public int largestIsland(int[][] grid) {

        rows = grid.length;
        cols = grid[0].length;

        componet = new int[rows][cols];
        visited = new boolean[rows][cols];

        List<Integer> areaCount = new ArrayList<>();
        int count = 0;
        int res = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(!visited[i][j] && grid[i][j] == 1) {
                    int area = dfs(i, j, grid, count);
                    count ++;
                    res = Math.max(res, area);
                    areaCount.add(area);
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(grid[i][j] == 0){
                    int tmp = 0;
                    boolean[] visitedArea = new boolean[count];
                    for (int k = 0; k < 4; k++) {
                        int x = i + d[k][0];
                        int y = j + d[k][1];
                        if(inArea(x, y) && grid[x][y] == 1 && !visitedArea[componet[x][y]]){
                            tmp += areaCount.get(componet[x][y]);
                            visitedArea[componet[x][y]] = true;
                        }
                    }
                    res = Math.max(res, tmp+1);
                }
            }
        }
        return res;
    }

    private int dfs(int i, int j, int[][] grid, int count){

        visited[i][j] = true;
        componet[i][j] = count;
        int res = 1;
        for (int k = 0; k < 4; k++) {
            int nextX = i + d[k][0];
            int nextY = j + d[k][1];
            if( inArea(nextX, nextY) && !visited[nextX][nextY] && grid[nextX][nextY] == 1){
                res += dfs(nextX, nextY, grid, count);
            }
        }
        return res;
    }

    private boolean inArea(int x, int y){
        return (x >= 0 && y >= 0 && x < rows && y < cols);
    }

}
