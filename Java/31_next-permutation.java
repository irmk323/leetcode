class Solution {
    public void nextPermutation(int[] nums) {
        int pivot = -1;
        int replaceIdx = -1;
        // find a place of pivot, 124851 in this case 4.
        for (int r = nums.length - 1; r > 0; r--) {
            if (nums[r - 1] < nums[r]) {
                pivot = r - 1;
                break;
            }
        }
        // edge case of 123 and doesn't need to swap
        if (pivot == -1) {
            reversePart(nums, 0);
        } else {
            // find the closest num to the pivot
            // 124321 in this case
            for (int l = nums.length - 1; l > pivot; l--) {
                if (nums[pivot] < nums[l]) {
                    replaceIdx = l;
                    break;
                }
            }
            swap(nums, pivot, replaceIdx);
            reversePart(nums, pivot + 1); // Reverse the part after the pivot.
        }
    }

    public void reversePart(int[] nums, int start) {
        int i = start;
        int j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
