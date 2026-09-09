class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(str1.length() == 0)
            return str2;
        if(str2.length() == 0)
            return str1;

        if(str2.length() > str1.length()) {
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }

        if(!str1.contains(str2))
            return "";
        str1 = str1.replaceFirst(str2, "");
        return gcdOfStrings(str1, str2);
    }
}