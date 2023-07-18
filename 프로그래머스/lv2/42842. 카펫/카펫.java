import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for (int i =1; i< brown+yellow ; i++){
            if( (brown+yellow) % i == 0){
                int y = (brown + yellow) / i;
                if( i<= y && (2*i + 2*y - 4) == brown){
                    answer[0] = y;
                    answer[1] = i;
                    return answer;
                }
            }
        }
        
        
        return answer;        
    }
}