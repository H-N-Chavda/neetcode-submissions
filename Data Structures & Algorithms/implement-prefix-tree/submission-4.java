class Trie {
    Trie[] trie;
    boolean flag;

    Trie() {
        trie = new Trie[26];
        flag = false;
    }
}

class PrefixTree {
    Trie trie;

    public PrefixTree() {
         this.trie = new Trie();
    }

    public void insert(String word) {
        Trie head = trie;
        for(char ch : word.toCharArray()) {
            if(head.trie[ch-'a'] == null)
                head.trie[ch-'a'] = new Trie();
            head = head.trie[ch-'a'];
        }
        head.flag = true;
    }

    public boolean search(String word) {
        Trie head = trie;
        for(char ch : word.toCharArray()) {
            if(head.trie[ch-'a'] != null) {
                head = head.trie[ch-'a'];
            } else 
                return false;
        }
        return head.flag;
    }

    public boolean startsWith(String prefix) {
        Trie head = trie;
        for(char ch : prefix.toCharArray()) {
            if(head.trie[ch-'a'] != null) {
                head = head.trie[ch-'a'];
            } else 
                return false;
        }
        return true;
    }
}
