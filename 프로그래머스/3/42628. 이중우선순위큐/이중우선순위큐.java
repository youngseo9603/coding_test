import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        
        PriorityQueue<Integer> maxpq = new PriorityQueue<>();
        PriorityQueue<Integer> minpq = new PriorityQueue<>((o1,o2) ->{
            return o2-o1;
        });
        
        boolean flag = false;
        int cnt = 0;
        for(String o : operations){
            String[] s = o.split(" ");
            
            if(s[0].equals("I")){
                maxpq.add(Integer.parseInt(s[1]));
                minpq.add(Integer.parseInt(s[1]));
            }
            else if(maxpq.isEmpty())
                continue;
            else if(o.equals("D 1")){
                int del = minpq.poll();
                maxpq.remove(del);
            }
            else if(o.equals("D -1")){
                int del = maxpq.poll();
                minpq.remove(del);
            }
        }
        
        if(maxpq.isEmpty())
            answer = new int[] {0,0};
        else
            answer = new int[] {minpq.peek(), maxpq.peek()};
        
        return answer;
    }
}