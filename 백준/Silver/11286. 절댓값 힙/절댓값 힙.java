import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		
		for(int i=0; i<n; i++) {
			int method_num = Integer.parseInt(bf.readLine());
			Node m = new Node(method_num);
			
			if(method_num != 0) {
				pq.add(m);
			}
			else {
				Node temp = pq.poll();
				if (temp == null) 
					System.out.println(0);
				else
					System.out.println(temp.a*temp.b);
			}
			
			
		}
	}
	
	public static class Node implements Comparable<Node>{
		
		private int a;
		private int b;
		
		public Node(int a) {
			if(a>0) {
				this.a = a;
				this.b = 1;
			}
			else {
				this.a = -a;
				this.b = -1;				
			}

		}
		
		@Override
		public int compareTo(Node o) {
			if (this.a > o.a)
				return 1;
			else if (this.a == o.a) {
				if (this.b == 1 && o.b == -1)
					return 1;
				return -1;
			}
			else
				return -1;

		}
		
	}

}

