// package DSA-Good-Questions.Graphs;
import java.util.*;
import java.io.*;
// Second Implementation Graph with a Node  Class
public class AdjList2 {

    static class Node {
        String name;
        ArrayList<String> neighbors;
        // Constructor 
        Node(String name){
            this.name = name;
            // An araaylist  for neighbours
            neighbors=new ArrayList<>();

        }
    }
    
    static class Graph {
        // A hashmap of type String with Nodes 
        HashMap<String,Node> map;
        // Constructor for Graph
        public Graph(ArrayList<String> str){
            // Initialzing the Hashmap
            map=new HashMap<>();
            for (String strs:str){
                //  Put it in the map and create the Node for the city
                map.put(strs,new Node(strs));
            }

        }

        public void addEdge(String src, String dest, boolean unDirected){
            // Get the element and to it's neighbours add the destination
            map.get(src).neighbors.add(dest);
            if(unDirected){
                map.get(dest).neighbors.add(src);
            }

        }

        public void printAdjList(){
            for(Map.Entry<String, Node> strPair: map.entrySet()){
                System.out.print(strPair.getKey() + " --> ");
                for(String nbrs: strPair.getValue().neighbors){
                    System.out.print(nbrs + ", ");
                }
                System.out.println();
            }
        }

    }
    public static void main(String[] args) {

        ArrayList<String> cities = new ArrayList<>();
        cities.add("Delhi");
        cities.add("London");
        cities.add("Paris");
        cities.add( "New York");

        Graph g = new Graph(cities);
        g.addEdge("Delhi", "London" , true);
        g.addEdge("New York","London", true);
        g.addEdge("Delhi","Paris" , true);
        g.addEdge("Paris","New York" , true);

        g.printAdjList();
        
    }
    
}
