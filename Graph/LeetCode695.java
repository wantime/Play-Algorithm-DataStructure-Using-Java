package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode695 {

    private boolean[][] visited;
    private int[][] graph;

    public int maxAreaOfIsland(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int maxArea = 0;
        graph = grid;
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if(!visited[i][j] && graph[i][j] == 1)
                    maxArea = Math.max(maxArea, dfs(i, j));
        return maxArea;
    }

    private int dfs(int i, int j){

        visited[i][j] = true;

        int[][] neighbor = { {-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int area = 1;
        for (int k = 0; k < 4; k++) {
            int x = i + neighbor[k][0];
            int y = j + neighbor[k][1];
            if(inArea(x, y) && !visited[x][y] && graph[x][y] == 1)
                area += dfs(x, y);
        }
        return area;
    }

    private int bfs(int i, int j){

        visited[i][j] = true;

        int[][] neighbor = { {-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int area = 1;

        Queue<Integer> queueX = new LinkedList<>();
        Queue<Integer> queueY = new LinkedList<>();
        queueX.add(i);
        queueY.add(j);

        while (!queueX.isEmpty()){
            int x = queueX.remove();
            int y = queueY.remove();

            for (int k = 0; k < 4; k++) {
                int nextX = x + neighbor[k][0];
                int nextY = y + neighbor[k][1];
                if(inArea(nextX, nextY) && !visited[nextX][nextY] && graph[nextX][nextY] == 1) {
                    area++;
                    visited[nextX][nextY] = true;
                    queueX.add(nextX);
                    queueY.add(nextY);
                }
            }
        }
        return area;
    }

    private boolean inArea(int x, int y){
        return (x >= 0 && x < graph.length && y >= 0 && y < graph[0].length);
    }

}
