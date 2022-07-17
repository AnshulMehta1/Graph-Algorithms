// package DSA-Good-Questions.Graphs;
import java.util.*;
import java.io.*;


public class o33CycleDetectionDAGs {

    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            // DAG Question
            // If any cycle detected, means there is a deadlock there
            // Try with DFS
            int n=prerequisites.length;
            Map<Integer, List<Integer>> map = new HashMap<>();
            boolean[] visited=new boolean[numCourses];
            boolean[] stack=new boolean[numCourses];
            // Check for all the courses
            // The course at the last element in the list will be the key
            // Annd the first element in the arrayList will be the pre-req
            // So Map will have the 2nd entry in each arraylist as the Key
            // And the first entry chained to the LinkedList in the value associated with that Key
            for(int prq[]:prerequisites){
                map.putIfAbsent(prq[1], new LinkedList<>());
                map.get(prq[1]).add(prq[0]);
            }
            
            for(int i = 0; i < numCourses; i++){
            if(isCyclic(map, visited, stack, i))
                return false;
            }
            return true;
    
           
        }
        
        // A Method to check if the Map Passed will be cyclic or not
        private boolean isCyclic(Map<Integer,List<Integer>> map, boolean[] visited, boolean[] stack, int currNode){
            if(visited[currNode]){
                return true;
            }
            boolean isCycle=false;
            if(!stack[currNode] && map.containsKey(currNode)){
                visited[currNode]=true;
                for(int course:map.get(currNode)){
                    isCycle=isCyclic(map,visited,stack,course);
                    if(isCycle){
                        break;
                    }
                }
                visited[currNode]=false;
                stack[currNode]=false;
            }
            return isCycle;
        }
        
    
        
    }
    
}

/*
 * LeetCode Solution with the concepts
 */
