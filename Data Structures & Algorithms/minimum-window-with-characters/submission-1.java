class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> tmap = new HashMap<>();
        for(char c : t.toCharArray()) {
            tmap.put(c, tmap.getOrDefault(c, 0) + 1);
        }

        int required = tmap.size();
        int formed = 0;

        int l = 0;
        int mini = s.length() + 1;
        String ans = "";
        HashMap<Character, Integer> smap = new HashMap<>();

        for(int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            smap.put(c, smap.getOrDefault(c, 0) + 1);

            if(tmap.containsKey(c) && smap.get(c).equals(tmap.get(c))) {
                formed++;
            }

            while(l <= r && formed == required) {
                if(r - l + 1 < mini) {
                    mini = r - l + 1;
                    ans = s.substring(l, r + 1);
                }

                char left = s.charAt(l);

                if(tmap.containsKey(left) &&
                   smap.get(left).equals(tmap.get(left))) {
                    formed--;
                }

                smap.put(left, smap.get(left) - 1);

                if(smap.get(left) == 0)
                    smap.remove(left);

                l++;
            }
        }

        return ans;
    }
}
