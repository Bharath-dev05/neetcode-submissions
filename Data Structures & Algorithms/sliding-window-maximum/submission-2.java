class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] res = new int[nums.length - k + 1];
        int idx = 0;

        int l = 0, r = 0;

        while (r < k) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            r++;
        }

        res[idx++] = map.lastKey();

        if (map.get(nums[l]) == 1) {
            map.remove(nums[l]);
        } else {
            map.put(nums[l], map.get(nums[l]) - 1);
        }
        l++;

        while (r < nums.length) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);

            res[idx++] = map.lastKey();
            if (map.get(nums[l]) == 1) {
                map.remove(nums[l]);
            } else {
                map.put(nums[l], map.get(nums[l]) - 1);
            }
            l++;
            r++;
        }

        return res;
    }
}
