// package DSA-Good-Questions.Graphs;
import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DFS {

    static class Graph{
        int V;
        // Declaring and ArrayList of Arraylist
        ArrayList<Integer>[] list;
        public Graph(int v){
            V=v;
            list=new ArrayList[v];
            for(int i=0;i<v;i++){
                list[i]= new ArrayList<>();

            }
        }

        void addEdge(int src, int dest, boolean unDirected){
            list[src].add(dest);
            if(unDirected){
                list[dest].add(src);
            }
        }
        // Helper function for dfs
        void dfsHelperfn(int src, boolean[] visited){
            // Mark the source as true for visited array
            visited[src]=true;
            System.out.print(src + " ");
            for (int nbrs:list[src]){
                // Check for the neighbours
                if(!visited[nbrs]){
                    // If the neighbour is not visited
                    // Recursive Call maari de with the neighbor as a source
                    dfsHelperfn(nbrs, visited);


                }
            }


        }

        void dfs(int src){
            boolean[] visited=new boolean[V];
            // Initially all are unvisited
            Arrays.fill(visited, false);
            // Then make the call
            dfsHelperfn(src, visited);
            // Other recursive calls will be made in the Helper function
        }

    }


    public static void main(String[] args) {
        Graph g = new Graph(7);
        g.addEdge(0,1, true);
        g.addEdge(1,2, true);
        g.addEdge(2,3, true);
        g.addEdge(3,5, true);
        g.addEdge(5,6, true);
        g.addEdge(4,5, true);
        g.addEdge(0,4, true);
        g.addEdge(3,4, true);
        g.dfs(1);
        
    }
    
}
