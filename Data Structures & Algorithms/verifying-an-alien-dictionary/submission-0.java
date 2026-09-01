class Solution {
    HashMap<Character, Integer> map = new HashMap<>();

    public boolean isAlienSorted(String[] words, String order) {
        for(int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }

        for(int i = 0; i < words.length-1; i++) {
            if(!compare(words[i], words[i+1]))
                return false;
        }
        return true;
    }

    private boolean compare(String word1, String word2) {
        int minlen = Math.min(word1.length(), word2.length());
        for(int i = 0; i < minlen; i++) {
            if(word1.charAt(i) != word2.charAt(i))
                return map.get(word1.charAt(i)) < map.get(word2.charAt(i));
        }

        return word1.length() <= word2.length();
    }
}