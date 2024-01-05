import java.util.*;
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        HashMap<String, String> map = new HashMap<>();
        HashMap<String, Integer> money = new HashMap<>();
        
        for(int i=0; i<enroll.length ; i++){
            map.put(enroll[i], referral[i]);
            money.put(enroll[i], 0);
        }
        
        for(int i=0; i<seller.length; i++){
            
            String s = seller[i];
            int m = 100 * amount[i];
            money.put(s, money.get(s) + m);
            
            while(true){
                if(map.get(s).equals("-") || m < 10) break;
                money.put(s, money.get(s) - m / 10);
                s = map.get(s);
                m = m / 10;
                money.put(s, money.get(s) + m);
            }
            
            money.put(s, money.get(s) - m / 10);
            
        }
        
        for(int i=0; i<enroll.length; i++)
            answer[i] = money.get(enroll[i]);
        
        return answer;
    }
}