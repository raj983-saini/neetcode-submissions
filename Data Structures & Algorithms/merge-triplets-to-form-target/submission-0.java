class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        Set<Integer> set = new HashSet<>();
        for(int [] tri:triplets){
            if(tri[0] >target[0] || tri[1] >target[1] || tri[2] >target[2]){
                continue;
            }
            for(int i=0;i<tri.length;i++){
                if(tri[i] == target[i]){
                    set.add(i);
                }
            }
        }
        return set.size() == 3;
    }
}
