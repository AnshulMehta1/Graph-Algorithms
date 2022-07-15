// package DSA-Good-Questions.Graphs;
import java.util.*;
import java.io.*;

public class MaximalNetworkRank {
    
    public int maximalNetworkRank(int n, int[][] roads) {
         // A simple approach is to calculate the degrees for each of the nodes
        // Then calculate the sum of each pairs and return the maximum sum
        // An array to store the degree of all the nodes
        int degree[]=new int[n];
        int edges [][] = new int [n][n];
        for(int i=0;i<roads.length;i++){
            // Get the first node in the pair
            int x= roads[i][0];
            // Get the second node in the pair
            int y=roads[i][1];
            // Increase the degree of the 1st Node
            degree[x]++;
            // Increase the degree of the second Node
            degree[y]++;
            // Set the edge from Node x to Node y as 1
            edges[x][y]++;
            // Set the edge from Node y to x as 1
            edges[y][x]++;
            
        }
        
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                ans=Math.max(degree[i]+degree[j]-edges[i][j],ans);
            }
        }
        
    
        return ans;
      
    }
    public static void main(String[] args) {
        
    }
}
