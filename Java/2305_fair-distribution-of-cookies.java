class Solution {
    int max = Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
        int[] distribute = new int[k];
        dfs(cookies, k, 0, distribute);
        return max;
    }
    public void dfs(int[] cookies, int k, int idx,  int[] distribute ){
        int ans = 0;
        if(idx == cookies.length){
            for(int num: distribute){
                ans = Math.max(ans, num);
            }
            max = Math.min(max, ans);
            return;
        }
        
        for(int i = 0; i<distribute.length; i++){
            distribute[i] += cookies[idx];
            dfs(cookies, k, idx +1, distribute);
            distribute[i] -= cookies[idx];
        }
    }
}