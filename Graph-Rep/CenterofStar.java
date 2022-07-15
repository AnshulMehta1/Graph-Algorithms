// package DSA-Good-Questions.Graphs;
import java.util.*;
import java.io.*;


public class CenterofStar {

    public static int FindCenter(int[][] edges){
        // A two dimensional Matrix Type structure is given in this case as a graph
        // Which means that in a star graph there are only edges from the node to the center
        // So compare the first two edges and if there is a common element then return that.
        if(edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]){
			return edges[0][0]; 
		}
        else{ 
            return edges[0][1]; 
        }
        
    }
    public static void main(String[] args) {
        
    }
    
}
