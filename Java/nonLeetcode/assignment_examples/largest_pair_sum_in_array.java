public class LargestPairSum {
 
    public static void main(String[] args)
    {

        int arr[] = { 12, 34, 10, 6, 40};
        System.out.println(largestPairSum(arr));
    }
 
    private static int largestPairSum(int[] arr)
    {
        int j = 0;
        int max = n == 1 ? arr[0] + arr[1] : arr[0];
        for (int i = 0; i < n; i++) {
            int sum = arr[j] + arr[i];
            if (sum > max) {
                max = sum;
                if (arr[j] < arr[i]) {
                    j = i;
                }
            }
        }
        return max;
    }
}

