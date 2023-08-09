import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		int answer = 0;
		for(int t=0; t<n; t++) {
			String s = bf.readLine();
			
			HashMap<Character, Integer> hm = new HashMap<>();
			hm.put(s.charAt(0), hm.getOrDefault(s.charAt(0), 1));

			int flag = 0;
			for(int i=1; i<s.length(); i++) {
				if(s.charAt(i) != s.charAt(i-1)) {
					if(hm.get(s.charAt(i)) != null)
						flag = 1;
					else
						hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 1) + 1);
				}
			}
			
			if(flag == 0)	answer++;
			
		}
		System.out.println(answer);
	}
}