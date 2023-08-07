import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int testCase=0; testCase<10; testCase++) {
			int n = Integer.parseInt(bf.readLine());
			st = new StringTokenizer(bf.readLine());
			
			LinkedList<Integer> d = new LinkedList<>();
			
			for(int i=0; i<n; i++) {
				d.add(Integer.parseInt(st.nextToken()));
			}
			int orderNum = Integer.parseInt(bf.readLine());
			
			String[] order = bf.readLine().split("I");
			for(int o=1; o<orderNum+1; o++) {
				st = new StringTokenizer(order[o]);
				int start = Integer.parseInt(st.nextToken());
				int last = Integer.parseInt(st.nextToken());
				
				for(int i=start; i<start + last; i++) {
					d.add(i, Integer.parseInt(st.nextToken()));
				}
			}
			
			System.out.print("#" + (testCase+1));
			for(int i=0; i<10; i++)
				System.out.print(" " + d.get(i));
			System.out.println();
		}
	}
}