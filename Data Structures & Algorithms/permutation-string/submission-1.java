class Solution {
    public boolean isAnagram(String str1, String str2) {
        char[] ar1 = str1.toCharArray();
        char[] ar2 = str2.toCharArray();
        Arrays.sort(ar1);
        Arrays.sort(ar2);

        return Arrays.equals(ar1, ar2);
    }

    public boolean checkInclusion(String s1, String s2) {
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            String sub = s2.substring(i, i + s1.length());
            if (isAnagram(sub, s1))
                return true;
        }

        return false;
    }
}
