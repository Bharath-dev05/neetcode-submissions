class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0, curSum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        for (int num : nums) {
            curSum += num;
            int diff = curSum - k;
            count += map.getOrDefault(diff, 0);
            map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        }

        return count;
    }
}