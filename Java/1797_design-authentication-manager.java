class AuthenticationManager {
    Map<String, Integer> tokenMap = new HashMap<>();
    int ttl;
   public AuthenticationManager(int timeToLive) {
      ttl  = timeToLive;
   }

   public void generate(String tokenId, int currentTime) {
       tokenMap.put(tokenId,currentTime + ttl );
   }
   
   public void renew(String tokenId, int currentTime) {
       if ( tokenMap.containsKey(tokenId) && tokenMap.get(tokenId) > currentTime){
           tokenMap.put(tokenId, currentTime+ ttl);
       }
       return;
       
   }
   public int countUnexpiredTokens(int currentTime) {
     int count = 0;
       for(String e : tokenMap.keySet())
           if(tokenMap.get(e) > currentTime)
               count++;
       return count;
   }
}

/**
* Your AuthenticationManager object will be instantiated and called as such:
* AuthenticationManager obj = new AuthenticationManager(timeToLive);
* obj.generate(tokenId,currentTime);
* obj.renew(tokenId,currentTime);
* int param_3 = obj.countUnexpiredTokens(currentTime);
*/