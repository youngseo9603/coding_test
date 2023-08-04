import java.util.*;

class Solution {
    static int answer;
    public int solution(int[] order) {
        answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        
        for(int i=1; i<order.length + 1; i++){
            if(i != order[answer])
                stack.add(i);    
            else{
                answer++;
                find(stack, order);
            }
        }
        return answer;
    }
    
    static void find(Stack<Integer> s, int[] o){
        if(!s.isEmpty() && s.peek() == o[answer]){
            s.pop();
            answer++;
            find(s, o);
        }
    }
}