public class Solution{

public int ladderLength(String beginWord,String endWord,List<String> wordList){

HashSet<String> wordSet = new HashSet<>(wordList);
if(!wordSet.contains(endWord)) return 0;
HashMap<String,Integer> map = new HashMap<>();
Queue<String> q = new LinkedList<>();
q.add(beginWord);
map.put(beginWord,1);
while(!q.isEmpty()){
  String word = q.poll();
  int level = map.get(word);
  for(int i=  0;i<word.length;i++){
    char[] wordLetter = word.toCharArray();
    for(char j = 'a';j<='z';j++){
      if(wordLetter[i]==j) continue;
      wordLetter[i] = j;
      String check = new String(wordLetter);
      if(check.equals(endWord)) return map.get(word)+1;
      if(wordSet.contains(check)&& !map.containsKey(check)){
        q.add(check);
        map.put(check,level+1);
      }
    }
  }
}

  return 0;

}










-------------------------------------------


public int ladderLength(String begin,String endWord,list<String> wordList){
if(wordList == null || wordList.size() ==0){

  return 0;

}

HashSet<String> start = new HashSet<>();
HashSet<String> end = new HashSet<>();
HashSet<String> dic = new HashSet<>(wordList);

start.add(beginWord);
end.add(endWord);
if(!dic.contains(endWord)){
  return 0;
}

return  bfs(start,end,dic,2);

}


public int bfs(HashSet<String> begin,HashSet<String> end, HashSet<String> dic,int l){
  if(begin.size() == 0){
    return 0;
  }
  if(begin.size()>end.size()){
    return  bfs(end,begin,dic,l);
  }

  dic.removeAll(begin);
  HashSet<String> next = new HashSet<>();
  for(String s : begin){
    char[] arr = s.toCharArray();
    for(int i = 0;i<arr.length;i++){
      char temp = arr[i];
      for(char c='a';c<='z';c++){
        if(temp == c){
          continue;
        }
        arr[i] = c;
        String nstr = new String(arr);
        if(dic.contains(nstr)){
          if(end.contains(nstr)){
            return  l;
          }
          else {
            next.add(nstr)
          }
        }
      }
    }
  }
}
