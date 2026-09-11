class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<int[]> bucket = new ArrayList<>();
        for (int key : map.keySet()) {
            bucket.add(new int[] {map.get(key), key});
        }

        bucket.sort((a, b) -> b[0] - a[0]);

        int[] res = new int[k];
        int idx = 0;

        for (int i = 0; i < k; i++) {
            res[idx++] = bucket.get(i)[1];
        }

        return res;
    }
}
