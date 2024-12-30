import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (a1, a2) -> {
            if(a1[0] != a2[0])
                return a1[0]-a2[0];
            else
                return a1[1]-a2[1];
        });
        
        int start = 0;
        int end = 100000001;
        for(int[] target : targets){
            start = Math.max(start, target[0]);
            end = Math.min(end, target[1]);
            
            if(start >= end){
                answer++;
                start = target[0];
                end = target[1];
            }
        }
        
        return answer+1;
    }
}