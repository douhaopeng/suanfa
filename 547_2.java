public class Solution{

  public  int findCircleNum(int [][] M){
    boolean visited[] = new boolean[M.length];
    int cycle = 0;
    for(int i  =0; i<M.length;i++){
      if(!visited[i]){
        cycle++;
        visited[i] = true;
        dfs(M,visited,i);
      }
    }
    return cycle;
  }
  public void dfs(int[][] M,boolean[] visited,int i){
    for(int j = 0;j<M[0].length;j++){
      if(!visited[j] && M[i][j] ==1){
        visited[j] = true;
        dfs(M,visited,j);
      }
    }
  }
}
