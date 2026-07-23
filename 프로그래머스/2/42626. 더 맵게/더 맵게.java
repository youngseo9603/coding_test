import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int s : scoville)
            pq.add(s);
        
        while(pq.peek() < K && pq.size() >= 2){
            int a = pq.poll();
            int b = pq.poll();
            
            pq.add(a + 2 * b);
            
            answer++;
        }
        
        
        if(pq.size() == 1 && pq.peek() < K)
            answer = -1;
        
        return answer;
    }
}