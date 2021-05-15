class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int counter = 0;
        for(String s : words){
            boolean isValid = true;
            for (char ch : s.toCharArray()){
                if(!allowed.contains(String.valueOf(ch))){
                    isValid = false;
                }
            }
            if(isValid) counter++;
        }
        return counter;
    }
    
}
