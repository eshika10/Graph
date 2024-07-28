import java.util.*;

public class NearestMeetingCell{

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        int t=sc.nextInt();

        for(int i=0;i<t;i++){

            int n=sc.nextInt();
            int[] edge=new int[n];

            for(int j=0;j<n;j++){
                 edge[j]=sc.nextInt();
            }

            int c1=sc.nextInt();
            int c2=sc.nextInt();

            System.out.println(minDist(c1,c2,edge));
        }
        
    }

    private static int minDist(int c1,int c2,int[] edge){

        int n=edge.length;

        int[] c1Dist= bfs(c1,edge);
        int[] c2Dist= bfs(c2,edge);

        //System.out.println(Arrays.toString(c1Dist));
        //System.out.println(Arrays.toString(c2Dist));

        int minDist=Integer.MAX_VALUE;
        int cell=-1;

        for(int i=0;i<n;i++){

            if(c1Dist[i]!=(int)(1e9) && c2Dist[i]!=(int)(1e9)){

                if(Math.max(c1Dist[i],c2Dist[i])<minDist){
                   minDist=Math.max(c1Dist[i],c2Dist[i]);
                   cell=i;
                }

            }

        }

        return cell;
    }

    private static int[] bfs(int src,int[] edge){

        int n=edge.length;

        int[] dist=new int[n];

        Arrays.fill(dist,(int)1e9);

        PriorityQueue<Integer> pq=new PriorityQueue<>();

        pq.offer(src);

        dist[src]=0;

        while(!pq.isEmpty()){

            int node=pq.poll();

            int neigh=edge[node];

            if(neigh!=-1 && dist[node]+1<dist[neigh]){
               dist[neigh]=dist[node]+1;
               pq.offer(neigh);
            }

        }

        return dist;

    }
    
}