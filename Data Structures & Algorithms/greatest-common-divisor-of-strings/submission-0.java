class Solution {
    public String gcdOfStrings(String str1, String str2) {
     if(!(str1 + str2).equals(str2+str1)){
        return "";
     }
     int gcd = gcds(str1.length(),str2.length());
     return str1.substring(0,gcd);
    }
    public int gcds(int s1 , int s2){
        if(s2==0){
            return s1;
        }
        return gcds(s2 ,(s1%s2));

    }
}