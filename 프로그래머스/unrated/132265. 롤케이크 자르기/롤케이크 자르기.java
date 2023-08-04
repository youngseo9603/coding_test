import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Hashtable<Integer, Integer> type = new Hashtable<>();
        Hashtable<Integer, Integer> type2 = new Hashtable<>();
        
        for(int i=0; i<topping.length; i++){
            type.put(topping[i], type.getOrDefault(topping[i], 0) + 1);
        }
        
        int fair = Math.floorDiv(type.size(), 2);
        
        for(int i=0; i<topping.length; i++){
            
            type.put(topping[i], type.get(topping[i]) - 1);
            type2.put(topping[i], type.getOrDefault(topping[i], 0) + 1 );
            
            if(type.get(topping[i]) == 0)
                type.remove(topping[i]);
            
            if(type.size() == type2.size()) answer++;
            
        }
        
        return answer;
    }
}