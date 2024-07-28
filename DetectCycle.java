import java.util.*;

public class DetectCycle {

    public static void main(String[] args) {

        int n=3;

        ArrayList<ArrayList<Integer>> list=new ArrayList<>();

        list.add(new ArrayList<>());
        list.add(new ArrayList<>());
        list.add(new ArrayList<>());

        list.get(0).add(1);
        list.get(1).add(2);
        list.get(2).add(0);

        boolean ans=isCycle(list,n);

        System.out.println(ans);
        
    }

    private static boolean isCycleDfs(ArrayList<ArrayList<Integer>> list,int node,boolean[] visited,boolean[] inRecursion){
        visited[node]=true;
        inRecursion[node]=true;

        for(int n:list.get(node)){

            if(visited[n]==false && isCycleDfs(list,n,visited,inRecursion)){
                return true;
            }
            else if(inRecursion[n]==true){
                return true;
            }
        }

        inRecursion[node]=false;
        return false;
    }

    private static boolean isCycle(ArrayList<ArrayList<Integer>> list,int n){

        boolean[] visited=new boolean[3];
        boolean[] inRecursion=new boolean[3];

        Arrays.fill(visited,false);
        Arrays.fill(inRecursion,false);

        for(int i=0;i<3;i++){

            if(visited[i]==false && isCycleDfs(list,i,visited,inRecursion)){
                return true;
            }

        }

        return false;
    }
    
}
