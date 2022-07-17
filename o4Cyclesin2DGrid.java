// package DSA-Good-Questions.Graphs;
import java.util.*;
import java.io.*;

public class o4Cyclesin2DGrid {
    
}

class Solution {

    public boolean containsCycle(char[][] grid) {
        // The value of each cell in the cycle should match
        // Do BFS/DFS and if we reach the start cell then there is a cycle
        // Traverse only the nodes with the samme values
        // Will need to maintain a visited array
        int rows=grid.length;
        int cols=grid[0].length;
        boolean[][] visited=new boolean[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                // If the cell is not yet visited and a cycle is detected 
                if(!visited[i][j]){
                    if(CycleDetected(grid, i, j, visited, -1, -1)){
                        return true;
                    }
                }
            }
        }
        return false;
        
        
    }
    
    public boolean CycleDetected(char[][] grid,int i, int j, boolean[][] visited, int prevI, int prevJ){
        // Normal Flow
        visited[i][j]=true;
        // int[] dx = {0, 0, 1, -1};
        // int[] dy = {1, -1, 0, 0};
        int[][] dirs = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
        for(int[] dir: dirs){
            int x = i+dir[0];
            int y = j+dir[1];
            // Traversal Conditions
            if(x<0 || y<0 || x>=grid.length || y>=grid[0].length || grid[x][y]!=grid[i][j]){
                continue;
            }
            if(x == prevI && y == prevJ){
                continue;
            }
            if(visited[x][y]){
                return true;
            }
            if(CycleDetected(grid, x, y, visited, i, j)){
                return true;
            }
            
        }
        return false;
        
    }
}
