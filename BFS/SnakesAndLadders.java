// package DSA-Good-Questions.Graphs;
import java.util.*;
import java.io.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


class Pair{
    // A bunch of getter setter methods
    private int first;
    private int second;
    public int getFirst(){
        return first;
    }
    public int getSecond(){
        return second;

    }
    public void setFirst(int num){
        first = num;
    }

    public void setSecond(int num){
        second = num;
    }
}


public class SnakesAndLadders {

    static class Graph{
        int V;
        // Declaring arraylist of arraylist
        ArrayList<Integer>[] list;
        // Construtor
        public Graph(int v){
            V=v;
            // Initializing arraylist of Arralist
            list = new ArrayList[v];
            for(int i=0;i<v;i++){
                list[i]=new ArrayList<>();

            }
        }
        void addEdge(int i, int j){
            list[i].add(j);
        }


        int minCostBFS(int src, int dest){
            Queue<Integer> q = new LinkedList<>();
            boolean[] visited = new boolean[V];
            int[] dist = new int[V];
            Arrays.fill(visited, false);

            q.add(src);
            visited[src] = true;
            dist[src] = 0;

            while(!q.isEmpty()){
                int f = q.poll();

                for(int nbr : list[f]){
                    if(!visited[nbr]){
                        q.add(nbr);
                        visited[nbr] = true;
                        dist[nbr] = dist[f] + 1;
                    }
                }
            }
            return dist[dest];
        }
    }

    public static int min_dice_throws(int n, ArrayList<Pair> snakes, ArrayList<Pair> ladders){
        int[] board=new int[n+1];
        // Board to Graph Conversion

        for(Pair sp: snakes){
            int s = sp.getFirst();
            int e = sp.getSecond();
            board[s] = e - s;
        }

        return 1;
    }
    
    public static void main(String[] args) {
        
    }
    
}


// int n= board.length;
// int steps=0;
// Queue<Integer> q= new LinkedList<>();
// boolean visited[][] = new boolean [n][n];
// // Add the first element of  the grid
// q.add(1);
// // The last row and first col is 1
// visited[n-1][0]=true;
// // Till the queue is empty
// while(!q.isEmpty()){
//     int size=q.size();
//     for(int i=0;i<size;i++){
//         int curr=q.poll();
//         // If the curr elemennt is target element , return steps
//         if(curr==n*n){
//             return steps;
//         }
//         // If not then keep calculating the steps
//         // Simulate dice throws
//         for(int d=1;d<=6;d++){
//             // If it oversteps beyond 100
//             if(d+curr>=n*n){
//                 break;
//             }
//             // Find the position 
//             int pos[]=FindCoordinates(d+curr,n);
//             int row=pos[0];
//             int col=pos[1];;
//             // If the r/c has beenn visited continue the  iteration
//             if(visited[row][col]==true){
//                 continue;
//             }
//             // Otherwise
//             visited[row][col]=true;
//             // Now checkk for the valeu at row/col
//             // If it is -1, move to d+curr as normal
            
//             if(board[row][col]==-1){
//                 q.add(d+curr);
//             }
//             else{
//                 q.add(board[row][col]);
//             }
//             // Any Other value meanns snake/ladder -> then go to that
//         }
        
        
//     }
//     steps++;
// }

// return -1;
