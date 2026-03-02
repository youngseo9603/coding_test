class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        boolean[] ans = new boolean[schedules.length];
        for(int i=0; i<schedules.length; i++)
            ans[i] = true;
        
        for(int i=0; i<schedules.length; i++){
            
            int max = schedules[i] + 10;
            if(max % 100 >= 60){
                max += 40;
            }
            
            for(int j=0; j<7; j++){
                if((startday+j) % 7 == 6 || (startday+j) % 7 == 0){
                    continue;
                }
                if(timelogs[i][j] > max)
                    ans[i] = false;
            }
            
        }
        
        for(int i=0; i<schedules.length ; i++)
            if(ans[i]) answer++;
        
        return answer;
    }
}