class Node {
    Node[] node = new Node[26];
    boolean word;
}

class Solution {

    Node root = new Node();
    List<String> ans = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {

        // Build Trie
        for (String w : words) {
            Node cur = root;
            for (char c : w.toCharArray()) {
                if (cur.node[c - 'a'] == null)
                    cur.node[c - 'a'] = new Node();
                cur = cur.node[c - 'a'];
            }
            cur.word = true;
        }

        // Start DFS from every cell
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, new StringBuilder());
            }
        }

        return ans;
    }

    private void dfs(char[][] board, int r, int c, Node cur, StringBuilder path) {

        // bounds check
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length)
            return;

        char ch = board[r][c];

        // visited OR not in trie
        if (ch == '#' || cur.node[ch - 'a'] == null)
            return;

        cur = cur.node[ch - 'a'];
        path.append(ch);

        // found word
        if (cur.word) {
            ans.add(path.toString());
            cur.word = false; // avoid duplicates
        }

        // mark visited
        board[r][c] = '#';

        // 4 directions
        dfs(board, r + 1, c, cur, path);
        dfs(board, r - 1, c, cur, path);
        dfs(board, r, c + 1, cur, path);
        dfs(board, r, c - 1, cur, path);

        // backtrack
        board[r][c] = ch;
        path.deleteCharAt(path.length() - 1);
    }
}
