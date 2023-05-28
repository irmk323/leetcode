class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        for(int[] ivs: intervals){
            // [new interval][existing intervals]
            if (newInterval[1]< ivs[0]){
                result.add(newInterval);
                newInterval = ivs; // still have a possibility to merge next intervals

            // [existing interval][new interval]
            }else if(ivs[1] < newInterval[0]){
                result.add(ivs); // ivs is guaranteed to be first, new interval can be mergd to the next one 
            //compares edge
            }else{
                newInterval[0] = Math.min(newInterval[0], ivs[0]);
                newInterval[1] = Math.max(newInterval[1], ivs[1]);
            }
        }
        result.add(newInterval);
        return result.toArray(new int[result.size()][]);
    }
}
