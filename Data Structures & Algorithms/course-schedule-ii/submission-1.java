
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans= new int[numCourses];
        int[] indegree = new int[numCourses];

        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
            indegree[i] = 0;
        }
        for(int[] pre:prerequisites){
            int a = pre[0];
            int b = pre[1];
            graph.get(b).add(a);
            indegree[a]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for(int i=0;i<numCourses;i++){
        if(indegree[i] == 0) queue.offer(i);
        }

        while(!queue.isEmpty()){
            int node = queue.poll();

            ans[count++] = node;

            for (int nei : graph.get(node)) {
                indegree[nei]--;

                if (indegree[nei] == 0) {
                    queue.offer(nei);
                }
            }
        }
        if(count == numCourses) return ans;

        return new int[]{};

    }
}
