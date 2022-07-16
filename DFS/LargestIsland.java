// package DSA-Good-Questions.Graphs;

import java.util.Arrays;

public class LargestIsland {

    static int dfs(int[][] matrix, boolean[][] visited, int i,int j,int m,int n){

        visited[i][j] = true;

        int cs = 1;

        int dx[] = {1,-1,0,0};
        int dy[] = {0,0,1,-1};

        for(int k=0;k<4;k++){
            int nx = i + dx[k];
            int ny = j + dy[k];

            if(nx>=0 && nx<m && ny>=0 && ny<n && matrix[nx][ny]==1 && !visited[nx][ny]){
                int subcomponent = dfs(matrix,visited,nx,ny,m,n);
                cs += subcomponent;
            }
        }
        return cs;
    }




    static int largest_island(int[][] matrix){
        //return the size of largest island in grid
        int m = matrix.length;
        int n = matrix[0].length;

        //visited matrix
        boolean[][] visited = new boolean[n][m];

        int largest = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && matrix[i][j]==1){

                    int size = dfs(matrix,visited,i,j,m,n);
                    if(size>largest){
                        largest = size;
                    }

                }

            }
        }
        return largest;
    }

    public static void main(String[] args){

        int[][] grid = {
                            {1, 0, 0, 1, 0},
                            {1, 0, 1, 0, 0},
                            {0, 0, 1, 0, 1},
                            {1, 0, 1, 1, 1},
                            {1, 0, 1, 1, 0}
                            };
        System.out.println(largest_island(grid));

    }
}


/*
 * LeetCode Solution
 */
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        // Island is 1's(Land) -- Surronded by 0's (Water)
        // int dx[4]={1,-1,0,0};
        // int dy[4]={0,0,1,-1};
        
        int max_area=0;
        int rows=grid.length;
        int cols=grid[0].length;
        boolean[][] visited=new boolean[rows][cols];
        // Looping through each element in the cell
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                max_area=Math.max(max_area,dfsArea(i,j,grid,visited) );
                
            }
        }
        return max_area;
    }
    
    public int dfsArea(int row,int col,int[][] grid,boolean[][] visited){
        // i , j are the co-ordinates
        // If the row and col or are zero or if it is out of bounds in both cases the Area returned will be 0
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length || grid[row][col]==0 || visited[row][col]){
            return 0;
        }
        visited[row][col]=true;
        // Recurse for all 4 combinations here
        return(1+ dfsArea(row+1,col,grid,visited)+ dfsArea(row-1,col,grid,visited)+ dfsArea(row,col+1,grid,visited)+ dfsArea(row,col-1,grid,visited));
        
        
    }
}
