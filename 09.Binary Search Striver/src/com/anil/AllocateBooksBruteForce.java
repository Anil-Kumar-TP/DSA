package src.com.anil;

public class AllocateBooksBruteForce {
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
        int minPages = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            minPages = Math.max(minPages,arr[i]);
            sum = sum + arr[i];
        }
        for (int pages = minPages; pages <= sum; pages++){
            if (countStudents(arr,pages) == m){
                return pages;
            }
        }
        return minPages;
    }

    private static int countStudents(int[] arr, int pages) {
        int students = 1;
        int pageStudent = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] + pageStudent <= pages){
                pageStudent = pageStudent + arr[i];
            }else {
                students = students + 1;
                pageStudent = arr[i];
            }
        }
        return students;
    }
}
