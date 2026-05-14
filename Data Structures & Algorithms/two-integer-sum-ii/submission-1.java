class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length-1;
     while(low<high){
        int mid = numbers[low]+numbers[high];
      if(mid >target){
      high--;

      }else if(mid<target){
      low++;
      }else{
        return new int[]{low+1,high+1};
      }
     }
     return new int[]{-1,-1};
    }
    
   

}