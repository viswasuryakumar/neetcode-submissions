class Solution {
    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        String word = null;

    }



    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
// ---------- STEP 1: Build the Trie from all words
        TrieNode root = new TrieNode();
        for(String w : words){
            TrieNode node = root;
            for(char c: w.toCharArray()){
                int idx = c- 'a';
                if(node.children[idx] == null){
                    node.children[idx] = new TrieNode();

                }
                node = node.children[idx];
            }
            node.word = w; // mark end of word
        }
        int rows = board.length, cols = board[0].length;
        // ---------- STEP 2: DFS from every cell in the board
        for(int r=0;r< rows ; r++){
            for(int c = 0; c< cols; c++){
                dfs(board, r,c,root,result);
            }
        }
        return result;

    }

    private void dfs(char[][] board, int r, int c, TrieNode node, List<String> result ){
        // Bounds check + already visited (marked '#') check
        if(r<0 || r>= board.length || c<0 || c>= board[0].length) return;
        char ch = board[r][c];
        if (ch == '#') return; // already used in current path
        // Does the trie even have a branch for this character?
        int idx = ch - 'a';
        TrieNode next = node.children[idx];
        if(next == null) return;// no word in trie starts with this prefix -> dead end, prune
        
        // if this node completes a word, add it to the rsult
        if(next.word != null){
            result.add(next.word);
            next.word =  null; // avoid duplicate additions if grid revisits same word path
        }
        board[r][c] = '#';
        // Explore all 4 directions
        dfs(board, r + 1, c, next, result);
        dfs(board, r - 1, c, next, result);
        dfs(board, r, c + 1, next, result);
        dfs(board, r, c - 1, next, result);
        // ---- Restore the cell (undo the move) ---
        board[r][c] = ch;
    }

}
