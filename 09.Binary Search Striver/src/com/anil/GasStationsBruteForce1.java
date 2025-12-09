package src.com.anil;

public class GasStationsBruteForce1 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int k = 4;
        double ans = gas(arr,k);
        System.out.println(ans);
    }

    private static double gas(int[] arr, int k) {
        int[] howMany = new int[arr.length - 1];
        for (int stations = 1; stations <= k; stations++){
            double maxSection = -1;
            int maxIndex = -1;
            for (int i = 0; i < arr.length - 1; i++){
                double difference = arr[i + 1] - arr[i];
                double sectionLength = difference / (double) (howMany[i] + 1);
                if (sectionLength > maxSection){
                    maxSection = sectionLength;
                    maxIndex = i;
                }//minimize section is happening here.finding the biggest section and placing the station
            }
            howMany[maxIndex] = howMany[maxIndex] + 1;
        }

        double maxAns = -1;
        for (int i = 0; i < arr.length - 1; i++){
            double difference = arr[i + 1] - arr[i];
            double sectionLength = difference / (double) (howMany[i] + 1);
            maxAns = Math.max(maxAns,sectionLength);
        }
        return maxAns;
    }
}

//Each iteration reduces the largest gap (the current maximum section).
//By the end of all k placements, the largest remaining gap (i.e., maxAns) will be as small as possible.