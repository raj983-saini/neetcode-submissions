class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(find(i,j,0,board,word)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean find(int left,int right,int index ,char[][] board,String word){
     if(index == word.length()) return true;
     if(left<0 || right < 0|| left >=board.length || right >=board[0].length ||board[left][right] != word.charAt(index)) return false;

     char temp = board[left][right];
     board[left][right] = '#';

     boolean ans = find(left-1,right,index+1,board,word) ||
     find(left+1,right,index+1,board,word) ||
     find(left,right+1,index+1,board,word) ||
     find(left,right-1,index+1,board,word);

     board[left][right] = temp;
     return ans;
    }
}
