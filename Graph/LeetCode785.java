package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode785 {

    private boolean[] visited;
    private int[] colors;

    public boolean isBipartite(int[][] graph) {

        visited = new boolean[graph.length];
        colors = new int[graph.length];

        for(int v = 0; v < graph.length; v ++){
            if(!visited[v])
                if(!dfs(v, 0, graph))
                    return false;
        }
        return true;
    }

    private boolean dfs(int v, int color,int[][] graph){

        visited[v] = true;
        colors[v] = color;

        for(int i = 0; i < graph[v].length; i++){

            int w = graph[v][i];
            if(!visited[w]){
                if(!dfs(w, 1 - color, graph))
                    return false;
            }
            else{   // visited[w] == true;
                if(colors[w] == colors[v])
                    return false;
            }
        }
        return true;

    }

    private boolean bfs(int s,int[][] graph){

        visited[s] = true;
        colors[s] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        while (!queue.isEmpty()){
            int v = queue.remove();
            visited[v] = true;
            for (int w: graph[v]){
                if(!visited[w]){
                    visited[w] = true;
                    colors[w] = 1 - colors[v];
                    queue.add(w);
                }
                else if(colors[w] == colors[v])
                    return false;
            }
        }
        return true;
    }
}
