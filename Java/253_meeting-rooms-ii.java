class Solution {
    public int minMeetingRooms(int[][] intervals) {
        List<Integer> starts = new ArrayList<>();
         List<Integer> ends = new ArrayList<>();
         for(int[] interval : intervals){
             starts.add(interval[0]);
             ends.add(interval[1]);
         }
         Collections.sort(starts);
         Collections.sort(ends);
         int startIdx =0, endIdx =0, curRoom =0, minRoom = 0;

        //  [1, 8, 8]
        //  [5, 9, 9]
         while(startIdx < intervals.length){
             if(starts.get(startIdx) < ends.get(endIdx)){
                 curRoom++; //1
                 startIdx++; // 1
             }else{
                 curRoom--; // 0
                 endIdx++; // 1
             }
             minRoom = Math.max(curRoom, minRoom);
         }
        return minRoom;
    }
}

// 1 ---5
//        8-9
//        8-9