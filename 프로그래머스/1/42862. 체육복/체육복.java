import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        boolean[] give = new boolean[n];
        
        for(int r : reserve){
            give[r-1] = true;
        }
        
        for(int l=0; l<lost.length; l++){
            if(give[lost[l]-1]){
                give[lost[l]-1] = false;
                lost[l] = -1;
            }
                
        }
            
        
        for(int i=0; i<lost.length; i++){
            if(lost[i] == -1)
                continue;
            
            boolean gave = false;
            for(int j=0; j<reserve.length; j++){
                if(give[reserve[j]-1] && (reserve[j] == lost[i] - 1 || reserve[j] == lost[i] || reserve[j] == lost[i] + 1)){
                    give[reserve[j]-1] = false;
                    gave = true;
                    break;
                }
            }
            
            if(!gave)
                answer--;
            
        }
        
        return answer;
    }
}


 