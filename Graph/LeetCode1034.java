package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode1034 {

    private int rows;
    private int cols;
    private boolean[][] visited;
    private int[][] d = {{1,0},{-1,0},{0,1},{0,-1}};

    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {

        rows = grid.length;
        if(rows == 0) return grid;
        cols = grid[0].length;
        if(cols == 0) return grid;

        visited = new boolean[rows][cols];

        bfs(r0, c0, grid, color);
        return grid;

    }

    private void bfs(int r0, int c0, int[][] grid, int color){

        visited[r0][c0] = true;

        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();

        Queue<Integer> borderX = new LinkedList<>();
        Queue<Integer> borderY = new LinkedList<>();

        qx.add(r0);
        qy.add(c0);
        while (!qx.isEmpty()){
            int x = qx.remove();
            int y = qy.remove();
            for (int i = 0; i < 4; i++) {
                int nextX = x + d[i][0];
                int nextY = y + d[i][1];
                if( inArea(nextX, nextY) && !visited[nextX][nextY] && grid[nextX][nextY] == grid[r0][c0] ){

                    visited[nextX][nextY] = true;
                    qx.add(nextX);
                    qy.add(nextY);
                }
                else if( !inArea(nextX, nextY) || grid[nextX][nextY] != grid[r0][c0]){
                    borderX.add(x);
                    borderY.add(y);
                }
            }
        }

        while (!borderX.isEmpty()){
            int x = borderX.remove();
            int y = borderY.remove();
            grid[x][y] = color;
        }
    }

    private boolean inArea(int x, int y){
        return (x >= 0 && y >= 0 && x < rows && y < cols);
    }

    public static void main(String[] args) {
        int[][] grid = {{1,1,},{1,2}};
        new LeetCode1034().colorBorder(grid, 0, 0, 3);
    }
}
