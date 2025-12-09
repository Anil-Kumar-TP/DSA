package src.com.anil;

public class SearchString {
    public static void main(String[] args) {
        String name = "Anil";
        char target = 'i';
        boolean ans = linearSearch(name,target);
        System.out.println(ans);
    }

    private static boolean linearSearch(String name, char target) {
        if (name.length() == 0){
            return false;
        }
        for (int i = 0; i < name.length(); i++){
            if (name.charAt(i) == target){
                return true;
            }
        }
        return false;
    }
}
