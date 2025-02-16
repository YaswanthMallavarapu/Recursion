class Solution {
    // Function to find all possible paths

    public static void solve(ArrayList<ArrayList<Integer>> mat, int row, int col, int n, int m, ArrayList<String> ans,
            String str, boolean visited[][]) {
        if (row == n - 1 && col == m - 1) {
            ans.add(str);
            return;
        } else {
            visited[row][col] = true;
            if (row + 1 < n && !visited[row + 1][col] && mat.get(row + 1).get(col) == 1) {

                solve(mat, row + 1, col, n, m, ans, str + "D", visited);

            }
            if (col - 1 >= 0 && !visited[row][col - 1] && mat.get(row).get(col - 1) == 1) {

                solve(mat, row, col - 1, n, m, ans, str + "L", visited);

            }
            if (col + 1 < m && !visited[row][col + 1] && mat.get(row).get(col + 1) == 1) {

                solve(mat, row, col + 1, n, m, ans, str + "R", visited);

            }
            if (row - 1 >= 0 && !visited[row - 1][col] && mat.get(row - 1).get(col) == 1) {

                solve(mat, row - 1, col, n, m, ans, str + "U", visited);

            }
            visited[row][col] = false;

        }
    }

    public ArrayList<String> findPath(ArrayList<ArrayList<Integer>> mat) {
        ArrayList<String> ans = new ArrayList<>();
        boolean visited[][] = new boolean[mat.size()][mat.get(0).size()];
        if (mat.get(0).get(0) == 1)
            solve(mat, 0, 0, mat.size(), mat.get(0).size(), ans, "", visited);
        return ans;
    }
}