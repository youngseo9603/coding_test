import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {


	public static void main(String[] args) throws Exception {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		for(int testCase=0; testCase<10; testCase++) {
			int dump = Integer.parseInt(bf.readLine());

			PriorityQueue<Integer> pq = new PriorityQueue<>();
			PriorityQueue<Integer> qp = new PriorityQueue<>(Collections.reverseOrder());
			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			
			for(int i=0; i<100; i++) {
				pq.add(Integer.parseInt(st.nextToken()));
			}
			
			for(int i=0; i<dump; i++) {
				int a = pq.poll()+1;
				for(int j=0; j<99; j++)
					qp.add(pq.poll());
				int b = qp.poll()-1;
				for(int j=0; j<98; j++)
					pq.add(qp.poll());
				pq.add(a);
				pq.add(b);
			}
			
			int a = pq.poll();
			for(int i=0; i<99; i++)
				qp.add(pq.poll());
			int b = qp.poll();
			System.out.println("#"+ (testCase+1) + " " + (b-a));
			
			
			
		}
	}

}
