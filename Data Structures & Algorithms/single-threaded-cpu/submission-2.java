class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        Integer[] indices = new Integer[n];
        for(int i = 0; i < n; i++)
            indices[i] = i;

        Arrays.sort(indices, 
            (a,b) -> tasks[a][0] != tasks[b][0] ? tasks[a][0] - tasks[b][0] : a - b);
        PriorityQueue<Integer> mini = new PriorityQueue<>(
            (a,b) -> tasks[a][1] != tasks[b][1] ? tasks[a][1] - tasks[b][1] : a - b);

        int[] order = new int[n];
        int i = 0;
        long time = 0;
        int resIndex = 0;

        while(!mini.isEmpty() || i < n) {
            while(i < n && tasks[indices[i]][0] <= time) {
                mini.offer(indices[i]);
                i++;
            }

            if(mini.isEmpty()) {
                time = tasks[indices[i]][0];
            } else {
                int next = mini.poll();
                time += tasks[next][1];
                order[resIndex++] = next;
            }
        }

        return order;
    }
}