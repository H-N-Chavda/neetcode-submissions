class Solution {
    private class pair {
        int num;
        int freq;
        pair(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<pair> pq = new PriorityQueue<>(
            (pair x, pair y) -> Integer.compare(y.freq, x.freq)
        );
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int num : map.keySet()) {
            pair some = new pair(num, map.get(num));
            pq.add(some);
        }

        int[] ans = new int[k];
        for(int i = 0; i < k; i++) {
            ans[i] = pq.poll().num;
        }

        return ans;
    }
}
