class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < wordList.size(); i++) 
            adj.add(new ArrayList<>());

        // If I can go from a to b, make an edge between them
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                if (compre(wordList.get(i), wordList.get(j))) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        boolean[] vis = new boolean[wordList.size()];

        Queue<Integer> q = new LinkedList<>();
        boolean exist = false;
        for (int i = 0; i < wordList.size(); i++) {
            if (compre(beginWord, wordList.get(i))) {
                vis[i] = true;
                q.offer(i);
            }
            if(wordList.get(i).equals(endWord))
                exist = true;
        }
        if(!exist)
            return 0;

        int depth = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                if (endWord.equals(wordList.get(curr)))
                    return depth + 1;

                for (int next : adj.get(curr)) {
                    if(!vis[next]) {
                        q.offer(next);
                        vis[next] = true;
                    }
                }
            }
            depth++;
        }

        return 0;
    }

    private boolean compre(String a, String b) {
        int miss = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i))
                miss++;
        }
        return miss == 1;
    }
}
