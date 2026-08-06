class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int n :nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }

        List<int[]> list = new ArrayList<>();

        for(int i : map.keySet()){
            list.add(new int[]{map.get(i),i});
        }

        list.sort((a,b)->b[0]-a[0]);

        int[] res = new int[k];

        for(int i=0;i<k;i++){
            res[i]=list.get(i)[1];
        }

        return res;
    }
}
