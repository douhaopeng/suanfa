class Solution{
  public int lengthOfLIS(int[] nums){
    if(nums.length == 0 || nums.length ==1){
      return nums.length;
    }
    int [] dp = new int[nums.length];
    int LIS = 1;
    dp[0] = 1;
    for(int i = 1; i<dp.length;i++){
      dp[i] = 1;
      for(int j  =0;j<i;j++){
        if(nums[i] >nums[j]){
          dp[i] = Math.max(dp[i],dp[j]+1);
        }
        if(dp[i] > LIS){
          LIS = dp[i];
        }
      }
    }
    return LIS;
  }
}
