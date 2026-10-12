import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = false;
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            stack.push(s.charAt(i));
            if(s.charAt(i) == ')' && stack.size() > 1 &&stack.get(stack.size()-2) == '(' ){
                stack.pop();
                stack.pop();
            }
        }
        
        if(stack.size() == 0)
            answer = true;

        return answer;
    }
}