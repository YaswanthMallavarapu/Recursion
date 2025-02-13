//Approach 1
class Solution {
    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void peru(int arr[], List<List<Integer>> result, int j, int n) {
        if (j == n) {
            List<Integer> ans = new ArrayList<>();
            for (int a : arr) {
                ans.add(a);
            }
            result.add(ans);
            return;
        } else {
            for (int i = j; i < n; i++) {
                swap(arr, i, j);

                peru(arr, result, j + 1, n);

                swap(arr, i, j);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        peru(nums, result, 0, nums.length);
        return result;
    }
}

// Approach 2
class Solution {
    public static void peru(int arr[], List<List<Integer>> result, List<Integer> ans, int j, boolean taken[]) {
        if (j == arr.length) {
            result.add(new ArrayList<>(ans));
            return;
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (taken[i] != true) {
                    ans.add(arr[i]);
                    taken[i] = true;
                    peru(arr, result, ans, j + 1, taken);
                    ans.remove(ans.size() - 1);
                    taken[i] = false;
                }
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        peru(nums, result, ans, 0, new boolean[nums.length]);
        return result;
    }
}