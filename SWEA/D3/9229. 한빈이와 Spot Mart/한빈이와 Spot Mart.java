import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(bf.readLine());
		StringTokenizer st;
		for(int t=0; t<testCase; t++) {
			st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			int[] arr = new int[n];
			st = new StringTokenizer(bf.readLine());
			
			for(int i=0; i<n; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			
			for(int i=0; i<n-1; i++) {
				for(int j=i+1; j<n; j++)
					pq.add(arr[i]+arr[j]);
			}
			int answer = -1;
			while(true) {
				if(!pq.isEmpty() && pq.peek() <= m) answer = pq.poll();
				else break;
			}
			
			System.out.println("#" + (t+1) + " " + answer);
		}
	}

}