class Trie {
    Trie[] letter;
    boolean ends;
    Trie() {
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
           if (temp.letter[ch - 'a'] == null) {
                temp.letter[ch - 'a'] = new Trie();
            }
            temp = temp.letter[ch - 'a'];
        }
        temp.ends = true;
    }

    public boolean search(String word) {
        Trie temp = trie;
        for(char ch : word.toCharArray()) {
            if(temp.letter[ch-'a'] == null)
                return false;

            temp = temp.letter[ch-'a'];
        }
        return temp.ends;
    }

    public boolean startsWith(String prefix) {
        Trie temp = trie;
        for(char ch : prefix.toCharArray()) {
            if(temp.letter[ch-'a'] == null)
                return false;

            temp = temp.letter[ch-'a'];
        }
        return true;
    }
}
