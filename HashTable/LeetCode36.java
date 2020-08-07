public class LeetCode36 {

    public boolean isValidSudoku(char[][] board) {
        //  需要三个二维数组来判断是否满足要求
        //  rows
        boolean[][] rows = new boolean[9][9];//[i][j]表示第i行第j个数字是否已存在
        // cols
        boolean[][] cols = new boolean[9][9];//[i][j]表示第i列第j个数字是否已经存在
        //  matrix
        boolean[][] matrix = new boolean[9][9];//[i][j]表示第i个方块内第j个数字是否存在
        //  如何判断

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == '.')
                    continue;
                int num = board[i][j] - '1';
                int blockIndex = i/3 * 3 + j/3;
                //  i = 0,1,2
                //  i = 3,4,5
                //  i = 6,7,8
                if(cols[i][num] || rows[j][num] || matrix[blockIndex][num])
                    return false;
                else
                    cols[i][num] = rows[j][num] = matrix[blockIndex][num] = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 9; i++) {
            System.out.println();
            for (int j = 0; j < 9; j++) {
                System.out.print(i/3 * 3 + j/3);
                System.out.printf("--");
            }
        }
    }
}
