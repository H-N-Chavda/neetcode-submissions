class Solution {
    HashSet<String> set;
    List<String> res;

    public List<String> wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        res = new ArrayList<>();
        dfs(new StringBuilder(s), 0);
        return res;
    }

    private void dfs(StringBuilder sb, int idx) {
        if(idx >= sb.length() - 1) {
            int l = sb.lastIndexOf(" ");
            if(set.contains(sb.substring(l + 1, idx + 1).toString()))
                res.add(sb.toString());
            return ;
        }

        int l = sb.lastIndexOf(" ");
        // if(l < 0)   l = 0;

        String word = sb.substring(l + 1, idx + 1).toString();
        if(set.contains(word)) {
            dfs(sb.insert(idx+1, " "), idx + 1);
            sb.deleteCharAt(idx + 1);
        }
        dfs(sb, idx + 1);

        return ;
    }
}