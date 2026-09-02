class Solution {
    public String minWindow(String s, String t) {
        if(t.isEmpty() || s.length()<t.length()){
            return "";
        }

        HashMap<Character,Integer> sHash = new HashMap<>();
        HashMap<Character,Integer> tHash = new HashMap<>();

        for(char c : t.toCharArray()){
            tHash.put(c,tHash.getOrDefault(c, 0)+1);
        }

        int l=0,r=0;

        int minLength=Integer.MAX_VALUE;
        int minStart=0;

        while(r<s.length()){
            char c = s.charAt(r);

            sHash.put(c,sHash.getOrDefault(c, 0)+1);

            boolean valid = true;

            for(char ch : tHash.keySet()){
                if(sHash.getOrDefault(ch, 0)<tHash.get(ch)){
                    valid = false;
                    break;
                }
            }

            while(valid){
                if(r-l+1 < minLength){
                    minLength=r-l+1;
                    minStart=l;
                }
        
                char left = s.charAt(l);
                sHash.put(left, sHash.getOrDefault(left, 0)-1);
                l++;

                valid =true;

                for(char ch : tHash.keySet()){
                    if(sHash.getOrDefault(ch, 0)<tHash.get(ch)){
                        valid=false;
                        break;
                    }
                }
                
            }
            r++;

        }

        return (minLength == Integer.MAX_VALUE)?"":s.substring(minStart,minStart+minLength);

    }
}
