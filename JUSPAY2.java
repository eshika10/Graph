import java.util.*;


public class JUSPAY2 {

    public static void main(String[] args) {

         Scanner sc=new Scanner(System.in);

         int n=sc.nextInt();

         int[] id=new int[n];

         for(int i=0;i<n;i++){
            id[i]=sc.nextInt();
         }

         int e=sc.nextInt();

         int[][] edge=new int[e][2];

         for(int i=0;i<e;i++){
            edge[i][0]=sc.nextInt();
            edge[i][1]=sc.nextInt();
         }

         int A=sc.nextInt();
         int B=sc.nextInt();

         HashMap<Integer,List<Integer>> hm=new HashMap<>();

         for(int i:id){
            hm.put(i,new ArrayList<>());
         }

         for(int[] temp:edge){
            int u=temp[0];
            int v=temp[1];

            hm.get(u).add(v);
         }

         ArrayList<Integer> visited=new ArrayList<>();

         dfs(A,hm,visited);

         if(visited.contains(B)){
             System.out.println(1);
         }else{
            System.out.println(0);
         }

         System.out.println(visited);
        
    }

    private static void dfs(int s,HashMap<Integer,List<Integer>> hm,ArrayList<Integer> visited){

        Stack<Integer> st=new Stack<>();

        st.push(s);

        visited.add(s);

        while(!st.isEmpty()){

             int val=st.pop();

             for(int i=0;i<hm.get(val).size();i++){

                int neigh=hm.get(val).get(i);

                if(!visited.contains(neigh)){
                   visited.add(neigh);
                   st.push(neigh);
                }

             }

        }

    }
    
}
