class Solution {
    public void sortColors(int[] nums) {
        int i =0;
        int low = 0;
        int high =nums.length-1;
        while(i<=high){
            if(nums[i] ==0){
                swap(nums , i , low);
                low++;
            }else if(nums[i]==2){
                swap(nums,i,high);
                high--;
                i--;
            }
            i++;
        }

        
    }
    public void swap(int[] num,int i , int j){
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}