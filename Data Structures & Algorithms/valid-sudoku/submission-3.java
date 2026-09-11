class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int row = 0; row < 9; row++) {
            HashSet<Character> set = new HashSet<>();

            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.')
                    continue;
                if (set.contains(board[row][col]))
                    return false;
                set.add(board[row][col]);
            }
        }

        for (int col = 0; col < 9; col++) {
            HashSet<Character> set = new HashSet<>();

            for (int row = 0; row < 9; row++) {
                if (board[row][col] == '.')
                    continue;

                if (set.contains(board[row][col]))
                    return false;
                set.add(board[row][col]);
            }
        }

        for (int sq = 0; sq < 9; sq++) {
            HashSet<Character> set = new HashSet<>();

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int row = (sq / 3) * 3 + i;
                    int col = (sq % 3) * 3 + j;

                    if (board[row][col] == '.')
                        continue;

                    if (set.contains(board[row][col]))
                        return false;

                    set.add(board[row][col]);
                }
            }
        }

        return true;
    }
}
