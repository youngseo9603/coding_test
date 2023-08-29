import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int testCase = 0; testCase < t; testCase++) {
			int k = Integer.parseInt(br.readLine());
			HashMap<Integer, Integer> map = new HashMap<>();
			PriorityQueue<Integer> minq = new PriorityQueue<>();
			PriorityQueue<Integer> maxq = new PriorityQueue<>(Collections.reverseOrder());

			while (k-- > 0) {
				String[] s = br.readLine().split(" ");
				if (s[0].equals("I")) {
					minq.add(Integer.parseInt(s[1]));
					maxq.add(Integer.parseInt(s[1]));
					map.put(Integer.parseInt(s[1]), map.getOrDefault(Integer.parseInt(s[1]), 0) + 1);
				} else {
					if (map.size() == 0)
						continue;
					int m;
					if (s[1].equals("1")) {
						while (true) {
							m = maxq.poll();
							if(map.getOrDefault(m,0)==0)
								continue;
							if (map.get(m) == 1)
								map.remove(m);
							else
								map.put(m, map.get(m)-1);
							break;
						}
					} else {
						while (true) {
							m = minq.poll();
							
							if(map.getOrDefault(m,0)==0)
								continue;
							if(map.get(m) == 1)
								map.remove(m);
							else
								map.put(m, map.get(m)-1);
							break;
						}
					}
				}
			}
			if(map.size() == 0)
				System.out.println("EMPTY");
			else {
				int min = 0;
				while(true) {
					min = minq.poll();
					if (map.getOrDefault(min,0)==0)
						continue;
					break;
				}
				int max = 0;
				while(true) {
					max = maxq.poll();
					if (map.getOrDefault(max,0)==0)
						continue;
					break;
				}
				
				System.out.println(max + " " + min);
			}
				
			
			
		}

	}

}