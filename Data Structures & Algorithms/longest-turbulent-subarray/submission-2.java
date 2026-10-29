class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;
        int max =1 ;
        int count =1;
        for(int i =1;i<n;i++){
            if(arr[i]>arr[i-1]){
            if(i >= 2 && arr[i-1] <arr[i-2]){
                count++;
              }
              else{
              count = 2;
              }
            }else if(arr[i]<arr[i-1]){
               if(i >= 2 && arr[i-1] >arr[i-2]){
                count++;
              }else{
                 count =2;
              }
            }
            else{
                count =1;
            }
            max = Math.max(count , max);
        }
        return max;

    }
}