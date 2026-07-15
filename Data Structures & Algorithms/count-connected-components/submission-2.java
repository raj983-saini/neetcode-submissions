class Solution {
    public int countComponents(int n, int[][] edges) {

        List<List<Integer>> graph = new LinkedList<>();
        boolean[] visited = new boolean[n];
        for(int i =0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int []edge:edges){
          int a = edge[0];
          int b = edge[1];

          graph.get(a).add(b);
          graph.get(b).add(a);
        }
        int res=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                res++;
         dfs(i,graph,visited);
         
            }
        }
        return res;
    }
    public void dfs(int node,List<List<Integer>> graph,boolean[] visit){
        visit[node] = true;
        for(int nei:graph.get(node)){
        if(!visit[nei]){
            dfs(nei,graph,visit);
        }
        }
    }
}
