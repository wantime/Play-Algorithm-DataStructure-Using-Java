package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 这道题注意特殊用例[[0]],
 *
 * [[1],[0]]等
 */
public class LeetCode1091 {

    private int rows;
    private int cols;
    private boolean[][] visited;
    private int[][] d = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0,-1}, {-1, -1}};
    private int[][] dis;    //  distance from point(0,0)

    public int shortestPathBinaryMatrix(int[][] grid) {

        rows = grid.length;
        if(rows == 0) return -1;
        cols = grid[0].length;
        if(cols == 0) return -1;

        if(grid[0][0] != 0)
            return -1;
        visited = new boolean[rows][cols];
        dis = new int[rows][cols];

        return bfs(grid);
    }

    private int bfs(int[][] grid){

        visited[0][0] = true;
        dis[0][0] = 0;

        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        qx.add(0);
        qy.add(0);

        while (!qx.isEmpty()) {
            int x = qx.remove();
            int y = qy.remove();
            for (int i = 0; i < 8; i++) {
                int nextX = x + d[i][0];
                int nextY = y + d[i][1];
                if (inArea(nextX, nextY) && !visited[nextX][nextY] && grid[nextX][nextY] == 0){
                    visited[nextX][nextY] = true;
                    if(nextX == rows - 1 && nextY == cols - 1)
                        return dis[x][y] + 1;
                    dis[nextX][nextY] = dis[x][y] + 1;
                    qx.add(nextX);
                    qy.add(nextY);
                }
            }
        }
        return dis[rows-1][cols-1] == 0 ? -1 : dis[rows-1][cols-1];
    }
    private boolean inArea(int x, int y){
        return (x >= 0 && y >= 0 && x < rows && y < cols);
    }
}
