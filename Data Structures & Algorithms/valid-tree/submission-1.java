public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }

        List<List<Integer>> graph = new ArrayList<>();
        for(int i =0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            graph.get(b).add(a);
            graph.get(a).add(b);
        }
        boolean[] visited = new boolean[n];

        if (dfs(0, -1, visited, graph)) {
            return false;   // cycle found
        }

        for (boolean v : visited) {
            if (!v) {
                return false;   // disconnected graph
            }
        } 
        return true;      
    }

    private boolean dfs(int node, int parent, boolean[] visit,
                        List<List<Integer>> adj) {
            visit[node] = true;

            for(int nei : adj.get(node)){
                if(!visit[nei]){
                    if(dfs(nei,node , visit,adj)) return true;

                }else if(nei != parent){
                    return true;
                }
            }
            return false;
    }
}