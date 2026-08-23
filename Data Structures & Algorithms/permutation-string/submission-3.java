class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] orgCount = new int[26];

        for (int i = 0; i < s1.length(); i++) orgCount[s1.charAt(i) - 'a']++;

        for(int i=0;i<=s2.length()-s1.length();i++){
            int[] temp = new int[26];
            String sub = s2.substring(i,i+s1.length());
            for(char ch :sub.toCharArray() ){
                temp[ch-'a']++;
            }
            if(Arrays.equals(orgCount,temp)){
                return true;
            }
        }
        return false;
    }
}
