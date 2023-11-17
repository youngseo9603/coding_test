class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        int a = s/n;
        if(a<1){
            answer = new int[1];
            answer[0] = -1;
        }
        else{
            for(int i=0; i<n; i++){
                answer[i] = a;
            }
            
            int cnt = 1;
            for(int i=a*n; i<s; i++){
                answer[n-cnt]++;
                cnt++;
            }
            
        }
        
        
        return answer;
    }
    
    
}