class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magazineMap = new HashMap<>();
        for(char c : magazine.toCharArray()){
            if (magazineMap.containsKey(c)){
                magazineMap.put(c, magazineMap.get(c)+1);
            }else{
                magazineMap.put(c, 1);
            }
        }
        for(char c : ransomNote.toCharArray()){
            if(!magazineMap.containsKey(c) ||magazineMap.get(c) == 0 ){
                return false;
            }else{
                magazineMap.put(c, magazineMap.get(c)-1);
            }
        }
        return true;
    }
}