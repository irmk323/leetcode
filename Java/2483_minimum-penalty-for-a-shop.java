class Solution {
    public int bestClosingTime(String customers) {
      //assume that it closes at 0index
      int curPenalty = calcAllclosedPenalty(customers);

      int min = curPenalty;
      int earliestHour = 0;
      for(int i = 0; i< customers.length(); i++){
        // start from 1st index, meaning moving the border to 0 to 1st.
        // left on border is open, right is still closed.
        char c= customers.charAt(i);
        if(c == 'Y'){
          // c is now on left, open + y is no penalty.
          curPenalty--;
        }else{
          // open but N means having penalty.
          curPenalty++;
        }

        if(curPenalty < min){
          earliestHour = i+1; // index start from 0, but border means i+1 th hour;
          min  = curPenalty;
        }
      }
      return earliestHour;
    }

    private int calcAllclosedPenalty(String customers){
      int curPenalty = 0;
      for(char c: customers.toCharArray()){
        if(c ==  'Y'){
          curPenalty++;
        }
      }
      return curPenalty;
    }
}