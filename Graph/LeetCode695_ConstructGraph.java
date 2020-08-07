package LeetCode;

import java.util.HashSet;

public class LeetCode695_ConstructGraph {


    private boolean[] visited;
    private HashSet<Integer>[] graph;
    private int R, C;
    private int[][] grid;
    int[][] neighbor = { {-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int maxAreaOfIsland(int[][] grid) {

        R = grid.length;
        if(R == 0) return 0;
        C = grid[0].length;
        if(C == 0) return 0;

        this.grid = grid;

        graph = constructGraph();
        visited = new boolean[graph.length];

        int maxArea = 0;
        for (int v = 0; v < graph.length; v++) {
            int x = v / C, y = v % C;
            if(!visited[v] && grid[x][y] == 1){
                maxArea = Math.max(maxArea, dfs(v));
                if (maxArea >= (graph.length - v))
                    return maxArea;
            }
        }
        return maxArea;
    }

    private int dfs(int v){

        visited[v] = true;
        int area = 1;
        for (int w: graph[v]){
            if(!visited[w])
                area += dfs(w);
        }


        return area;
    }

    private HashSet<Integer>[] constructGraph(){

        HashSet<Integer>[] g = new HashSet[R*C];
        for (int i = 0; i < g.length; i++)
            g[i] = new HashSet<>();

        for (int v = 0; v < g.length; v++) {
            int x = v / C, y = v % C;
            if(grid[x][y] == 1){
                for (int d = 0; d < 4; d++) {
                    int nextX = x + neighbor[d][0];
                    int nextY = y + neighbor[d][1];
                    if(inArea(nextX, nextY) && grid[nextX][nextY] == 1) {
                        int next= nextX * C + nextY;
                        g[v].add(nextX * C + nextY);
                        g[next].add(v);
                    }
                }
            }
        }
        return g;
    }
    private boolean inArea(int x, int y){
        return (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length);
    }
}
