package src.com.anil;

public class AllocateBooksBinarySearch {
    public static void main(String[] args) {
        int[] arr = {25, 46, 28, 49, 24};
        int m = 4;
        int ans = allocate(arr,m);
        System.out.println(ans);
    }

    private static int allocate(int[] arr, int m) {
        if (m > arr.length){
            return -1;
        }
        int minPage = Integer.MIN_VALUE;
        int sum = 0;
        int ans = -1;
        for (int i = 0; i < arr.length; i++){
            minPage = Math.max(minPage,arr[i]);
            sum = sum + arr[i];
        }
        int start = minPage;
        int end = sum;

        while (start <= end){
            int mid = start + (end - start) / 2;
            int students = countOfStudents(arr,mid);
            if (students <= m){
                ans = mid;
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return ans;
    }

    private static int countOfStudents(int[] arr, int pages) {
        int students = 1;
        int pageStudents = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] + pageStudents <= pages){
                pageStudents = pageStudents + arr[i];
            }else {
                students = students + 1;
                pageStudents = arr[i];
            }
        }
        return students;
    }
}
