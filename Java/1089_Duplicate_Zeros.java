
// 1 ms
class Solution {
public void duplicateZeros(int[] arr) {
        int countZero = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) countZero++;
        }
        int len = arr.length + countZero;
    //新規の配列を作成しない、iはオリジナルの配列でjは新しい場所を示す
        for (int i = arr.length - 1, j = len - 1; i < j; i--, j--) {
            if (arr[i] != 0) {
                if (j < arr.length) arr[j] = arr[i];
            } else {
                if (j < arr.length) arr[j] = arr[i];
                j--;
                //0の時は2回コピーする
                if (j < arr.length) arr[j] = arr[i]; 
            }
        }
    }  
}

// this solution takes 14ms
class Solution {
public void duplicateZeros(int[] arr) {
int n=arr.length;
    for(int i=0;i<n-1;i++)
    {
        if(arr[i]==0)
        {
        for(int j=n-1;j>i+1;j--)
            {
            arr[j]=arr[j-1];
            }
        arr[i+1]=0;
        i++;
        }
    }
    }   
}
