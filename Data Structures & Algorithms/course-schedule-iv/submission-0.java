class Solution {

    public List<Boolean> checkIfPrerequisite(int numCourses,
                                             int[][] prerequisites,
                                             int[][] queries) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            graph.get(pre[0]).add(pre[1]);
        }

        List<Boolean> ans = new ArrayList<>();

        for (int[] q : queries) {

            boolean[] visited = new boolean[numCourses];

            ans.add(dfs(q[0], q[1], visited, graph));
        }

        return ans;
    }

    private boolean dfs(int node,
                        int target,
                        boolean[] visited,
                        List<List<Integer>> graph) {

        if (node == target)
            return true;

        visited[node] = true;

        for (int nei : graph.get(node)) {

            if (!visited[nei]) {

                if (dfs(nei, target, visited, graph))
                    return true;
            }
        }

        return false;
    }
}