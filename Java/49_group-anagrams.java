class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            int[] key = new int[26];
            for(int c: s.toCharArray()){
                key[c - 'a']++;
            }
            String sig = Arrays.toString(key);
            map.putIfAbsent(sig, new ArrayList<>());
            map.get(sig).add(s);
        }
        return new ArrayList<>(map.values());
        
    }
}

// make a key with int[26]
// put into map
// return only values