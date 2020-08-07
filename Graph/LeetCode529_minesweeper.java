package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode529_minesweeper {

    private int rows;
    private int cols;
    private boolean[][] visited;
    private int[][] d = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0,-1}, {-1, -1}};
    private char[][] board;

    public char[][] updateBoard(char[][] board, int[] click) {

        rows = board.length;
        if(rows == 0) return board;
        cols = board[0].length;
        if(cols == 0) return board;

        this.board = board;

        int x = click[0];
        int y = click[1];

        if(board[x][y] == 'M'){
            board[x][y] = 'X';
            return board;
        }
        visited = new boolean[rows][cols];

        bfs(x, y);
        // dfs(x, y)
        return board;
    }

    public void bfs(int x, int y){

        visited[x][y] = true;
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();

        qx.add(x);
        qy.add(y);
        while (!qx.isEmpty()){
            x = qx.remove();
            y = qy.remove();

            int num = detect(x, y);
            if(num > 0){
                board[x][y] = (char)(num + '0');
            }
            else {  //  num == 0
                board[x][y] = 'B';
                for (int i = 0; i < 8; i++) {
                    int nextX = x + d[i][0];
                    int nextY = y + d[i][1];
                    if (inArea(nextX, nextY) && !visited[nextX][nextY] && board[nextX][nextY] == 'E') {
                        visited[nextX][nextY] = true;
                        qx.add(nextX);
                        qy.add(nextY);
                    }
                }
            }
        }
    }

    private void dfs(int x, int y){

        visited[x][y] = true;

        int num = detect(x, y);
        if(num > 0){
            board[x][y] = (char)(num + '0');
            return;
        }
        else {  //  num == 0
            //  代表该方块的领域也可以被翻开
            for (int i = 0; i < 8; i++) {
                int nextX = x + d[i][0];
                int nextY = y + d[i][1];
                if (inArea(nextX, nextY) && !visited[nextX][nextY] && board[nextX][nextY] == 'E') {
                    dfs(nextX, nextY);
                }
            }
            board[x][y] = 'B';
        }
    }
    private boolean inArea(int x, int y){
        return (x >= 0 && y >= 0 && x < rows && y < cols);
    }

    private int detect(int x, int y){
        int numOfMine = 0;
        for (int i = 0; i < 8; i++) {
            int nextX = x + d[i][0];
            int nextY = y + d[i][1];
            if (inArea(nextX, nextY) && board[nextX][nextY] == 'M')
                numOfMine++;
        }
        return numOfMine;
    }

    public static void main(String[] args) {
        char[][] board = {
        {'E','E','E','E','E'},
        {'E','E','M','E','E'},
        {'E','E','E','E','E'},
        {'E','E','E','E','E'}};
        int[] click = {3,0};
        new LeetCode529_minesweeper().updateBoard(board, click);
    }
}
