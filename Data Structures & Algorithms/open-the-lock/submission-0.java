class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> set = new HashSet<>();
        for(String end : deadends)
            set.add(end);
        HashSet<String> vis = new HashSet<>();
        if(set.contains("0000"))
            return -1;

        Queue<String> q = new LinkedList<>();
        q.add(new String("0000"));
        int counter = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                String curr = q.poll();
                if(curr.equals(target))
                    return counter;

                for(int j = 0; j < 4; j++) {
                    char c = curr.charAt(j);
                    StringBuilder next = new StringBuilder(curr);
                    StringBuilder prev = new StringBuilder(curr);
                    if(c > '0')
                        prev.setCharAt(j, (char)(c-1));
                    else 
                        prev.setCharAt(j, '9');
                    if(c < '9')
                        next.setCharAt(j, (char)(c+1));
                    else 
                        next.setCharAt(j, '0');
                    
                    String nex = next.toString();
                    if(!set.contains(nex) && !vis.contains(nex)) {
                        vis.add(nex);
                        q.offer(nex);
                    }
                    String pre = prev.toString();
                    if(!set.contains(pre) && !vis.contains(pre)) {
                        vis.add(pre);
                        q.offer(pre);
                    }
                }
            }

            counter++;
        }

        return -1;
    }
}