class Solution {
    public String reverseVowels(String s) {
        int left = 0, right = s.length()-1;
         String vowels = "aeiouAEIOU";
        char[] charArray =  s.toCharArray();
        while(left < right){

            while(left < right && vowels.indexOf(charArray[left]) == -1){
                left++;
            }

            while(left < right && vowels.indexOf(charArray[right]) == -1){
                right--;
            }

            char temp = s.charAt(left);
            charArray[left] = charArray[right];
            charArray[right] = temp;
        
            left++;
            right--;
        }
        String str = new String(charArray);
        return str;
    }
}