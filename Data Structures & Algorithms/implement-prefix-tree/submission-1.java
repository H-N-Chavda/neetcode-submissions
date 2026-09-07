class Trie {
    boolean[] exist;
    Trie[] letter;
    boolean ends;
    Trie() {
        exist = new boolean[26];
        letter = new Trie[26];
        ends = false;
    }
}

class PrefixTree {
    Trie trie;
    public PrefixTree() {
        trie = new Trie();
    }

    public void insert(String word) {
        Trie temp = trie;
        for(char ch : word.toCharArray()) {
           if (!temp.exist[ch - 'a']) {
                temp.exist[ch - 'a'] = true;
                temp.letter[ch - 'a'] = new Trie();
            }
            temp = temp.letter[ch - 'a'];
        }
        temp.ends = true;
    }

    public boolean search(String word) {
        Trie temp = trie;
        for(char ch : word.toCharArray()) {
            if(temp.exist[ch-'a'] == false)
                return false;

            temp = temp.letter[ch-'a'];
        }
        return temp.ends;
    }

    public boolean startsWith(String prefix) {
        Trie temp = trie;
        for(char ch : prefix.toCharArray()) {
            if(temp.exist[ch-'a'] == false)
                return false;

            temp = temp.letter[ch-'a'];
        }
        return true;
    }
}
