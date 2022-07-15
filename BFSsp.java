// package DSA-Good-Questions.Graphs;

import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
public class BFSsp {
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
        void bfs(int src, int dest){
            // In Java Queue is a collection that is implemented with an LL
            Queue<Integer> q = new LinkedList<>();
            // Maintaining the bool type visited array to check which nodes have been visited
            Boolean[] visited = new Boolean[V];
            // An arraay to maintain the distance
            int[] dist = new int[V];
            // Maintaining a parent array for traversal through backtraking
            int[] parent = new int[V];
            Arrays.fill(visited, false);
            for(int i=0;i<V;i++){
                parent[i] = -1;
                dist[i] = 0;
            }

            // Populating the values for the source
            q.add(src);
            visited[src]=true;
            parent[src] = src;
            dist[src] = 0;
            // While there are still elements in the queue
            while(!q.isEmpty()){

                // Remove the element at the front end of the container which has been visited
                int curr=q.poll();
                // System.out.println(curr);

                // For the neighbors of the current element
                for(int nbrs:list[curr]){
                    // If the neighbor has not yet been visited
                    if(!visited[nbrs]){
                        // Add it to the queue
                        q.add(nbrs);
                        // Add the Parent of nbrs
                        parent[nbrs]=curr;
                        // Update the distance of the nbrs node
                        dist[nbrs]=dist[curr]+1;
                        // Mark the neighbor as visited
                        visited[nbrs] = true;
                    }

                }


            }

            //print the shortest distance
            for(int i=0;i<V;i++){
                System.out.println("Shortest dist to " + i + " is " + dist[i]);
            }

            // Print the Path Traversals for each Node
            
            if(dest!=-1){
                int temp=dest;
                while(temp!=src){
                    // Start from dest
                    // Temp will traverse all the parents
                    // Till temp will reach the source node
                    System.out.print(temp + " -- ");
                    temp = parent[temp];
                }
            }
            System.out.println(src);
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
        g.bfs(1,6);

    }
}
