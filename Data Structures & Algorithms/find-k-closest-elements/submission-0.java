class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<int[]> res = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            res.add(new int[] {Math.abs(arr[i] - x), i});
        }

        res.sort((a, b) -> Integer.compare(a[0], b[0]));

        for(int i = k; i < arr.length; i++) {
            res.remove(k);
        }

        res.sort((a, b) -> Integer.compare(a[1], b[1]));
        
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            ans.add(arr[res.get(i)[1]]);
        }

        return ans;
    }
}