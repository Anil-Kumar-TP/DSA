package src.com.anil;

public class LetterWrapAround {
    public static void main(String[] args) {
        char[] letters = {'c', 'f', 'j'};
        char target = 'd';
        char ans = letter(letters, target);
        System.out.println(ans);
    }

    private static char letter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < letters[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (target >= letters[letters.length - 1]) {
            return letters[0];
        }else{
            return letters[start];
        }
    }
}