import java.util.*;

public class AdjacencyListRepo{

    public static void main(String[] args) {
    
        int V=10;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>(V);

        for(int i=0;i<V;i++){
            adj.add(new ArrayList<Integer>());
        }

        // 0 1
        // 0 2
        // 0 4
        // 0 8
        // 1 5
        // 1 6
        // 1 9
        // 2 4
        // 3 7
        // 3 8
        // 5 8
        // 6 7
        // 6 9
   
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 0, 4);
        addEdge(adj, 0, 8);
        addEdge(adj, 1, 5);
        addEdge(adj, 1, 6);
        addEdge(adj, 1, 9);
        addEdge(adj, 2, 4);
        addEdge(adj, 3, 7);
        addEdge(adj, 3, 8);
        addEdge(adj, 1, 9);
        addEdge(adj, 5, 8);
        addEdge(adj, 6, 7);
        addEdge(adj, 6, 9);

        printAdjacencyList(adj);
        
  }

   public static void addEdge(ArrayList<ArrayList<Integer>> list,int u ,int v){
             
           list.get(u).add(v);
   }

   public static void printAdjacencyList(ArrayList<ArrayList<Integer>> list){
           
          int j=0;
          while(j<10){
                 for(Integer i:list.get(j)){
                    System.out.print(i+" ");
                    
                 }
                 System.out.println();
                 j++;
          }
   }
}