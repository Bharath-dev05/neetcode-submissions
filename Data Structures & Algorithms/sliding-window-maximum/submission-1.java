class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] res = new int[nums.length - k + 1];
        int idx = 0;

        int i = 0, j = 0;

        while (j < k) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            j++;
        }
        res[idx++] = map.lastKey();

        if (map.get(nums[i]) == 1) {
            map.remove(nums[i]);
        } else {
            map.put(nums[i], map.get(nums[i]) - 1);
        }
        i++;

        while (j < nums.length) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            res[idx++] = map.lastKey();
            if (map.get(nums[i]) == 1) {
                map.remove(nums[i]);
            } else {
                map.put(nums[i], map.get(nums[i]) - 1);
            }
            i++;
            j++;
        }

        return res;
    }
}
