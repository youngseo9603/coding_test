import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] nums = new String[numbers.length];
        
        for(int i=0; i<nums.length; i++){
            nums[i] = String.valueOf(numbers[i]);
        }
            
        Arrays.sort(nums, (x, y) -> {
            return (y+x).compareTo(x+y);
        });
            
        StringBuilder sb = new StringBuilder();
        for(String n : nums)
            sb.append(n);
        
        answer = String.valueOf(sb);
        
        if (nums[0].equals("0")) {
            return "0";
        }
        
        return answer;
    }
}