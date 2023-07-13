import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> ht = new HashMap<>();
        
        for(String p : participant){
            ht.put(p, ht.getOrDefault(p, 0) + 1);
        }
        
        for(String p : completion){
            ht.put(p, ht.get(p) - 1);
        }
        
        for(String p : ht.keySet()){
            if (ht.get(p) != 0){
                answer = p;
            }

        }

        
        return answer;
    }
}