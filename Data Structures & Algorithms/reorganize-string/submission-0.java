class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        int[] freq = new int[26];
        for (char c : s.toCharArray())
            freq[c - 'a']++;

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> freq[b] - freq[a]
        );

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0)
                pq.offer(i);
        }

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            int first = pq.poll();

            char lastAdded = sb.length() > 0 ? sb.charAt(sb.length() - 1) : '\0';

            if ((char)(first + 'a') != lastAdded) {
                sb.append((char)(first + 'a'));
                freq[first]--;
                if (freq[first] > 0)
                    pq.offer(first);
            } else {
                if (pq.isEmpty())
                    return "";

                int second = pq.poll();
                sb.append((char)(second + 'a'));
                freq[second]--;
                if (freq[second] > 0)
                    pq.offer(second);

                pq.offer(first);
            }
        }

        return sb.length() == n ? sb.toString() : "";
    }
}