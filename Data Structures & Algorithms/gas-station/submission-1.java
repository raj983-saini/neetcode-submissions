class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas =0;
        int totalCost =0;

        int start =0;
        int tot =0;
      for(int i=0;i<gas.length;i++){
        totalGas += gas[i];
        totalCost += cost[i];

        tot += gas[i] -cost[i];

        if(tot < 0){
            start = i+1;
            tot = 0;
        } 
      }  
      
        if(totalGas<totalCost){
            return -1;
        }
        return start;
    }
}
