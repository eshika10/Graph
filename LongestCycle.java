import java.util.*;

public class LongestCycle {

    static int res=-1;

    public static void main(String[] args) {

        int n=3;

        ArrayList<ArrayList<Integer>> list=new ArrayList<>();

        list.add(new ArrayList<>());
        list.add(new ArrayList<>());
        list.add(new ArrayList<>());

        list.get(0).add(1);
        list.get(1).add(2);
        list.get(2).add(0);

        boolean[] visited=new boolean[3];
        boolean[] pathVis=new boolean[3];
        int[] count=new int[3];
       

        Arrays.fill(visited,false);
        Arrays.fill(pathVis,false);
        Arrays.fill(count,1);

        for(int i=0;i<3;i++){
            if(visited[i]==false){
                dfs(i,list,visited,pathVis,count);
            }
        }

        System.out.println(res);
    }

    private static void dfs(int i,ArrayList<ArrayList<Integer>> list,boolean[] visited,boolean[] pathVis,int[] count){

        if(i!=-1){

            visited[i]=true;
            pathVis[i]=true;

        for(int it:list.get(i)){

            if(it !=-1 && visited[it]==false){

                count[it]=count[i]+1;
                dfs(it,list,visited,pathVis,count);


            }
            else if(it!=-1 && pathVis[it]==true){

                res=Math.max(res,count[i]-count[it]+1);

            }

        }

        pathVis[i]=false;
        
        }

    }
    
}
