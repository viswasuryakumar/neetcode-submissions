class PrefixTree {
    private PrefixTree[] children;
    private boolean isEnd;
    public PrefixTree() {
         children = new PrefixTree[26];
         isEnd = false;
    }

    public void insert(String word) {
        PrefixTree node = this;
    for(int i=0;i< word.length();i++){
        int idx =word.charAt(i)-'a';
        if(node.children[idx]==null){
            node.children[idx]= new PrefixTree();
        }
        node = node.children[idx];

    }
    node.isEnd = true;
    }

    public boolean search(String word) {
      PrefixTree node = this;
      for(int i=0;i<word.length();i++){
        int ind = word.charAt(i)-'a';
        if(node.children[ind]==null){
            return false;
        }

        node = node.children[ind];
      }
      return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        PrefixTree node = this;
        for(int i=0; i<prefix.length();i++){
            int idx = prefix.charAt(i) - 'a';
            if(node.children[idx]==null)
                 return false;

            node = node.children[idx];

        }
        return true;
    }
}
