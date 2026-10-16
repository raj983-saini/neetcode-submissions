class Solution {
    public boolean isHappy(int n) {
    Set<Integer> ans = new HashSet<>();
    while(n !=1){
        int sum = 0;
        while(n>0){
            int val= n%10;
            sum += val*val;
            n=n/10;
        }
        if(ans.contains(sum)){
            return false;
        }
        ans.add(sum);
        n = sum;
    } 
    return true;
    }
}
