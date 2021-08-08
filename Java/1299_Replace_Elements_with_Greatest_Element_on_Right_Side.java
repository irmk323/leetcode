// Time O(N)
// Space O(1)

class Solution {
    public int[] replaceElements(int[] arr) {
        int mx = -1, n = arr.length, a;
        for (int i = n - 1; i >= 0; --i) {
            a = arr[i];
            arr[i] = mx;
            mx = Math.max(mx, a);
        }
        return arr;        
    }
}
