import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] s;
	static int[] b;
	static int n;
	static int min;
	public static boolean[] visited;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		
		s = new int[n];
		b = new int[n];
		visited = new boolean[n];
		min = Integer.MAX_VALUE;
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			s[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
		}
		food(0);
		System.out.println(min);
	}
	
	
	public static void food(int k) {

		if(k == n) {
			int minS = 1;
			int minB = 0;
			int flag = n;
			for(int i=0; i<n; i++) {
				if(!visited[i]) 
					flag--;
			}
			if(flag == 0) return;
			
			for(int i=0; i<n; i++) {
				if(visited[i]) {
					minS *= s[i];
					minB += b[i];
				}
			}
			
			min = Math.min(min, Math.abs(minS-minB));
			return;
		}
		
		visited[k] = true;
		food(k+1);
		visited[k] = false;
		food(k+1);
		
	}

}