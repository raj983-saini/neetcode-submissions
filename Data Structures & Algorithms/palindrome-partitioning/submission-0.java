class Solution {
    public List<List<String>> partition(String s) {
         List<List<String>> res = new ArrayList<>();
         List<String> part = new ArrayList<>();
         dfs(0,0,res,part,s);
         return res;
    }
    public void dfs(int i,int j,List<List<String>> res,List<String> part ,String s){
        if(j>=s.length()){
            if(i==j){
               res.add(new ArrayList<>(part));
            }
            return;
        }
        if(isPali(s,i,j)){
            part.add(s.substring(i,j+1));
            dfs(j+1,j+1,res,part,s);
            part.remove(part.size()-1);
        }
        dfs(i,j+1,res,part,s);


    }
     private boolean isPali(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
