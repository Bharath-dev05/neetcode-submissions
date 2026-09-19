class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length + nums2.length;
        int[]arr = new int[n];
        int idx=0;
        for(int i:nums1){
            arr[idx++]=i;
        }

        for(int j:nums2){
            arr[idx++]=j;
        }

        Arrays.sort(arr);
        double res=0;

        if(n%2==0){
            int i=n/2;
            res =(double) (arr[i]+arr[i-1])/2;
        }else{
            res=(double)arr[n/2];
        }

        return res;
    }
}
