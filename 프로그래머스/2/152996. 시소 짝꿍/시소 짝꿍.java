import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        HashMap<Integer, Long> hm = new HashMap<>();
        
        Arrays.sort(weights);
        
        for(int i=0; i<weights.length; i++){
            int w = weights[i];
            
            hm.put(2*w, hm.getOrDefault(2*w,0L)+1);
            hm.put(3*w, hm.getOrDefault(3*w,0L)+1);
            hm.put(4*w, hm.getOrDefault(4*w,0L)+1);
        }
        
        for(int key : hm.keySet()){
            long h = hm.get(key);
            answer += (h*(h-1) / 2);
        }
        
        int index = 0;
        long cnt = 1;
        for(int i=1; i<weights.length; i++){
            if(weights[i] == weights[i-1]){
                cnt++;
            }
            else{
                answer -= (cnt*(cnt-1) / 2) * 2;
                cnt = 1;
            }
        }
        answer -= (cnt*(cnt-1) / 2) * 2;
        
        return answer;
    }
}