class Twitter {
    HashMap<Integer, HashSet<Integer>> map;
    List<int[]> tweets;

    public Twitter() {
        map = new HashMap<>();
        tweets = new ArrayList<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!map.containsKey(userId)) {
            HashSet<Integer> temp = new HashSet<>();
            temp.add(userId);
            map.put(userId, temp);
        }
        tweets.add(new int[]{tweetId, userId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();

        HashSet<Integer> temp = map.get(userId);
        int idx = tweets.size() - 1, resIndex = 0;
        while(resIndex < 10 && idx >= 0) {
            int[] curr = tweets.get(idx);
            if(temp.contains(curr[1])) {
                res.add(curr[0]);
                resIndex++;
            }
            idx--;
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        HashSet<Integer> temp = map.getOrDefault(followerId, new HashSet<Integer>());
        temp.add(followerId);
        temp.add(followeeId);
        map.put(followerId, temp);
    }
    
    public void unfollow(int followerId, int followeeId) {
        HashSet<Integer> temp = map.getOrDefault(followerId, new HashSet<Integer>());
        temp.remove(Integer.valueOf(followeeId));
        map.put(followerId, temp);
    }
}
