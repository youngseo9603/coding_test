import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        
        for(int i=0; i<name.length(); i++){
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
        }
        
        int start = 0;
        int end = 0;
        int joystick = name.length()-1;
        
        for(int i=0; i<name.length(); i++){
            
            if(name.charAt(i) == 'A'){
                start = i;
                
                while(i<name.length() && name.charAt(i) == 'A'){
                    i++;
                }
                
                end = i-1;
                
                System.out.println(start + " " + end + " " + joystick);
                
                if(start == 0 && end == name.length()-1){
                    joystick = 0;
                    break;
                }
                else if(end == name.length()-1){
                    joystick = Math.min(joystick, start-1);
                }
                else if(start == 0){
                    joystick = Math.min(joystick, name.length()-end-1);
                }
                else {
                    joystick = Math.min(joystick, 2*start+name.length()-end-3);
                    joystick = Math.min(joystick, 2+2*(name.length()-end-2)+start-1);
                }
                
            }
            
        }
        
        
        answer += joystick;
        return answer;
    }
}
