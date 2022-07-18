// package DSA-Good-Questions.Graphs;
import java.util.*;
import java.io.*;

public class o4Bipartite {

    static boolean dfsHelper(ArrayList<Integer>[] graph,int node, int[] visited, int parent, int color){
        // On the Node
        // Whatever the color has been passed as an arg, give it that
        visited[node]=color;
        for(int nbr:graph[node]){
            if(visited[nbr]==0){
                // If the Neighbor has not yet been visited
                // Call the dfs function and colour it in a different color with curr Node as parent in the call
                boolean recurseCall=dfsHelper(graph,nbr,visited,node,3-color);
                if(!recurseCall){
                    return false;
                }
            }
            else if(nbr!=parent && color==visited[nbr]){
                // If the nbr is not the parent and the color is same as the nbr then it is not possible to have a Bipartite graph
                return false;
            }
        }


        return true;

    }

    static boolean dfs(ArrayList<Integer>[] graph, int N){
        int[] visited=new int[N];
        int color=1;
        // The second color will be 3-1 -> 2
        boolean ans = dfsHelper(graph,0,visited,-1,color);
        for(int i=0;i<N;i++){
            System.out.println(i + " - Color " + visited[i]);
        }

        return ans;

     }

    public static void main(String[] args) {
        

        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt(), M = scn.nextInt();

        ArrayList<Integer>[] graph = new ArrayList[N];
        for(int i = 0; i < N; i++){
            graph[i] = new ArrayList<>();
        }

        while(M-- > 0){
            int x = scn.nextInt(), y = scn.nextInt();

            graph[x].add(y);
            graph[y].add(x);

        }

        //BFS or DFS, by coloring the nodes at each step (current node has color 1, nbr should have a color 2)
        if(dfs(graph,N)){
            System.out.println("Yes its bipartite");
        }
        else{
            System.out.println("Not bipartite");
        }
    }
    
}


/*
 * Leetcode Solution
 */
class Solution {
    public boolean isBipartite(int[][] graph) {
        // Graph Colouring Question
        // No edges between vertices of same colour
        // All adjacent connected vertices need to be coloured differently
        // Odd nodes cycle will be not bipartite
        int n=graph.length;
        int[] visited=new int[n];
        // int[] color=new int[n];
        int parent=-1;
        int color=1;
        // Second color will be colour 3- color -> 3-1 -> 3-2 -> 3-1 ......
        // There will be as many nodes as many rows in the graph as their internal elements will be their neighbors
        boolean ans=dfsHelper(graph,0,visited, parent,color);
        return ans;
        
        
    }
    
    public static boolean dfsHelper(int[][] graph, int node, int[] visited, int parent, int color){
        visited[node]=color;
        for(int nbr:graph[node]){
            if(visited[nbr]==0){
                // If the node has not been visited
                // Call the dfs to traverse the nodes recursively
                boolean recurseCall=dfsHelper(graph,nbr,visited,node,3-color);
                if(!recurseCall){
                    return false;
                }
            }
            else if(nbr!=parent && color==visited[node]){
                return false;
            }
        }
        return true;
    }
}