class Solution {
    public int[][] merge(int[][] intervals) {
        // 1: sort array first,
        // 2: keep cur start and cur end
        // 3: take interval, if it's overwrap, ( cur start < interval start)
        // keep the curstart and compare ends
        // 4: if it's not overwrap, start new interval for output

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        // uses LinkedList as easy to operate the end
        // also we don't know the final length. so can't use int[][] in this stage
        LinkedList<int[]> merged = new LinkedList<>();
        for(int[] interval : intervals){
            // overwrap?
            if(merged.isEmpty() || merged.getLast()[1] < interval[0]){
                merged.(interval);
            }else{
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
        
    }
}