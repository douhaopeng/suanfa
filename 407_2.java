public class Solution{
public int trapRainWater(int[][] heightMap){
  if(heightMap == null || heightMap.length<3 || heightMap[0].length<3){

    return 0;
  }
  int m =  heightMap.length;
  int n = heightMap[0].length;
  boolean [][] visited = new boolean[m][n];
  PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>(1, new Comparator<Cell>(){
    public  int compare(Cell c1, Cell c2){
      return  c1.height - c2.height;
    }
  });
  for (int i = 0;i<m ;i++ ) {
    visited[i][0] = true;
    visited[i][n-1] = true;
    minHeap.offer(new Cell(i,0,heightMap[i][0]));
    minHeap.offer(new Cell(i,n-1,heightMap[i][n-1]));
  }
  for (int j = 0;j<n ;j++ ) {
    visited[0][j] = true;
    visited[m-1][j] = true;
    minHeap.offer(new Cell(0,j,heightMap[0][j]));
    minHeap.offer(new Cell(m-1,j,heightMap[m-1][j]));
  }

  int res= 0;
  int [][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
  while (!minHeap.isEmpty()) {
    Cell c= minHeap.poll();
    for(int[] dir: dirs){
      int x=  c.i+dir[0];
      int y = c.j +dir[1];

      if(x>=0 && x<m && y>=0 && y<n && !visited[x][y]){
        visited[x][y] = true;
        res += Math.max(c.height,heightMap[x][y]) - heightMap[x][y];
        minHeap.offer(new Cell(x,y,Math.max(c.height,heightMap[x][y])));
      }
    }
  }
}

}

class Cell{

  int i,j, height;
  public Cell(int i,int j,int height){
    this.i = i;
    this.j = j;
    this.height = height;
  }
}
