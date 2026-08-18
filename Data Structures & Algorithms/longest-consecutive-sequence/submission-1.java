class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int x : nums) {
            set.add(x);
        }
        Arrays.sort(nums);
        int maxLen = 0;

        for (int i : nums) {
            if(!set.contains(i-1)){
                int length = 1;
                while(set.contains(i+length)){
                    length++;
                }
                maxLen=Math.max(maxLen,length);
            }
        }
        return maxLen;
    }
}
