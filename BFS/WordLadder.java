// package DSA-Good-Questions.Graphs;
import java.util.*;
import java.io.*;

public class WordLadder {
    public static void main(String[] args) {
        
    }
}



class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        
        if(!wordList.contains(endWord)){
            return 0;
        }
        // Reach from the starting word to end word with changin one character per step
        //  All words need not be traversed
        // Shortest way, can be 2 swaps, 3 swaps .. n swaps
        // Level Order Like Feeling - Per character is one level in BFS
        // From hit --> hot is one level below it - 1 Step
        // From hot --> dot and lot are one another level - 2 Steps 
        // From dot --> dog if one level below - 3 Steps 
        // Similarly from lot --> log is one level below - 3 Steps
        // From dog --> cog is one level below -- 4 Steps
        // From log --> cog is one level belwo -- 4 Steps
        // 1 + 4 Steps -> 5 WOrds to get to the end word String.
        // This is a level order problem as explained above
        // Every character change is a level
        // So BFS is more suitable in shortest steps/ paths questions due to this reason as DFS will sometimes go in some other tangent and check all the elements whereas BFS might give the answer in crisp number of Steps.
        // Here since we have strings to be visited and need the keys, we will create the Boolean type Hashmap
        // visited
        HashMap<String,Boolean> visit_map=new HashMap<>();
        // Queue
        Queue<String> q=new LinkedList<>();
        // How to find the adjacent 
        // Change to char array and write the Logic for only one char change check
        // Logic -> Create Variations on Positions of all the characters and check if that word is available in the List
        for(int i=0;i<wordList.size();i++){
            // Mark all of them as visited false
            visit_map.put(wordList.get(i),false);
        }
        int steps=1;
        q.add(beginWord);
        // Mark the first word as visited
        visit_map.put(beginWord,true);
        // While thhe queue is empty
        while(!q.isEmpty()){
            int size=q.size();
            for(int j=0;j<size;j++){
                String currWord=q.poll();
                if(currWord==endWord){
                    return steps;
                }
                // Call the variation Function
                OneCharVariationMatch(currWord,visit_map,q);
            }
            
            steps++;
        }
        // If none found
        return steps;
        
    }
    
    public void OneCharVariationMatch(String word, HashMap<String,Boolean> visit_map, Queue<String> q){
        
        for(int i=0;i<word.length();i++){
            // Outer Loop for changing each letter in the word
            char[] wordch=word.toCharArray();
            for(int j=0;j<26;j++){
                // Inner loop for single positions all 26 alphabets 
                
                // a + 1...26 -> a,b,c,d,e,...->z
                char ch=(char)('a'+j);
                // Replacing the char
                wordch[i]=ch;
                String s=String.valueOf(wordch);
                // Contains and unvisited
                if(visit_map.containsKey(s) && visit_map.get(s)==false){
                    q.add(s);
                    visit_map.put(s,true);
                }
            }
        }
        
    }
}
