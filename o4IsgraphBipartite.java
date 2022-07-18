// package DSA-Good-Questions.Graphs;
import java.util.*;
import java.io.*;
// Consists of both BFS and DFS Solutions

public class o4IsgraphBipartite {

    public static void main(String[] args) {
        
    }
    
}

/*
 * DFS Solution
 */

class SolutionDFS {
    
    public boolean isBipartite(int[][] graph) {
        // Graph Colouring Question
        // No edges between vertices of same colour
        // All adjacent connected vertices need to be coloured differently
        // Odd nodes cycle will be not bipartite
        int n=graph.length;
        // Initially fill the Arrays with 1
        int[] color=new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++){
            if(color[i]==-1){
                if(!dfsHelper(i,graph,color)){
                    return false;
                }
            }
        }
        
        return true;
        
        
        
    }
    
    private boolean dfsHelper(int node, int[][] graph, int[] color)
    {        
        if(color[node]==-1) color[node]=1;
        
        for(int nbr : graph[node])
        {
            if(color[nbr]!=-1){
                if(color[node] == color[nbr]){
                    return false;
                }
            }
            else{
                color[nbr] = 1-color[node];
                
                if(!dfsHelper(nbr, graph,color)) {
                    return false;
                }
            }
        }
        return true;
    }
    
   
}
/*
 * BFS Solution
 */


class SolutionBFS {
    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        int[] colors = new int[len];
        
        for (int i = 0; i < len; i++) {
            if (colors[i]  == 1 || colors[i]  == -1) continue;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            colors[i] = 1;  
            
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int next : graph[cur]) {
                    if (colors[next] == 0) {          
                        colors[next] = -colors[cur];  
                        queue.add(next);
                    } 
                    
                    if(colors[next] == colors[cur])  return false;
                    
                }
            }
        }
        
        return true;
    }
}