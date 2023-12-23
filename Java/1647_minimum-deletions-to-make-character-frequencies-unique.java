

// O(N+K^2)
// class Solution {
//     public int minDeletions(String s) {
//         Map<Character, Integer> freq = new HashMap<>();
//         for(char c : s.toCharArray()){
//             freq.put(c, freq.getOrDefault(c, 0)+1);
//         }
//         int res= 0;
//         Set<Integer> uniqueSet = new HashSet<>();
//         for(Map.Entry<Character, Integer> entry : freq.entrySet()){
//             while(entry.getValue() > 0 && uniqueSet.contains(entry.getValue())){
//                 freq.put(entry.getKey(), entry.getValue() -1); 
//                 res++;
//             }
//             uniqueSet.add( entry.getValue());
//         }
//         return res;
//     }
// }