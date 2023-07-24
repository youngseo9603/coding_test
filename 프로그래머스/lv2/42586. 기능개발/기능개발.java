import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] days = new int[progresses.length];
        
        int max_day = 0;
        for (int i=0; i<progresses.length; i++){
            days[i] = (int)Math.ceil((double)(100 - progresses[i])/speeds[i]);
        }
        
        int day = 0;
        int cnt = 1;
        int s = days[0];
        int[] answer = new int[100];
        
        for (int i=1; i<progresses.length; i++){
            if (s >= days[i]){
                cnt++;
            }
            else{
                answer[day] = cnt;
                cnt = 1;
                if (i<progresses.length)
                    s = days[i];
                else    s = days[i+1];
                day++;
            }
        }
        answer[day] = cnt;
        
        int[] return_answer = new int[day+1];
        for (int i=0;i<day+1;i++){
            return_answer[i] = answer[i];
        }
        
        return return_answer;
    }
}