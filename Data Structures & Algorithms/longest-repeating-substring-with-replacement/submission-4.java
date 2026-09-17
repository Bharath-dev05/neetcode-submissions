class Solution {
    public int characterReplacement(String s, int k) {
        int maxLength=0;
        int maxFreq=0;
        int i=0,j=0;
        HashMap<Character,Integer> map = new HashMap<>();

        while(j<s.length()){
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);

            if(map.get(s.charAt(j))>maxFreq){
                maxFreq=map.get(s.charAt(j));
            }

            if((j-i+1)-maxFreq<=k && (j-i+1)>maxLength){
                maxLength=j-i+1;
            }else{
                map.put(s.charAt(i),map.get(s.charAt(i))-1);
                maxFreq=0;
                for(char key : map.keySet()){
                    maxFreq=Math.max(maxFreq,map.get(key));
                }
                i++;
            }
            j++;
        }
        return maxLength;
    }
}
