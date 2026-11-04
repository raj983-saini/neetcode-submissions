class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i) ,i);
        }
        int max =0;
        int last =0;
        boolean first = true;
        for(int i=0;i<s.length();i++){
            int cur = map.get(s.charAt(i));
            max = Math.max(cur,max);
            if(max == i){
                if(first){ans.add(max-last+1); first =false;}
                else{ans.add(max-last);}
                last = max;
            }
        }
        return ans;
    }
}
