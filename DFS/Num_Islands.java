
public class Num_Islands{
    public static void main(String[] args) {
        
    }
}

class Solution {
	public int numIslands(char[][] grid) {
		int count = 0;

		for (int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[i].length; j++) {
				if(grid[i][j] == '1') {
					count += 1;
					callDFS(grid, i, j);
				}
			}
		}
		return count;
	}
	
	public void callDFS(char[][] grid, int i, int j) {
		if(i < 0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        callDFS(grid, i+1, j); // down
        callDFS(grid, i-1, j); // up
        callDFS(grid, i, j+1); // right
        callDFS(grid, i, j-1); // left
    }
		
}
    
    
/*
callDFS(grid, 0, 0):
    grid[0][0] = 0
    callDFS(grid, 1, 0):
         grid[1][0] = 0
         callDFS(grid, 2, 0): return    // bottom
         callDFS(grid, 0, 0): return    // up
         callDFS(grid, 1, -1): return   // right
         callDFS(grid, 1, 1):           // left
              grid[1][1] = 0
              callDFS(grid, 2, 1): return
              callDFS(grid, 0, 1):
                  grid[0][1] = 0
                  callDFS(grid, 1, 1): return
                  callDFS(grid, -1, 1): return
                  callDFS(grid, 0, 0): return
                  callDFS(grid, 0, 2): return
              callDFS(grid, 1, 0): return
              callDFS(grid, 1, 2): return 
callDFS(grid, -1, 0): return
callDFS(grid, 0, -1): return
callDFS(grid, 0, 1): return
                      
                      
                      
            
callDFS(grid, 2, 2):
    grid[2][2] = 0
    callDFS(grid, 3, 2): return
    callDFS(grid, 1, 2): return
    callDFS(grid, 2, 1): return
    callDFS(grid, 2, 3): return
callDFS(grid, 1, 2): return
callDFS(grid, 2, 1): return
callDFS(grid, 2, 3): return
        
callDFS(grid, 3, 3):
    grid[3][3] = 0
    callDFS(grid, 4, 3): return
    callDFS(grid, 2, 3): return
    callDFS(grid, 3, 2): return
    callDFS(grid, 3, 4):
        grid[3][4] = 0
        callDFS(grid, 4, 4): return
        callDFS(grid, 2, 4): return
        callDFS(grid, 3, 3): return
        callDFS(grid, 3, 5): return
callDFS(grid, 2, 3): return
callDFS(grid, 3, 2): return
callDFS(grid, 3, 4): return
*/
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
