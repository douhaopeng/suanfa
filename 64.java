class Solution {
  public int minPathSum(int[][] grid) {
        // methods one : dynamic process (or can create another array arr[][])
        // int[][] arr = new int[grid.length][grid[0].length];
        for (int i = 1; i < grid.length; i++){
            grid[i][0] += grid[i - 1][0];
        }
        for (int j = 1; j < grid[0].length; j++){
            grid[0][j] += grid[0][j - 1];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }

        return grid[grid.length - 1][grid[0].length - 1];
    }

}
