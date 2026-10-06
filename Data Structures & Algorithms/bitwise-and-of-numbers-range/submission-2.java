class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        for(int i = 0 ;i<32;i++){
               if(right<=left){
                break;
            }
            right = right &(right -1);

        }
        return right;
    }
}