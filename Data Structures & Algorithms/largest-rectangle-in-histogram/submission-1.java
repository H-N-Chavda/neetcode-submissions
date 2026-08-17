class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<int[]> st = new Stack<>();
        int maxi = heights[0];
        int[] first = new int[2];
        first[0] = 0;
        first[1] = heights[0];
        st.push(first);

        for(int i = 1; i < n; i++) {
            int[] pair = new int[2];
            if(heights[i] > st.peek()[1]) {
                pair[0] = i;
                pair[1] = heights[i];
                st.push(pair);
            } else {
                int idx = i;
                while(!st.isEmpty() && heights[i] < st.peek()[1]) {
                    pair = st.pop();
                    idx = pair[0];
                    int area = (i - pair[0]) * pair[1];
                    maxi = Math.max(maxi, area);
                }
                pair[0] = idx;
                pair[1] = heights[i];
                st.push(pair);
            }
        }

        while(!st.isEmpty()) {
            int[] pair = st.pop();
            int area = (n - pair[0]) * pair[1];
            maxi = Math.max(maxi, area);
        }

        return maxi;
    }
}
