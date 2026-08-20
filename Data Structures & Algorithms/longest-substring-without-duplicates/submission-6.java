class Solution {
    public int lengthOfLongestSubstring(String s) {

        
if(s.length()==1 || s.length()==0) return s.length();
        // if(s=="")return 0;
        HashSet<Character> set = new HashSet<>();
        int maxLen=0;
        int l=0;

        for(int r=0;r<s.length();r++){
            char ch=s.charAt(r);
            
                while(set.contains(s.charAt(r))){
                    set.remove(s.charAt(l));
                    l++;
                }
                set.add(s.charAt(r));
                maxLen=Math.max(maxLen,r-l+1);
          
        }
        return maxLen;


    }
}
