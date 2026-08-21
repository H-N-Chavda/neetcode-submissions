class TimeMap {
    private class pair {
        String value;
        int time;
        pair() {}
        pair(String val, int time) {
            this.value = val;
            this.time = time;
        }
    }
    HashMap<String, List<pair>> map;

    public TimeMap() {
        map = new HashMap<>();    
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key))
            map.put(key, new ArrayList<>());

        List<pair> temp = map.get(key);
        temp.add(new pair(value,timestamp));
        map.put(key, temp);
    }
    
    public String get(String key, int timestamp) {
        List<pair> temp = map.get(key);
        if(temp == null || temp.isEmpty())  return "";
        int l = 0;
        int r = temp.size() - 1;
        int res = -1;

        while(l <= r) {
            int mid = l + (r-l)/2;

            if(temp.get(mid).time <= timestamp) {
                res = mid;
                l = mid + 1;
            }
            else
                r = mid - 1;
        }

        return res == -1 ? "" : temp.get(res).value;
    }
}
