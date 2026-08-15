class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> ans = new HashSet<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if(map.get(num) > nums.length/3)
                ans.add(num);
        }
        return new ArrayList<>(ans);
    }
}