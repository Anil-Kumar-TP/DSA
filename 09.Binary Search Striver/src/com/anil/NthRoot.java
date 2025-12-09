package src.com.anil;

//unlike square root qstn here it expects a perfect integer so need for flooring the value
public class NthRoot {
    public static void main(String[] args) {
        int m = 69;
        int n = 4;
        int ans = root(m,n);
        System.out.println(ans);
    }

    private static int root(int m, int n) {
        int start = 1;
        int end = m;
        while (start <= end){
            int mid = start + (end - start) / 2;
            long power = 1;
            for (int i = 1; i <= n; i++){
                power = power * mid;
                if (power > m){
                    break;
                }
            }
            if (power == m){
                return mid;
            }else if (power < m){
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
