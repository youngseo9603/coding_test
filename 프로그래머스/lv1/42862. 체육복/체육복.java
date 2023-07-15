import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        int[] clothes = new int[n+2];
        
        for (int i = 0; i<n+2; i++){
            clothes[i] = 1;
        }
        
        for (int i = 0; i<reserve.length ; i++){
            clothes[reserve[i]] += 1;
        }
        
        for (int i = 0; i<lost.length ; i++){
            clothes[lost[i]] -= 1;
        }
        
        for (int i = 0; i< n+1; i++){
            if (clothes[i] == 0 && clothes[i-1] == 2){
                clothes[i] = 1;
                clothes[i-1] = 1;
            }
            else if(clothes[i] == 0 && clothes[i+1] == 2){
                clothes[i] = 1;
                clothes[i+1] = 1;
            }
        }
        for (int i = 1; i< n+1; i++){
            if (clothes[i] == 0){
                answer += 1;
            }
        }
        
        return n - answer;
        
    }
}