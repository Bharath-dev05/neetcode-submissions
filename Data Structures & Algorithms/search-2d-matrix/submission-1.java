class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            int st = matrix[i][0];
            int end = matrix[i][matrix[i].length - 1];

            if (target >= st && target <= end) {
                int l = 0;
                int r = matrix[i].length - 1;
                while(l<=r){
                    int mid = (l + r) / 2;

                if (matrix[i][mid] == target) {
                    return true;
                } else if (matrix[i][mid] > target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
                }
            }

        }
            return false;
    }
}
