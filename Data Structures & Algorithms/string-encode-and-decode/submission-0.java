class Solution {

    public String encode(List<String> strs) {
        if(strs.size() == 0)
            return "";

        StringBuffer sb = new StringBuffer();
        for(String s : strs) {
            sb.append(s.length() + "#");
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ls = new ArrayList<>();

        int idx = 0;
        while(idx < str.length()) {
            int len = 0;
            while(str.charAt(idx) != '#') {
                len*=10;
                len+= (str.charAt(idx)-'0');
                idx++;
            }

            idx++;
            StringBuffer sb = new StringBuffer();
            while(len > 0) {
                sb.append(str.charAt(idx++));
                len--;
            }

            ls.add(sb.toString());
        }

        return ls;
    }
}
