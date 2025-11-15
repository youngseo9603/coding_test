import java.util.*;

class Solution {
    
    String[] answer;
    boolean[] visited;
    
    public String[] solution(String[][] tickets) {
        
        int n = tickets.length;
        answer = new String[n+1];
        visited = new boolean[n];
        
        answer[0] = "ICN";
        Arrays.sort(tickets, (x,y) -> x[0].equals(y[0]) ? y[1].compareTo(x[1]) : y[0].compareTo(x[0]));
        
        String[] ans = new String[n+1];
        
        backtracking(0,visited, n, "ICN", ans, tickets);
        
        return answer;
    }
    
    public void backtracking(int depth, boolean[] visited, int n, String next, String[] ans, String[][] tickets){
        
        
        if(depth == n){
            ans[depth] = next;
            
            for(int i=0; i<n+1; i++){
                answer[i] = ans[i];
            }
            return;
        }
        
        ans[depth] = next;
        
        for(int i=0; i<tickets.length; i++){
            if(tickets[i][0].equals(next) && !visited[i]){
                visited[i] = true;
                backtracking(depth+1, visited, n, tickets[i][1], ans, tickets);
                visited[i] = false;
            }
        }
        
        return;
    }
    
}
