// package DSA-Good-Questions.Graphs;
import java.util.*;
import java.io.*;
public class rottenOranges {
    public static void main(String[] args) {
        
    }

    class Solution {
    
        // Here graph question is not an adjacency matrix nor a adjacency list
        // This is a grid like an implicit graph
        // First Level all the neigbhours of rotten oranges will become rot
        // This is like a multi-source BFS
        // In one minute neighbours will rot, next minute their neighbours will rot .. 
        // The only trick is learning multi-source dynamic BFS here.
        
        // Algorithm
        // Take all the positions of the rotten orange 
        // Then their neighbours will be rotten
        // For Multi Soource add them all to the queue initially
        // So all will initially go into the queue
        // Their neigbhours will get in step wise fashion only
        // If visited, it will save time
        
        
        // For Stroing coordinates it can be a good way to have a pair class
         class Pair{
            int x;
            int y;
            Pair(int x, int y){
                this.x = x;
                this.y = y;
            }
        }
        
        
        public int orangesRotting(int[][] grid) {
        
            // The rot spreads - in simple terms
            // Return the minimum time there is no fresh orange left.
            
            if(grid==null || grid.length==0){
                return 0;
            }
            int rows=grid.length;
            int cols=grid[0].length;
            // A queue of the type of Pair Objects
            Queue<Pair> q = new LinkedList<>(); 
            int oranges=0;
            // First get the number of oranges in the grid
            for(int i=0;i<rows;i++){
                for(int j=0;j<cols;j++){
                    if(grid[i][j]==1 || grid[i][j]==2){
                        oranges++;
                    }
                    if(grid[i][j]==2){
                        // For Rotten Oranges  - Add their initial Index into the queue
                        q.add(new Pair(i, j));
                    }
                }
            }
            if(oranges==0){
                return 0;
            }
            // Initialize the time
            int minutes=0;
            // Stores the total count for rotten oranges
            int currOrangeCount=0;
                
            // 4 directions - Didn't Know this
            // Figure the reason
            int[] dx = {0, 0, 1, -1};
            int[] dy = {1, -1, 0, 0};
            
            while(!q.isEmpty()){
                int size=q.size();
                currOrangeCount+=size;
               for(int i=0; i<size; i++){
                   Pair curr=q.poll();
                   for(int j=0;j<4;j++){
                       // Check for all 4 directions according to the all 4 p&c additions from dx and dy arr.
                       int x=curr.x+dx[j];
                       int y=curr.y+dy[j];
                       
                       if(x<0 || y<0 || x>=rows || y>=cols || grid[x][y]!=1){
                           continue;
                       }
                       else{
                           // Rot the oragne
                           grid[x][y]=2;
                           // Add them to the rotten qeueue
                           q.add(new Pair(x, y));
                           // Don't worry how it happens, have faith in the process
                       }
                   }
               } 
                 if(q.size()!=0){
                    minutes++;
                }
               
            }
            // if total no. of rotten oranges == total no.of oranges initially in grid then answer is minute
            return currOrangeCount==oranges ? minutes : -1;   
        }
    }
}
