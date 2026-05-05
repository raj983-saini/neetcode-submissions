class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<stones.length;i++ ){
            queue.offer(stones[i]);
        }
        while(queue.size()>1){
            int a = queue.poll();
            int b =queue.poll();
            if(a!=b){
                queue.offer(Math.abs(a-b));
            }
        }
        return queue.isEmpty() ? 0 : queue.peek();
    }
}
