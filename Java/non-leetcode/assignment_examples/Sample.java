class Sample {

    public static void main(String[] args) {
        int[] arr =  {0,1,2,3,4,5,6, 5};
        System.out.println(peakIndexInMountainArray(arr));
    }
    public static int peakIndexInMountainArray(int[] arr) {
        
        int left = 0, right = arr.length -1;
        while(left <= right){
            int mid = (left+ right) /2;
            if(arr[mid] > arr[mid+1]){
                right = mid-1;
            }else{
                left = mid+1;

            }
        }
        return left;
    }
}