class Solution {
    public boolean isPalindrome(String s) {

        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            while(i < j && !alphaFuntion(s.charAt(i))){
                i++;
            }
            while(i < j && !alphaFuntion(s.charAt(j))){
                j--;
            }
            if(tolower(s.charAt(i)) != tolower(s.charAt(j))){
                return false;
            }
            i++;
            j--;
            
        }
        return true;
    }

    public boolean alphaFuntion(char c){
        if(c >= 'A' && c<='Z' ||
           c >= 'a' && c<='z' ||
           c >= '0'  && c<='9'){
            return true;
           }
           return false;
    }
    public char tolower(char c){
        if(c >= 'A' && c <= 'Z'){
            return (char)(c + 32);
        }
        return c;
    }
}
