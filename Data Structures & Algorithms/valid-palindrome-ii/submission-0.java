class Solution {
    public boolean validPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);

        if (isPal(sb))  return true;

        int l = 0;

        while (l < s.length()) {
            StringBuilder temp = new StringBuilder(s);
            
            if (isPal(temp.deleteCharAt(l++))){
                return true;
            }
        }

        return false;
    }


public boolean isPal(StringBuilder s) {
    int l = 0,
    r = s.length() - 1;
    while (l <= r) {
        if (s.charAt(l++) != s.charAt(r--))
            return false;
    }
    return true;
}
}