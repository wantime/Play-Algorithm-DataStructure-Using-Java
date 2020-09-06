public class LeetCode37 {

    boolean[][] rows;
    boolean[][] cols;
    boolean[][] area;
    //  rows[i][j] 表示第i个区域（行、列）的第j个数字是否已经填入
    public void solveSudoku(char[][] board) {

        rows = new boolean[9][10];
        cols = new boolean[9][10];
        area = new boolean[9][10];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                if(c != '.'){
                    rows[i][c-'0'] = true;
                    cols[j][c-'0'] = true;
                    area[(i / 3) * 3 + j / 3][c-'0'] = true;
                }
            }
        }
        fillNum(board, 0, 0);
    }
    private boolean fillNum(char[][] board, int x, int y){

        if(y == 9){
            y = 0;
            x ++;
            if(x == 9)
                return true;
        }

        if(board[x][y] == '.'){
            for (int i = 1; i <= 9; i++) {
                if(!rows[x][i] && !cols[y][i] && !area[(x/3)*3+y/3][i]){

                    board[x][y] = (char)(i +'0');

                    rows[x][i] = true;
                    cols[y][i] = true;
                    area[x/3*3+y/3][i] = true;

                    if(fillNum(board, x, y+1))
                        return true;
                    board[x][y] = '.';
                    rows[x][i] = false;
                    cols[y][i] = false;
                    area[(x/3)*3+y/3][i] = false;
                }
            }
        }
        else if (fillNum(board, x, y+1))
            return true;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        //System.out.println(board[0][0] - '0');
        new LeetCode37().solveSudoku(board);

    }
}
