
// Divide and conquer
import java.util.HashSet;
import java.util.Set;

class Solution {
    public String longestNiceSubstring(String s) {

        int len = s.length();
        Set<Character> set = new HashSet<>();
        for(Character c: s.toCharArray()){
            set.add(c);
        }

        for(int i = 0; i< len; i++){
            char c = s.charAt(i);
            if(set.contains(Character.toLowerCase(c)) &&
                    set.contains(Character.toUpperCase(c))){
                continue;
            }
            String sub1= longestNiceSubstring(s.substring(0,i));
            String sub2= longestNiceSubstring(s.substring(i+1));
            return sub1.length() >= sub2.length()?sub1:sub2;
        }
        return s;
    }
}
// Brute force
class Solution {
    public String longestNiceSubstring(String s) {
        String res = "";
        for(int i =0; i< s.length() ;i++){
            for(int j = i+1; j< s.length();j++){
                String sub = s.substring(i, j+1);
                if(isNice(sub) && sub.length() > res.length()){
                    res = sub;
                }
            }
        }
        return res;

    }
    private boolean isNice(String sub){
        Set<Character> cSet = new HashSet<>();
        for(char c : sub.toCharArray()){
            cSet.add(c);
        }
        for(char c : sub.toCharArray()){
            if(Character.isLowerCase(c)){
                if(!cSet.contains(Character.toUpperCase(c))){
                    return false;
                }
            }
            if(Character.isUpperCase(c)){
                if(!cSet.contains(Character.toLowerCase(c))){
                    return false;
                }
            }
        }
        return true;
    }
}