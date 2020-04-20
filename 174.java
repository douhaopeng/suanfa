class Solution{

  public int calculateMinimumHP(int [][] dungeon){
    int rows = dungeon.length;
    int cols = dungeon[0].length;
    int[][] dp = new int[rows+1][cols+1];
    for(int  i =0;i<=rows;i++){
      Arrays.fill(dp[i],Integer.MAX_VALUE);
    }
    dp[rows][cols-1] = 1;
    dp[rows - 1][cols] = 1;
    for(int i  =rows-1;i>=0;i--){
      for(int j = cols - 1;j>=0;j--){
        //当dungeon[i][j]是负数 dp[i][j]将变大  是至少需要的生命值
        //当dungeon[i][j]是正数dp[][]会缩小
        //但要保证不违反题意即生命值不能降到1以下
        int min = Math.min(dp[i][j+1],dp[i+1][j])- dungeon[i][j];
        dp[i][j] = min <=0 ? 1:min;
      }
    }
    return dp[0][0];
  }
}
