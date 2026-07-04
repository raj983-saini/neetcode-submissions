class Solution {
    public int findJudge(int n, int[][] trust) {
       int outDegree[] = new int[n+1];
       int inDegree[] = new int[n+1];

       for(int nn[]:trust){
        outDegree[nn[0]]++;
        inDegree[nn[1]]++;
       }

       for(int i =0 ;i<=n;i++){
        if(outDegree[i] == 0 && inDegree[i] == n-1){
            return i;
        }
       }
        return -1;

    } 
}