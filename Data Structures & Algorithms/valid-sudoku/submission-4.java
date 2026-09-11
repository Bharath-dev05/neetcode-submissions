class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, HashSet<Character>> row = new HashMap<>();
        HashMap<Integer, HashSet<Character>> col = new HashMap<>();
        HashMap<String, HashSet<Character>> sq = new HashMap<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char val = board[r][c];
                if (val == '.')
                    continue;
                String key = (r / 3) +","+( c / 3);

                if (row.computeIfAbsent(r, k -> new HashSet<Character>()).contains(val)
                    || col.computeIfAbsent(c, k -> new HashSet<Character>()).contains(val)
                    || sq.computeIfAbsent(key, k -> new HashSet<Character>()).contains(val)) {
                    return false;
                }

                row.get(r).add(val);
                col.get(c).add(val);
                sq.get(key).add(val);
            }

        }
            return true;
    }
}
