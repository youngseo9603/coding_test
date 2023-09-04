import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		HashMap<String, String> map = new HashMap<>();
		
		while(n-->0) {
			String group = br.readLine();
			int members = Integer.parseInt(br.readLine());
			
			for(int mem=0; mem<members; mem++) {
				map.put(br.readLine(), group);
			}
		}
		
		while(m-->0) {
			String input = br.readLine();
			if(br.readLine().equals("1")) {
				System.out.println(map.get(input));
			}
			else {
				LinkedList<String> list = new LinkedList<>();
				for(String i : map.keySet()) {
					if(map.get(i).equals(input))
						list.add(i);
				}
				Collections.sort(list);
				for(String k : list) {
					System.out.println(k);
				}
			}
			
		}
		
	}

}