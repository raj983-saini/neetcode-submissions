class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();

        int n = senate.length();

        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }

        while(!radiant.isEmpty() && !dire.isEmpty()){
            int rp = radiant.poll();
            int dp = dire.poll();

            if(rp<dp){
               radiant.offer(n+rp);
            }else{
            dire.offer(n+dp);
            }
        }
        return radiant.isEmpty() ? "Dire" : "Radiant" ;
    }
}