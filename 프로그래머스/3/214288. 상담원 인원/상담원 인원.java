import java.util.*;

class Solution {
    static int[][] table;
    public int solution(int k, int n, int[][] reqs) {
        int answer = 0;
        
        table = new int[k+2][n+2];
        
        //각 유형별 소요시간 구하기
        for(int i=1; i<=k; i++){
            for(int j=1; j<=n-k+1; j++){
                table[i][j] = mentoring(i,j,reqs);
                if(table[i][j] == table[i][j-1])
                    break;
            }
        }
        
         // 2. 소요시간의 합이 최소가 되는 구성을 찾는다.
            int[] idx = new int[k+1]; // table index 배열
            for(int i = 0; i <= k; i++) idx[i] = 1;

            for(int i = 0; i < n-k; i++){
                int max = -1;
                int type = 0;
                for(int j = 1; j <= k; j++){
                    if(table[j][idx[j]] - table[j][idx[j]+1] > max){
                        max = table[j][idx[j]] - table[j][idx[j]+1];
                        type = j;
                    }
                }
                idx[type]++;
            }
            for(int i = 1; i<=k; i++) answer+=table[i][idx[i]];
        
        return answer;
    }
    
    // 대기시간 
    public int mentoring(int type, int mento, int[][] reqs){
        int sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<mento; i++)
            pq.add(0);
        for(int[] r : reqs){
            if(r[2] != type) // 해당 타입이 아닐경우
                continue; 
            int cur = pq.poll(); // 현재 시간
            if(r[0] < cur) // 앞 사람과 시간이 겹칠 경우
                sum += (cur - r[0]);
            else cur = r[0];
            pq.add(cur + r[1]);
        }
        return sum;
    }
}