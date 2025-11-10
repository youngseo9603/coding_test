import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        
        int n = cards.length;
        boolean[] visited = new boolean[n];

        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            if(visited[i]){
                continue;
            }
            else {
                int cnt = 0;
                int temp = i;
                while(!visited[temp]){
                    visited[temp] = true;
                    temp = cards[temp]-1;
                    cnt++;
                }
                arr.add(cnt);
            }
        }
        
        Collections.sort(arr);
        
        if(arr.size() == 1)
            answer = 0;
        else
            answer = arr.get(arr.size()-1)*arr.get(arr.size()-2);
        
        return answer;
    }
}