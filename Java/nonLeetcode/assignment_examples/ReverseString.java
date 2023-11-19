package nonLeetcode.assignment_examples;

import java.util.Arrays;

class ReverseString{
    public static void main(String[] args) {
        String str = "hariprasan.th";
        char[] charArray = str.toCharArray();
        int left = 0, right = charArray.length -1;
        while( left < right){
            if( charArray[left] == '.' ){
                left ++;
            }
            if(charArray[right] == '.'){
                right--;
            }
            swap(left, right, charArray);
            left++;
            right--;
        }
        String ans = String.valueOf(charArray);
        System.out.println(ans);
    }
    public static void swap(int left, int right, char[] charArray){
        char temp = charArray[left];
        charArray[left] = charArray[right];
        charArray[right] = temp;
    }
    
}