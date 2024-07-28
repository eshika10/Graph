import java.util.*;

class N{
    int v;
    int wt;

    N(int v,int wt){
        this.v=v;
        this.wt=wt;
    }
}

public class JUSPAY {


    public static void main(String[] args){

       Scanner sc=new Scanner(System.in);

       int n=sc.nextInt();

       int[] id=new int[n];

       for(int i=0;i<n;i++){
          id[i]=sc.nextInt();
       }

       int e=sc.nextInt();

       int[][] edge=new int[e][3];

       for(int i=0;i<e;i++){
          edge[i][0]=sc.nextInt();
          edge[i][1]=sc.nextInt();
          edge[i][2]=sc.nextInt();
       }

       int A=sc.nextInt();
       int B=sc.nextInt();

       HashMap<Integer,ArrayList<N>> hm=new HashMap<>();

       for(int i:id){
          hm.put(i,new ArrayList<>());
       }

       for(int[] temp:edge){

          int u=temp[0];
          int v=temp[1];
          int wt=temp[2];

          hm.get(u).add(new N(v, wt));

       }

      
       HashMap<Integer,Integer> dist=new HashMap<>();

       for(int key:hm.keySet()){
           dist.put(key,(int)(1e9));
       }

       dist.replace(A,0);

       PriorityQueue<N> p=new PriorityQueue<>((n1,n2)->n1.wt-n2.wt);

       p.add(new N(A, 0));

     


       while(!p.isEmpty()){

          N val=p.poll();
          int v=val.v;
          int w=val.wt;

          for(int i=0;i<hm.get(v).size();i++){

              int neigh=hm.get(v).get(i).v;
              int vwt=hm.get(v).get(i).wt;

              if(w+vwt < dist.get(neigh)){
                  dist.replace(neigh,w+vwt);
                  p.offer(new N(neigh, w+vwt));
              }

          }

       }

       System.out.println(dist.get(B));

    }
    
}
