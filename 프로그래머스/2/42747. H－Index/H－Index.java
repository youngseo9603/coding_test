import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Integer[] cit = new Integer[citations.length];
        for(int i=0; i<citations.length; i++)
            cit[i] = citations[i];
        
        Arrays.sort(cit, new Comparator<Integer>(){
            @Override
            public int compare(Integer x, Integer y){
                return y-x;
            }
        });
        
        for(int i=0; i<cit.length; i++){
            if(cit[i] >= i+1){
                answer = i+1;
                continue;
            }
            else{
                
                break;
            }
        }
        
        return answer;
    }
}