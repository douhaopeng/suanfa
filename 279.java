class Solution {
    public int numSquares(int n) {
        Set<Integer> seen = new HashSet<>();
        int depth = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        while(!queue.isEmpty()){
        int size =  queue.size();
        depth++;
        for(int i = 0;i<size;i++){
          int node = queue.poll();
          if(!seen.add(node)) continue;
          for(int j  =1;j<=Math.sqrt(node);j++){
            int les = node - j*j;
            if(les==0){
              return  depth;
            }
            queue.offer(les);
          }
        }
        }
        return 0;
    }
}
