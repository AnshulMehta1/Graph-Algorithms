// package DSA-Good-Questions.Graphs;
import java.util.*;
import java.io.*;
/*
 * LeetCode Solution for Keys and Rooms
 * Check Notes while revising DFS
 */
public class KeysandRooms {

    class Solution {
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            
            // DFS Concept 
            // Nested keys -> Key in room zero opens 1, key in room 1 opens 2, Key in room 2 opens 3 and so on. 
            // With this DFS if all the nodes are visited then true or else false.
            // Some portion of a Graph can be disconnected as well - check thorugh DFS
            // So what I am given is an adjacency list in this case
            // Apply simple DFS on this adjacency list and it is completed.
            int n=rooms.size();
            boolean[] visited=new boolean[n];
            for(int i=0;i<rooms.size();i++){
                if(!visited[i]){
                    dfsHelper(rooms,i,visited);
                    break;
                }
            }
            for (boolean ele: visited){
                if(ele==false){
                    return false;
                }
                
            }
            // Return true otherwise
            return true;
            
            
        }
        
        public void dfsHelper(List<List<Integer>> rooms,int src,boolean[] visited){
            // boolean[] visited=new boolean[rooms.size()];
            visited[src]=true;
            // For all the neighbors aka elements in the adjacency list
            for(int nbrs:rooms.get(src)){
                if(!visited[nbrs]){
                    dfsHelper(rooms,nbrs,visited);
                }
            }
        }
    }
    public static void main(String[] args) {
        
    }
    
}
