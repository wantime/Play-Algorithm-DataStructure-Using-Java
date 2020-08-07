package LeetCode;

import com.sun.scenario.effect.impl.state.LinearConvolveKernel;
import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode130 {
    private int m;
    private int n;
    private boolean[][] visited;

    int[][] coor = {{1,0},{-1,0},{0,1},{0,-1}};

    public void solve(char[][] board) {
        m = board.length;
        if(m == 0)
            return;
        n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            if(!visited[i][0] && board[i][0] == 'O')
                bfs(board, i, 0);
            if(!visited[i][n-1] && board[i][n-1] == 'O')
                bfs(board, i, n-1);
        }

        for (int i = 0; i < n; i++) {
            if(!visited[0][i] && board[0][i] == 'O')
                bfs(board, 0, i);
            if(!visited[m-1][i] && board[m-1][i] == 'O')
                bfs(board, m-1, i);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == 'O' && !visited[i][j])
                    board[i][j] = 'X';
            }
        }
    }
    private void dfs(char[][] matrix, int x, int y){
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + coor[i][0];
            int newY = y + coor[i][1];
            if (inArea(newX, newY) && !visited[newX][newY] && matrix[newX][newY] == 'O')
                dfs(matrix, newX, newY);
        }
    }
    private void bfs(char[][] matrix, int x, int y){
        visited[x][y] = true;
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();

        qx.add(x);
        qy.add(y);

        while (!qx.isEmpty()){

            x = qx.remove();
            y = qy.remove();
            for (int i = 0; i < 4; i++) {
                int nextX = x + coor[i][0];
                int nextY = y + coor[i][1];
                if(inArea(nextX, nextY) && !visited[nextX][nextY] && matrix[nextX][nextY] == 'O'){
                    qx.add(nextX);
                    qy.add(nextY);
                    visited[nextX][nextY] = true;
                }
            }
        }
    }

    private boolean inArea(int x, int y){
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
