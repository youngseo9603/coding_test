class Solution {
    public long solution(int[] sequence) {
        long answer = Integer.MIN_VALUE;
        int[] plus = new int[sequence.length];
        int[] minus = new int[sequence.length];
        
        for(int i=0; i<sequence.length; i++){
            if(i % 2 == 0){
                minus[i] = -1*sequence[i];
                plus[i] = sequence[i];     
            }
            else{
                minus[i] = sequence[i];
                plus[i] = -1*sequence[i];     
            }
        }
        
        long[][] dp = new long[sequence.length+1][2];
        
        
        for(int i=1; i<=sequence.length; i++){
            dp[i][0] = Math.max(dp[i-1][0] + minus[i-1], minus[i-1]);
            dp[i][1] = Math.max(dp[i-1][1] + plus[i-1], plus[i-1]);
        }
        
        for(int i=1; i<=sequence.length; i++){
            answer = Math.max(answer, dp[i][0]);
            answer = Math.max(answer, dp[i][1]);
        }
        
        
        return answer;
    }
}
