// package DSA-Good-Questions.Graphs;
import java.util.*;
import java.io.*;

public class MinDegreeofaConnTrio {

    public int minTrioDegree(int n, int[][] edges) {
        
        int ans=Integer.MAX_VALUE;
        int[] degree=new int[n+1];
        int grid[][] =new int[n+1][n+1];
        for(int i=0;i<edges.length;i++){
            // Get the first node in the pair
            int x= edges[i][0];
            // Get the second node in the pair
            int y=edges[i][1];
            // Increase the degree of the 1st Node
            degree[x]++;
            // Increase the degree of the second Node
            degree[y]++;
            // Set the edge from Node x to Node y as 1
            grid[x][y]++;
            // Set the edge from Node y to x as 1
            grid[y][x]++;
            
        }
        // Now we have the edges and degrees figured out for each node in the graph
        // Now we need to check for the trio condition 
        for(int i=0;i<=n;i++){
            for (int j=i+1;j<=n;j++){
                for(int k=j+1;k<=n;k++){
                    // The condition for trio is that all of them are connected
                    if(grid[i][j]==1 && grid[j][k]==1 && grid[i][k]==1){
                        // For trio each degree 2, minimum subtracted must be 6
                         ans=Math.min(ans,degree[i]+degree[j]+degree[k]-6);
                    }
                    
                }
            }
        }
       if (ans == Integer.MAX_VALUE) {
        return -1;
        }
    
    return ans;

    }
    public static void main(String[] args) {
        
    }
}
