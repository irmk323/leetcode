// Time O(n)
//Space O(1)

class Solution {
public int thirdMax(int[] nums) { 
//   not allow to input duplicated value, no order
    Set<Integer> maximums = new HashSet<Integer>();
    for (int num : nums) {
        maximums.add(num);
        if (maximums.size() > 3) {
            maximums.remove(Collections.min(maximums));
        }
    }
    if (maximums.size() == 3) {
        return Collections.min(maximums);
    }
//   if original is array size is less than 3
    return Collections.max(maximums);
}
}
