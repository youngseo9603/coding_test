import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int d = (int)Math.ceil((double)n/w);
        
        int[][] map = new int[d][w];
        
        
        int cnt = 0;
        for(int i=0; i<d; i++){
            if(i%2 == 0) {
                for (int j=0; j<w; j++){
                    map[i][j] = ++cnt;
                    if(cnt == n) break;
                }
                    
            }
            else {
                for(int j=w-1; j>=0; j--){
                    map[i][j] = ++cnt;
                    if(cnt == n) break;
                }
            }
        }
        
        
        for(int i=0; i<d; i++){
            for(int j=0; j<w; j++){
                if(map[i][j] == num){
                    while(i<d && map[i][j] != 0){
                        answer++;
                        i++;
                    }
                    break;
                }
            }
        }
        
        
        return answer;
    }
}