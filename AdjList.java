import java.util.*;
import java.io.*;
public class AdjList {
    static class Graph {
        // Create a Class for easy data sharing
        // The number of nodes
        int V;
        // Declare an arraylist of Integer arrays Integers  Type
        ArrayList<Integer>[] list;
        // Constructor for the Graph
        public Graph(int v){
            V=v;
            list=new ArrayList[v];
            for (int i=0;i<v;i++){
                // Each element of the list is an arrayList
                list[i]=new ArrayList<>();
            }

        }

        // Method to add Edge
        void addEdge(int src,int dest,boolean unDirected){
            list[src].add(dest);
            if(unDirected){
                list[dest].add(src);
            }
        }
        // Method to print the adjacency List

        void printAdjList(){
            for(int i=0;i<V;i++){
                System.out.print(i + " --> ");
                // Iterating over one row!
                // Enhanced for loop for elements in each List 
                for(int node: list[i]){
                    System.out.print(node + ", ");
                }

                System.out.println();
            }

        }



    }

    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0,1, true);
        g.addEdge(0,4, true);
        g.addEdge(2,1, true);
        g.addEdge(3,4, true);
        g.addEdge(4,5, true);
        g.addEdge(2,3, true);
        g.addEdge(3,5, true);
        g.printAdjList();
    }
    
}
