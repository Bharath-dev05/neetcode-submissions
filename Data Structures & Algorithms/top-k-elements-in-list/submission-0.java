class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (int key : map.keySet()) {
            int freq = map.get(key);

            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }

            bucket[freq].add(key);
        }

        int[] res = new int[k];
        int counter = 0;

        for (int pos = bucket.length-1; pos >= 0 && counter < k; pos--) {
            if (bucket[pos] != null) {
                for (int i : bucket[pos]) {
                    res[counter++] = i;
                }
            }
        }

        return res;
    }
}
