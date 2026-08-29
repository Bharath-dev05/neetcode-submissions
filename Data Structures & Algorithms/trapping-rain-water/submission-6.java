class Solution {
    public int trap(int[] height) {
        int l=0,r=height.length-1;
        int leftMax=Integer.MIN_VALUE,rightMax=Integer.MIN_VALUE;
        int totalWater=0;

        while(l<r){
            leftMax=Math.max(leftMax,height[l]);
            rightMax=Math.max(rightMax,height[r]);

            if(leftMax<rightMax){
                totalWater+=leftMax-height[l];
                l++;
            }else{
                totalWater+=rightMax-height[r];
                r--;
            };
        }
        return totalWater;

    }
}
