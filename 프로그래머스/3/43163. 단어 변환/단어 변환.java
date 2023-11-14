import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        Stack<Node> stack = new Stack<>();
        stack.add(new Node(begin,0));
        boolean[] visited = new boolean[words.length];
        
        while(!stack.isEmpty()){
            Node temp = stack.pop();
            
            if(temp.s.equals(target)){
                answer = temp.n;
                break;
            }
            
            for(int i=0; i<words.length; i++){
                if(!visited[i] && compare(words[i], temp.s)){
                    stack.add(new Node(words[i], temp.n+1));
                    visited[i] = true;
                }
            }
            
        }
        
        return answer; 
    }
    
    public boolean compare(String s, String t){
        int n = s.length();
        int k = 0;
        for(int i=0; i<n; i++){
            if(s.charAt(i) != t.charAt(i))
                k++;
        }
        
        if(k==1)
            return true;
        else
            return false;
    }
}

class Node{
    String s;
    int n;
    
    Node(String s, int n){
        this.s = s;
        this.n = n;
    }
}