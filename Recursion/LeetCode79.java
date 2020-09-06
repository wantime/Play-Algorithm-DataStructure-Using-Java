public class LeetCode79 {

    boolean[][] visited;
    int rows;
    int cols;
    int[][] d = {{0,-1}, {-1,0}, {1,0}, {0,1}};

    public boolean exist(char[][] board, String word) {

        rows = board.length;
        if(rows == 0)
            return false;
        cols = board[0].length;
        if(cols == 0)
            return false;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                visited = new boolean[rows][cols];
                if(searchWord(i, j, 0, board, word))
                    return true;
            }
        }
        return false;
    }

    private boolean searchWord(int x, int y, int index, char[][] board, String word){

        if(index == word.length() - 1)
            return board[x][y] == word.charAt(index);

        if( board[x][y] != word.charAt(index))
            return false;

        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nextX = x + d[i][0];
            int nextY = y + d[i][1];
            if(inArea(nextX, nextY) && !visited[nextX][nextY] && searchWord(nextX, nextY, index+1, board, word))
                return true;
        }
        visited[x][y] = false;

        return false;
    }

    private boolean inArea(int x, int y){
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}
