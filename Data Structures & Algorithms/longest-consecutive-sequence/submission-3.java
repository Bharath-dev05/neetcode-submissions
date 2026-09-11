class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int i : nums){
            set.add(i);
        }

        int maxLen=0;

        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i]-1)){
                int length=1;
                while(set.contains(nums[i]+length)){
                    length++;
                }
                maxLen = Math.max(maxLen,length);
            }
        }

        return maxLen;
    }
}
