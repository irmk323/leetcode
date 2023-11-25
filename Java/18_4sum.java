class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        HashSet<List<Integer>> hset = new HashSet<>();
        int n = nums.length;
        for(int i=0 ; i < n -3; i++){
            for(int j=i+1 ;j < n -3;j++){
                int k = j+1;
                int l = n-1;
                while(k < l){
                    long sum = LongStream.of(nums[i], nums[j],nums[k],nums[l]).sum();
                    if(sum < target){
                        k++;
                    }else if(sum > target){
                        l--;
                    }else{
                        List<Integer> elems = new ArrayList<>();
                        elems.add(nums[i]);
                        elems.add(nums[j]);
                        elems.add(nums[k]);
                        elems.add(nums[l]);
                        if(!hset.contains(elems)){
                            hset.add(elems);
                            res.add(elems);
                        }
                        k++;
                        l--;
                    }
                }
            }
        }
        return res;
        
    }
}