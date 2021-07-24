class Solution {
public static int largestRectangleArea(int[] height) {
    if (height == null || height.length == 0) {
        return 0;
    }
    // idx of the first bar the left that is lower than current
    // その現在のIndexよりも最短の一番小さい左のインデックス
    int[] lessFromLeft = new int[height.length];
    // idx of the first bar the right that is lower than current
    // 今のindexよりも小さい右の最短のバーのインデックス
    int[] lessFromRight = new int[height.length]; 
    //圏外のバーのindex、右に今のバーよりも小さいバーのインデックスがない場合
    lessFromRight[height.length - 1] = height.length;
    //圏外のバーのindex、左にに今のバーよりも小さいバーのインデックスがない場合
    lessFromLeft[0] = -1;
    
    // 今のインデックスよりも小さい左のバーのインデックスを検証していく、
    // iが1始まり（右）、pが0始まり（左）で検証していく
    for (int i = 1; i < height.length; i++) {
        int p = i - 1;
        
        //Pの方が高い場合、過去に調べたpの最短の右のバーのindexをとの比較を繰り返していく
        while (p >= 0 && height[p] >= height[i]) {
            p = lessFromLeft[p];
        }
        lessFromLeft[i] = p;
    }

    for (int i = height.length - 2; i >= 0; i--) {
        int p = i + 1;

        while (p < height.length && height[p] >= height[i]) {
            p = lessFromRight[p];
        }
        lessFromRight[i] = p;
    }
    
    // 面積の計算をする
    // r(そのインデックスに対して最短の小さい右のインデックス) - l(そのインデックスに対して最短の小さい右のインデックス) - 1
    //例えば3つめのバーと１つめのバーの間の幅は1、3-1-1で計算できる。
    int maxArea = 0;
    for (int i = 0; i < height.length; i++) {
        maxArea = Math.max(maxArea, height[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
    }

    return maxArea;
}
}
