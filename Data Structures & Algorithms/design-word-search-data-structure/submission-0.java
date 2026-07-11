class WordDictionary {
private TrieNode root;
private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }
    public WordDictionary() {
       root = new TrieNode();
    }

    public void addWord(String word) {
       TrieNode node = root;
       for (char c : word.toCharArray()) {
        int idx = c - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
        node.isEnd = true;
    }
    

    public boolean search(String word) {
return dfs(word, 0, root);
    }
     private boolean dfs(String word, int index, TrieNode node) {
        if (node == null) return false;
        if (index == word.length()) return node.isEnd;
        char c = word.charAt(index);
        if (c == '.') {
            for (TrieNode child : node.children) {
                if (dfs(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
            } else {
            return dfs(word, index + 1, node.children[c - 'a']);
        }
    }

}
