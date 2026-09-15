class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, i);
        }

        int start = 0;
        int end = 0;
        while(end < s.length()) {
            for(int i = start; i <= end; i++) {
                end = Math.max(end, map.get(s.charAt(i)));
            }
            res.add(end - start + 1);
            start = end + 1;
            end = start;
        }

        return res;
    }
}
