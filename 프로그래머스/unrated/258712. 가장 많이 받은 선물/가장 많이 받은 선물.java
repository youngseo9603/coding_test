import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int n = friends.length;
        int[][] map = new int[n][n];
        int[] giftPoint = new int[n];
        HashMap<String, Integer> h = new HashMap<>();
        
        for(int i=0; i<n; i++)
            h.put(friends[i], i);
        
        StringTokenizer st;
        for(String s : gifts){
            st = new StringTokenizer(s);
            
            String f1 = st.nextToken();
            String f2 = st.nextToken();
            
            map[h.get(f1)][h.get(f2)]++;
            giftPoint[h.get(f1)]++;
            giftPoint[h.get(f2)]--;
        }
        
//         for(int i=0; i<n; i++){
//             for(int j=0; j<n; j++)
//                 System.out.print(map[i][j] + " ");
//             System.out.println();
//         }
        
//         System.out.println();
//         for(int i=0; i<n; i++)
//             System.out.print(giftPoint[i]);
        
        
        for(int i=0; i<n; i++){
            int cnt = 0;
            for(int j=0; j<n; j++){
                if(i==j) continue;
                if(map[i][j] > map[j][i])
                    cnt++;
                else if (map[i][j] == map[j][i] && giftPoint[i] > giftPoint[j])
                    cnt++;
            }
            
            answer = Math.max(cnt, answer);
            
        }
        return answer;
    }
}