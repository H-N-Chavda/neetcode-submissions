class Trie {
    Trie[] next = new Trie[26];
    boolean ends = false;
    Trie() {}
}

class Solution {
    Trie trie;
    Integer[] memo;
    public int minExtraChar(String s, String[] dictionary) {
        trie = new Trie();
        memo = new Integer[s.length() + 1];
        makeTrie(dictionary);
        int res = dfs(s, 0);
        return res;
    }

    private int dfs(String s, int idx) {
        if(idx == s.length())
            return 0;
        if(memo[idx] != null)
            return memo[idx];

        int mini = 1 + dfs(s, idx + 1);
        
        Trie curr = trie;
        for(int i = idx; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(curr.next[ch-'a'] == null)
                break;
            curr = curr.next[ch-'a'];
            if(curr.ends == true)
                mini = Math.min(mini, dfs(s, i + 1));
        }
        return memo[idx] = mini;
    }

    private void makeTrie(String[] dict) {
        for(String word : dict) {
            Trie temp = trie;

            for(char ch : word.toCharArray()) {
                if(temp.next[ch-'a'] == null)
                    temp.next[ch-'a'] = new Trie();
                temp = temp.next[ch-'a'];
            }
            temp.ends = true;
        }
    }
}