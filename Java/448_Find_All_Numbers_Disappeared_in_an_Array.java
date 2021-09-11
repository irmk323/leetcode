// Time:O(N)
// Space:O(1)

=========================================================
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        for (int i = 0; i < nums.length; i++) {
            int newIndex = Math.abs(nums[i]) - 1;

            if (nums[newIndex] > 0) {
                nums[newIndex] *= -1;
            }
        }
        
        List<Integer> result = new LinkedList<Integer>();
        
        for (int i = 1; i <= nums.length; i++) {
            
            if (nums[i - 1] > 0) {
                result.add(i);
            }
        }
        
        return result;
    }
}

=========================================================
// Time:O(N)
// Space:O(N)

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        HashMap<Integer, Boolean> hashTable = new HashMap<Integer, Boolean>();
        
        for (int i = 0; i < nums.length; i++) {
            hashTable.put(nums[i], true);
        }
        
        List<Integer> result = new LinkedList<Integer>();
        
        for (int i = 1; i <= nums.length; i++) {
            if (!hashTable.containsKey(i)) {
                result.add(i);
            }
        }
        
        return result;
    }
}
=============================================================
