import java.util.*;

class Solution {
    HashMap<String, Integer> hm;
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        
        hm = new HashMap<>();
        
        Arrays.sort(course);
        for(String order : orders){
            char[] o = order.toCharArray();
            Arrays.sort(o);
            order = new String(o);
            StringBuilder sb = new StringBuilder();
            backtracking(0, order, sb, 0, course);
        }
        
        List<String> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int c : course){
            map.put(c, 0);
        }
        
        for(String key : hm.keySet()){
            if(hm.get(key) >= map.get(key.length())){
                map.put(key.length(), hm.get(key));
            } 
        }
        
        for(String key : hm.keySet()){
            if(hm.get(key) == map.get(key.length()) && hm.get(key) >= 2)
                ans.add(key);
        }
        
        answer = new String[ans.size()];
        for(int i=0; i<answer.length; i++)
            answer[i] = ans.get(i);
        Arrays.sort(answer);
        
        return answer;
    }
    
    public void backtracking(int depth, String s, StringBuilder sb, int index, int[] course){
        
        for(int i=0; i<course.length; i++){
            if(course[i] == depth){
                hm.put(sb.toString(), hm.getOrDefault(sb.toString(), 0)+1);
                if(i == course.length-1)    return;
                break;
            }
        }
        
        for(int i=index; i<s.length(); i++){
            sb.append(s.charAt(i));
            backtracking(depth+1, s, sb, i+1, course);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}