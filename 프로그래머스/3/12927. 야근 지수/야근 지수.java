import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<works.length; i++){
            pq.add(works[i]);
        }
        
        
        int temp;
        for(int i=0; i<n; i++){
            temp = pq.poll() - 1;
            if(temp < 0){
                pq.add(0);
                break;
            }
            pq.add(temp);
        }
        
        for(int i=0; i<works.length; i++){
            temp = pq.poll();
            answer += temp*temp;
        }
            
        
        return answer;
    }
}