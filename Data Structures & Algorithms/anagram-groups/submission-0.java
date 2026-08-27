class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        List<int[]> freq = new ArrayList<>();

        for(int i = 0; i < strs.length; i++) {
            int[] fre = new int[26];

            for(int j = 0; j < strs[i].length(); j++) {
                fre[strs[i].charAt(j) - 'a']++;
            }

            boolean found = false;
            for(int idx = 0; idx < list.size(); idx++) {
                if(Arrays.equals(freq.get(idx), fre)) {
                    list.get(idx).add(strs[i]);
                    found = true;
                    break;
                }
            }
            if(!found) {
                list.add(new ArrayList<>(List.of(strs[i]))); 
                freq.add(fre);
            }
        }

        return list;
    }
}
