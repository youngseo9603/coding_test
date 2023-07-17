import java.util.*;

class Solution {
    public String solution(String number, int k) {
        
        StringBuilder sb = new StringBuilder("");
		
		for(int i = 0; i<number.length(); i++) {
			if (k>0 && sb.length() !=0 && sb.charAt(sb.length()-1) < number.charAt(i)) {
				sb.deleteCharAt(sb.length()-1);
				k--;
			}
			sb.append(number.charAt(i));
		}
		
        return sb.toString();

    }
}