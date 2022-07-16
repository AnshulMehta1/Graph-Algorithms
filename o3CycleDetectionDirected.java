// package DSA-Good-Questions.Graphs;
import java.util.*;
import java.io.*;

public class o3CycleDetectionDirected {

    static class Graph{
        int V;
        ArrayList<Integer>[] list;
        // Constructor
        public Graph(int v) {
            this.V = v;
            list=new ArrayList[v];
            for(int i=0;i<v;i++){
                list[i]=new ArrayList<>();
            }
        }

        void addEdge(int src, int dest){
            // Since it is directed let's only go with the 1-D Edges
            list[src].add(dest);
        }

        boolean dfs(int node, boolean[] visited, boolean[] stack ){
            // A stack like data structure is maintained with an array here
            visited[node]=true;
            stack[node]=true;
            // We already have the curr node so jump straight into DFS
            for(int nbrs: list[node]){
                // Visited and in the stack
                if(stack[nbrs]){
                    // If the node is present in the Stack
                    return true;
                    // This will be aa backedge and a neighbour
                }
                else if(!visited[nbrs]){
                    boolean nbrFoundCycle=dfs(nbrs,visited,stack);
                    if(nbrFoundCycle){
                        return true;
                    }

                }
            }
            // While backtracking mark the nodes unvisited in the stack
            stack[node]=false;
            // Tentative about this
            visited[node]=false;
            return false;
        }

        boolean contains_cycle(){
            boolean[] visited = new boolean[V];
            boolean[] stack = new boolean[V];

            for(int i=0;i<V;i++){
                if(!visited[i]){
                    if(dfs(i,visited,stack)){
                        return true;
                    }
                }

            }
            return false;
        }
    }
    public static void main(String[] args) {
        
        Graph g = new Graph(3);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,0);

        System.out.println(g.contains_cycle());
        
    }
    
}
