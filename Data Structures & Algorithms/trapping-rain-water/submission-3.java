class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int totalWater = 0;
        int leftMax = height[l], rightMax = height[r];

        while (l <r) {
            if (leftMax < rightMax) {
                l++;
                leftMax = Math.max(leftMax, height[l]);
                totalWater += leftMax - height[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, height[r]);
                totalWater += rightMax - height[r];
            }
        }
        return totalWater;
    }
}
