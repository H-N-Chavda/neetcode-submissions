class Trie {
    Trie[] letter = new Trie[26];
    boolean ends = false;
    Trie() {}
}

class WordDictionary {
    Trie trie;
    public WordDictionary() {
        trie = new Trie();
    }

    public void addWord(String word) {
        Trie temp = trie;
        for(char ch : word.toCharArray()) {
            if(temp.letter[ch-'a'] == null)
                temp.letter[ch-'a'] = new Trie();
            temp = temp.letter[ch-'a'];
        }
        temp.ends = true;
    }

    public boolean search(String word) {
        Trie temp = trie;
        return dfs(word, temp);
    }

    private boolean dfs(String word, Trie temp) {
        if(word.length() == 0) {
            return temp.ends;
        }

        char ch = word.charAt(0);
        if(ch == '.') {
            for(int i = 0; i < 26; i++) {
                if(temp.letter[i] != null) {
                    boolean found = dfs(word.substring(1), temp.letter[i]);
                    if(found)   return true;
                }
            }

            return false;

        } else {
            if(temp.letter[ch-'a'] == null)
                return false;

            temp = temp.letter[ch-'a'];
            return dfs(word.substring(1), temp);
        }
    }
}
