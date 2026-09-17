class Solution {
    private List<Integer>[] adj;
    private int[] indegree;
    private boolean[] vis;

    @SuppressWarnings("unchecked")
    public String foreignDictionary(String[] words) {
        if(words.length == 1)
            return words[0];

        adj = new ArrayList[26];
        indegree = new int[26];
        vis = new boolean[26];

        for(int i = 0; i < 26; i++) 
            adj[i] = new ArrayList<>();

        for(int i = 0; i < words.length - 1; i++) {
            boolean pos = makeEdge(words[i], words[i+1]);
            if(!pos)
                return "";
        }

        Queue<Integer> queue  = new LinkedList<>();
        for(int i = 0; i < 26; i++) {
            if(indegree[i] == 0 && vis[i])
                queue.offer(i);
        }

        String ans = "";
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            for(int nei : adj[curr]) {
                indegree[nei]--;
                if(indegree[nei] == 0)
                    queue.offer(nei);
            }
            ans = ans + (char)(curr + 'a');
        }

        int chars = 0;
        for(boolean v : vis)
            if(v == true)
                chars++;

        return ans.length() == chars ? ans : "";
    }

    private boolean makeEdge(String a, String b)  {
        for(char c : a.toCharArray())
            vis[c-'a'] = true;
        for(char c : b.toCharArray())
            vis[c-'a'] = true;

        int id = 0;
        while(id < a.length())  {
            if(id == b.length())
                return false;

            if (a.charAt(id) != b.charAt(id)) {
                int u = a.charAt(id) - 'a';
                int v = b.charAt(id) - 'a';
                adj[u].add(v);
                indegree[v]++;
                break;
            } 
            id++;
        }
        return true;
    }
}