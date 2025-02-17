import java.util.*;

public class KthPerumutation {
    public static String getting(int n, int k) {
        int fact = 1;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            fact *= i;
            ans.add(i);
        }
        ans.add(n);
        k = k - 1;
        String str = "";
        while (true) {
            str = str + ans.get(k / fact);
            ans.remove(k / fact);
            if (ans.size() == 0) {
                break;
            }
            k = k % fact;
            fact = fact / (ans.size());
        }
        return str;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String ans = getting(n, k);
        System.out.println(ans);
    }
}