import java.util.Arrays;
class Solution {
    
    
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        int index = 0;
        for(long n : numbers){
            
            String binary = Long.toBinaryString(n);
            int a = 0;
            
            int k = 0;
            while(true){
                if(binary.length() <= (int)Math.pow(2,k) -1)
                     break;
                k++;
            }
            
            StringBuilder sb = new StringBuilder("");
            for(int i=0; i<(int)Math.pow(2,k)-1 - binary.length(); i++)
                sb.append("0");
            sb.append(binary);

            String t = sb.toString();
            // System.out.println(t);
            int height = (int)(Math.log(t.length()+1) / Math.log(2));
            int start = t.length()/2;

            if(check(start, height, t)){
                a = 1;
            }
 
            answer[index] = a;
            index++;
        }
        
        return answer;
    }
    
    public static boolean check(int start, int height, String t){
        
        if(height <= 2){
            if(t.charAt(start) == '1'){
                return true;
            }
            
            else if (t.charAt(start) == '0' && t.charAt(start-1)=='0' && t.charAt(start+1)=='0'){
                return true;
            }
            else 
                return false;
            
        }
        
        int gap = (int)Math.pow(2,height-2);
        if(t.charAt(start) == '0' && (t.charAt(start-gap) == '1' || t.charAt(start+gap) == '1'))
            return false;
        if(!check(start-gap, height-1, t))  return false;
        if(!check(start+gap, height-1, t))  return false;
        
        return true;
    }
}
// 16 = 10000
// 31 = 11111  011111 11111
// 42 = 101010    
