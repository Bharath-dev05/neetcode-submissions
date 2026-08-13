class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // 2p s2
        int l = 0;
        int r = numbers.length - 1;
        int currSum = numbers[l] + numbers[r];

        while (currSum != target) {
            if (currSum > target) {
                r--;
            } else {
                l++;
            }
            currSum = numbers[l] + numbers[r];
        }

        return new int[]{l+1,r+1};
    }
}
