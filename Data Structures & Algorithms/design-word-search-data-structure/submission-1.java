public class Node{
    Node []node;
    boolean word;
    public Node(){
    node = new Node[26];
    word  = false;
    }
}

public class WordDictionary {
   private Node root;

    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            if(cur.node[c-'a'] == null){
                cur.node[c-'a'] = new Node();
            }
            cur = cur.node[c-'a'];
        }
        cur.word = true;
    }

    public boolean search(String word) {
       return dfs(word ,0, root);
    }
    public boolean dfs(String word,int j ,Node root){
        Node cur = root;
        for(int i = j; i<word.length();i++){
            char c = word.charAt(i);
            if(c == '.'){
                for(Node child:cur.node){
                    if(child != null && dfs(word,i+1,child)){
                        return true;
                    }
                }
                return false;
            }
            else {
                if(cur.node[c-'a'] == null) return false;
                cur = cur.node[c-'a'];
            }
                    }
            return cur.word;

    }
}