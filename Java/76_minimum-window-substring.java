import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        for (char c: t.toCharArray()){
            tMap.put(c, tMap.getOrDefault(c,0) +1);
        }
        Set<Character> tKeySet = tMap.keySet();
        int l = 0;
        int r = 0;
        int min = Integer.MAX_VALUE;
        int[] currentMin = {-1, -1};
        Map<Character, Integer> sMap = new HashMap<>();
        while (r < s.length()){
            if (tKeySet.contains(s.charAt(r))){
                sMap.put(s.charAt(r), sMap.getOrDefault(s.charAt(r),0) +1);
            }
            while (IsSatisfiedFreq(sMap, tMap)){
                if ((r-l+1) < min ){
                    currentMin[0] = l;
                    currentMin[1] = r;
                    min = r-l+1;
                }
                if (tKeySet.contains(s.charAt(l))) {
                    sMap.put(s.charAt(l), sMap.get(s.charAt(l)) - 1);
                    if (sMap.get(s.charAt(l)) == 0) {
                        sMap.remove(s.charAt(l));
                    }
                }
                l++;
            }
            r++;
        }
        return currentMin[0] == -1 ? "" : s.substring(currentMin[0], currentMin[1]+1);
    }
    public boolean IsSatisfiedFreq(Map<Character, Integer> sMap, Map<Character, Integer> tMap){
        for (Character c: tMap.keySet()){
            if (!sMap.containsKey(c) || sMap.get(c)< tMap.get(c)){
                return false;
            }
        }
        return true; 
    }
}