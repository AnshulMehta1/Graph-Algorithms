// package DSA-Good-Questions.Graphs;
import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    static class Graph{
        int V;
        // ArrayList of Integer arrays
        ArrayList<Integer>[] list;

        // Constructor
        public Graph(int v){
            V = v;
            // Initializing the ArrayList of Arrays, that can store V arrays
            list = new ArrayList[v];
            for(int i = 0; i < v; i++){
                // For each array of the arraylist, initialize a new arraylist
                list[i] = new ArrayList<>();
            }


        }

        void addEdge(int i, int j, boolean unDirected){
            list[i].add(j);
            if(unDirected)
                list[j].add(i);
        }

        // Breadth First Search Method code
        void bfs(int src){
            // In Java Queue is a collection that is implemented with an LL
            Queue<Integer> q = new LinkedList<>();
            // Maintaining the bool type visited array to check which nodes have been visited
            Boolean[] visited = new Boolean[V];
            Arrays.fill(visited, false);
            q.add(src);
            visited[src]=true;
            // While there are still elements in the queue
            while(!q.isEmpty()){

                // Remove the element at the front end of the container which has been visited
                int curr=q.poll();
                System.out.println(curr);
                // For the neighbors of the current element
                for(int nbrs:list[curr]){
                    // If the neighbor has not yet been visited
                    if(!visited[nbrs]){
                        // Add it to the queue
                        q.add(nbrs);
                        // Mark the neighbor as visited
                        visited[nbrs] = true;
                    }

                }


            }
        }
    }





    public static void main(String[] args){
        Graph g = new Graph(7);
        g.addEdge(0,1, true);
        g.addEdge(1,2, true);
        g.addEdge(2,3, true);
        g.addEdge(3,5, true);
        g.addEdge(5,6, true);
        g.addEdge(4,5, true);
        g.addEdge(0,4, true);
        g.addEdge(3,4, true);
        g.bfs(1);

    }
    
}
