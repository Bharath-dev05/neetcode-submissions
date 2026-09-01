class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int l=0,n=temperatures.length;
        int res [] = new int[n];
        int idx=0;

        while(l<n-1){
            int r=l+1;

            while(r<n){
                if(temperatures[r]>temperatures[l]){
                    break;
                }
                r++;
            }

            res[idx++]=(r==n)?0:r-l;
            l++;
        }

        return res;
    }
}
