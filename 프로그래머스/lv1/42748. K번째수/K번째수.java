import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0; i<commands.length; i++){
            int a = commands[i][0];
            int b = commands[i][1];
            int c = commands[i][2];
            
            int[] arr = new int[b - a + 2];
            
            int index = a - 1;
            for(int j=0; j< b - a + 1; j++){
                arr[j] = array[index];
                index++;
            }
            
            Arrays.sort(arr);
            answer[i] = arr[c];
        }
        
        return answer;
    }
}