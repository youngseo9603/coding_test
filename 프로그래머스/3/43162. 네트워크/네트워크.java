import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        List<Integer>[] map = new List[n];
        for(int i=0; i<n; i++){
            map[i] = new ArrayList<>();
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(computers[i][j] == 1 && i != j){
                    map[i].add(j);
                }
            }
        }
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                answer++;
                
                Stack<Integer> stack = new Stack<>();
                for(int next : map[i]){
                    stack.add(next);
                }
                visited[i] = true;
                
                while(!stack.isEmpty()){
                    int cur = stack.pop();
                    
                    for(int next : map[cur]){
                        if(!visited[next])
                            stack.add(next);
                    }
                    visited[cur] = true;
                    
                }
            }
        }
        
        return answer;
    }
}