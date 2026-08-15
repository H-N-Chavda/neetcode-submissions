class Solution {
    private class pair {
        int num;
        int idx;
        pair(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    }

    public int[] dailyTemperatures(int[] temp) {
        int[] result = new int[temp.length];
        Stack<pair> st = new Stack<>();

        for(int i = 0; i < temp.length; i++) {
            while(!st.isEmpty() && st.peek().num < temp[i]) {
                pair eat = st.pop();
                result[eat.idx] = i - eat.idx;
            }
            st.push(new pair(temp[i], i));
        }

        while(!st.isEmpty()) {
            pair left = st.pop();
            result[left.idx] = 0;
        }

        return result;
    }
}
