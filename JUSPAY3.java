import java.util.*;


class Edge{
    int v;
    int wt;

    Edge(int v,int wt){

        this.v=v;
        this.wt=wt;

    }
}

class TestClass{
    
    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        int n= sc.nextInt();

        int[] id=new int[n];

        for(int i=0;i<n;i++){
            id[i]=sc.nextInt();
        }

        int e=sc.nextInt();

        int[][] emp=new int[e][3];

        for(int i=0;i<e;i++){
            emp[i][0]=sc.nextInt();
            emp[i][1]=sc.nextInt();
            emp[i][2]=sc.nextInt();
        }

        int A=sc.nextInt();
        int B =sc.nextInt();

        HashMap<Integer,List<Edge>> hm=new HashMap<>();

        for(int i:id){
             hm.put(i,new ArrayList<>());
        }

        for(int[] temp:emp){
            int u= temp[0];
            int v=temp[1];
            int wt=temp[2];

            hm.get(u).add(new Edge(v, wt));
 
        }


        HashMap<Integer,Integer> dist=new HashMap<>();

        for(int key:hm.keySet()){
            dist.put(key,(int)1e9);
        }

        dist.replace(A,0);

        PriorityQueue<Edge> p=new PriorityQueue<>((n1,n2)->n1.wt-n2.wt);

        p.add(new Edge(A,0));

        while(!p.isEmpty()){

            int node=p.peek().v;
            int pTime=p.peek().wt;

            p.poll();

            for(int i=0;i<hm.get(node).size();i++){

                int neigh=hm.get(node).get(i).v;
                
                int time=hm.get(node).get(i).wt;

                // System.out.println(neigh+"---"+time);
    
                if(pTime+time< dist.get(neigh)){
                     dist.replace(neigh,pTime+time);
                     p.offer(new Edge(neigh,dist.get(neigh)));
                }
    
            }

       }
        
       for(int key:dist.keySet()){
            System.out.println(key+"->"+dist.get(key));
       }

       System.out.println(dist.get(B));

        
    }

   
}