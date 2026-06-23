import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int e : enemy){
            //System.out.println(n + " " + k + " " + answer);
            
            n -= e;
            pq.add(e);
                
            
            if(n >= 0){
                answer++;
                continue;
            }
            else{
                if(k>0){
                    while(n < 0 && k > 0){
                        n += pq.poll();
                        k--;
                        
                        if(n>=0) break;
                    }
                    answer++;
                    continue;
                }
                else
                    break;
            }
            
        }
        
        return answer;
    }
}