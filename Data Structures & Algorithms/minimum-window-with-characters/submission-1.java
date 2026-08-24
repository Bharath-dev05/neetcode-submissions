class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty() || s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> tHash = new HashMap<>();
        Map<Character, Integer> sHash = new HashMap<>();

        for (char c : t.toCharArray()) {
            tHash.put(c, tHash.getOrDefault(c, 0) + 1);
        }

        int i = 0;
        int j = 0;

        int minLength = Integer.MAX_VALUE;
        int minStart = 0;

        while (j < s.length()) {
            // Expand the window
            char c = s.charAt(j);
            sHash.put(c, sHash.getOrDefault(c, 0) + 1);

            // Check if current window contains everything
            boolean valid = true;

            for (char ch : tHash.keySet()) {
                if (sHash.getOrDefault(ch, 0) < tHash.get(ch)) {
                    valid = false;
                    break;
                }
            }

            // Shrink while valid
            while (valid) {
                if (j - i + 1 < minLength) {
                    minLength = j - i + 1;
                    minStart = i;
                }

                char left = s.charAt(i);

                sHash.put(left, sHash.get(left) - 1);
                i++;

                // Check again
                valid = true;

                for (char ch : tHash.keySet()) {
                    if (sHash.getOrDefault(ch, 0) < tHash.get(ch)) {
                        valid = false;
                        break;
                    }
                }
            }

            j++;
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
    }
}
