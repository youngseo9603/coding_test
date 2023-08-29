import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<t; tc++) {
			int n = Integer.parseInt(br.readLine());
			HashMap<String, Integer> map = new HashMap<>();
			for(int i=0; i<n; i++) {
				String[] s = br.readLine().split(" ");
				map.put(s[1], map.getOrDefault(s[1], 0) + 1);
			}
			
			int answer = 1;
			for(String s : map.keySet()) {
				answer *= (map.get(s)+1);
			}
			System.out.println(answer -1);
		}
	}

}