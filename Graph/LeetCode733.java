package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode733 {

    private boolean[][] visited;
    private int rows;
    private int cols;
    int[][] coor = {{1,0},{-1,0},{0,1},{0,-1}};
    private int target;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        rows = image.length;
        if(rows == 0) return image;
        cols = image[0].length;

        visited = new boolean[rows][cols];
        target = image[sr][sc];

        dfs(sr, sc, newColor, image);
        return image;
    }

    private void dfs(int sr, int sc, int newColor, int[][] image){

        visited[sr][sc] = true;
        image[sr][sc] = newColor;

        for (int i = 0; i < 4; i++) {
            int nextX = sr + coor[i][0];
            int nextY = sc + coor[i][1];
            if(inArea(nextX, nextY) && !visited[nextX][nextY] && image[nextX][nextY] == target)
                dfs(nextX, nextY, newColor, image);
        }
    }
    private void bfs(int sr, int sc, int newColor, int[][] image){

        visited[sr][sc] = true;
        image[sr][sc] = newColor;

        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        qx.add(sr);
        qy.add(sc);

        while (!qx.isEmpty()) {
            int x = qx.remove();
            int y = qy.remove();
            for (int i = 0; i < 4; i++) {
                int nextX = x + coor[i][0];
                int nextY = y + coor[i][1];
                if (inArea(nextX, nextY) && !visited[nextX][nextY] && image[nextX][nextY] == target){
                    image[nextX][nextY] = newColor;
                    visited[nextX][nextY] = true;
                    qx.add(nextX);
                    qy.add(nextY);
                }
            }
        }
    }

    private boolean inArea(int x, int y){
        return (x >= 0 && y >= 0 && x < rows && y < cols);
    }
}
