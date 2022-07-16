// package DSA-Good-Questions.Graphs;
import java.util.*;
import java.io.*;

public class ReconstructItinerary {
    

    class Solution {
        public List<String> findItinerary(List<List<String>> tickets) {
            // Depth First Search in a way
            // Starting has to be JFK
            // Assume for Euler Path and dfs kari de
            // For Lexicographic order need to maintain a Priority Queue in Strings
            int n=tickets.size();
            HashMap<String, PriorityQueue<String>> hm = new HashMap<>();
            // int rows=tickets.size();
            // int cols=tickets[0].size;
            String start="JFK";
            for(int i=0;i<n;i++){
                String key=tickets.get(i).get(0);
                String value=tickets.get(i).get(1);
                 if(!hm.containsKey(key)){
                    PriorityQueue<String> temp = new PriorityQueue<>();
                    hm.put(key, temp);
                }
                hm.get(key).add(value);
            }
            
            LinkedList<String> ans = new LinkedList<>();
            dfsHelper("JFK", hm, ans);
            return ans;
            
        }
        
         public void dfsHelper(String dep, Map<String, PriorityQueue<String>> hm, LinkedList<String> res) {
             // dep -> Departure
            PriorityQueue<String> arrivals = hm.get(dep);
            while (arrivals != null && !arrivals.isEmpty()) {
                dfsHelper(arrivals.poll(), hm, res);
            }
    
            res.addFirst(dep);
        }
    }
    public static void main(String[] args) {
        
    }

}
