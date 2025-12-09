package src.com.anil;

public class SquareRoot {
    public static void main(String[] args) {
        int n = 28;
        int ans = root(n);
        System.out.println(ans);
    }

    private static int root(int n) {
        int ans = 0;
        int start = 1;
        int end = n;
        while (start <= end){
            int mid = start + (end - start) / 2;
            if ((long) mid * mid <= n){
                ans = mid;
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return ans;
    }
}
