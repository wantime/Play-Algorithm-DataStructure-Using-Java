import java.util.ArrayList;
import java.util.List;

public class LeetCode417 {

    private List<List<Integer>> res;
    private int m;
    private int n;
    private boolean[][] pacific;
    private boolean[][] atlantic;
    int[][] coor = {{1,0},{-1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {

        res = new ArrayList<>();

        n = matrix.length;
        if(n == 0)
            return res;
        m = matrix[0].length;
        pacific = new boolean[n][m];
        atlantic = new boolean[n][m];

        //对于一个格子matrix[i][j]
        //go 太平洋 is true
        // go 大西洋 is true
        // res add list
        for (int i = 0; i < n; i++) {
            dfs(matrix, pacific, i, 0);
            dfs(matrix, atlantic, i, m-1);
        }

        for (int j = 0; j < m; j++) {
            dfs(matrix, pacific, 0, j);
            dfs(matrix, atlantic, n-1, j);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(pacific[i][j] && atlantic[i][j]){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                }
            }
        }
        return res;
    }

    private void dfs(int[][] matrix, boolean[][] visited, int x, int y){
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + coor[i][0];
            int newY = y + coor[i][1];
            if (inArea(newX, newY) && !visited[newX][newY] && matrix[newX][newY] >= matrix[x][y])
                dfs(matrix, visited, newX, newY);
        }
    }

    private boolean inArea(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}
