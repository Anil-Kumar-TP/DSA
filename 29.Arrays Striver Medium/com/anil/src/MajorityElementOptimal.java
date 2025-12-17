package com.anil.src;

//moore's voting algorithm.
public class MajorityElementOptimal {
    public static void main(String[] args) {
        int[] arr = {7, 0, 0, 1, 7, 7, 2, 7, 7};
        int ans = majority(arr);
        System.out.println(ans);
    }

    private static int majority(int[] arr) {
        int count = 0;
        int element = 0;

        for (int i = 0; i < arr.length; i++){
            if (count == 0){
                count++;
                element = arr[i];
            }else if (element == arr[i]){
                count++;
            }else {
                count--;
            }
        }

        //verification:cus this algo do not necessarily state that the number in the element is the majority
        //rather if there is a majority then it will be in the element
        //so in our example element will have 7 with it in the element
        //but we need to verify with a count check
        //if the qstn mentions there will a sure majority,then we dont have to have this verification
        //we can directly return the element.
        int count1 = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == element){
                count1++;
            }
        }

        if (count1 > arr.length / 2){
            return element;
        }

        return -1;
    }
}
