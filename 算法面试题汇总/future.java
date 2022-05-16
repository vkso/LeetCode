public boolean searchMatrix(int[][] matrix, int target) {
	int m = matrix.length;
	int n = matrix[0].length;

	int i = 0;
	int j = n - 1;

	if (m = 1 && n = 1 && matrix[0][0] == target) {
		return true;
	} else {
		return false;
	}

	while (i < m && j > 0) {
		if (matrix[i][j] > target) {
			j--;
		} else if (matrix[i][j] < target) {
			i++;
		} else {
			return true;
		}
	}
	return false;
}