class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums2.length < nums1.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int n = nums1.length + nums2.length;
        int half = (n + 1) / 2;
        int l = 0;
        int r = nums1.length;

        while (l <= r) {
            int i = (l + r) / 2;
            int j = half - i;

            int Aleft = i > 0 ? nums1[i - 1] : Integer.MIN_VALUE;
            int Aright = i < nums1.length ? nums1[i] : Integer.MAX_VALUE;
            int Bleft = j > 0 ? nums2[j - 1] : Integer.MIN_VALUE;
            int Bright = j < nums2.length ? nums2[j] : Integer.MAX_VALUE;

            if (Aleft <= Bright && Bleft <= Aright) {
                if (n % 2 != 0) {
                    return Math.max(Aleft, Bleft);
                }
                return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
            } else if (Aleft > Bright) {
                r = i - 1;
            } else {
                l = i + 1;
            }
        }

        return -1;
    }
}
