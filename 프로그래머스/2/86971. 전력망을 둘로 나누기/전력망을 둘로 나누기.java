import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        int node = 0;
        List<Integer>[] map = new List[n+1];
        for(int i=0; i<n+1; i++){
            map[i] = new ArrayList<>();
        }
        
        for(int i=0; i<n-1; i++){
            map[wires[i][0]].add(wires[i][1]);
            map[wires[i][1]].add(wires[i][0]);
            if(map[wires[i][0]].size() == 1)    node++;
            if(map[wires[i][1]].size() == 1)    node++;
        }
        
        for(int i=0; i<n-1; i++){
            boolean[] visited = new boolean[n+1];
            int a = wires[i][0];
            int b = wires[i][1];
            
            visited[a] = true;
            Stack<Integer> stack = new Stack<>();
            stack.add(a);
            while(!stack.isEmpty()){
                int cur = stack.pop();
                for(int next : map[cur]){
                    if(!visited[next] && next != b){
                        stack.add(next);
                        visited[next] = true;
                    }
                }
            }
            
            int cnt = 0;
            for(boolean s : visited)
                if(s)   cnt++;
            
            // System.out.println(a + " " + b + " " +cnt);
            answer = Math.min(answer, Math.abs(node-2*cnt));
            
        }
        
        return answer;
    }
}