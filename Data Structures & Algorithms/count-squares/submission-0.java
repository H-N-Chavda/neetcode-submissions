class CountSquares {
    private Map<String, Integer> map;
    private List<int[]> points;

    public CountSquares() {
        map = new HashMap<>();
        points = new ArrayList<>();
    }

    public void add(int[] point) {
        String key = point[0] + ", " + point[1];
        map.put(key, map.getOrDefault(key, 0) + 1);
        points.add(point);
    }
    
    public int count(int[] point) {
        int px = point[0];
        int py = point[1];
        int ans = 0;

        for(int[] p : points) {
            int x = p[0];
            int y = p[1];

            if(Math.abs(px - x) != Math.abs(py - y) || px == x || py == y)
                continue;

            String p2 = px + ", " + y;
            String p3 = x + ", " + py;
            if(map.containsKey(p2) && map.containsKey(p3)) {
                ans += map.get(p2) * map.get(p3);
            }
        }

        return ans;
    }
}