class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] ar = s.toCharArray();
            Arrays.sort(ar);

            String key = new String(ar);

            if (!map.containsKey(key)) {
                map.put(key,new ArrayList<String>());
            }

            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
