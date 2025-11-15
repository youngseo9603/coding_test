class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] servers = new int[players.length];
        
        for(int i=0; i<players.length; i++){
            
            if(players[i]/m > servers[i]){
                int cnt = players[i]/m - servers[i];
                answer += cnt;
                
                for(int d=0; d<k; d++){
                    if(i+d < players.length){
                        servers[i+d] += cnt;
                    }
                }
            }
        }
        
        
        return answer;
    }
}