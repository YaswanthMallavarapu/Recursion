class Solution {
    public static void sum(int arr[], ArrayList<Integer> ans, int sum, int i) {
        if (i == arr.length) {
            ans.add(sum);
            return;
        } else {
            sum(arr, ans, sum + arr[i], i + 1);
            sum(arr, ans, sum, i + 1);
        }
    }

    public ArrayList<Integer> subsetSums(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        sum(arr, ans, 0, 0);
        Collections.sort(ans);
        return ans;
    }
}