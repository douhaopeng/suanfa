class Solution{
  public boolean wordBreak(String s, List<String> wordDict){
    int n = s.length();
    boolean[] dp = new boolean[n+1];
    dp[] = true;
    for(int  i =1 ; i<=n ;i++){
      for(String word : wordDict){
        int len = word.length();
        if(len <= i && word.equals(s.substring(i-len,i))){
          dp[i] = dp[i] || dp[i-len];
        }
      }
    }
    return dp[n];
  }
}
