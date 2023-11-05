class Solution {
    // sort and pointer
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0 , right  = people.length - 1, ans = 0;
        while(left <= right ){
            int remain = limit - people[right];
            if(people[left] <= remain){
                left++;
            }
            ans++;
            right--;
        }
        return ans;       
    }
}