import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] arr;
	static int[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int k = Integer.parseInt(st.nextToken());
			
			if (k==0) break;
			
			visited = new int[k];
			arr = new int[k];
			for(int i=0; i<k; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			
			combination(0, 0, k);
			System.out.println();
		}
		
	}
	
	public static void combination(int c, int d, int k) {
		
			
		
		if (d == 6) {	
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<k; i++) {
				if(visited[i] == 1)
					sb.append(arr[i]).append(" ");
			}
			System.out.println(sb);
			return;
		}
		
		for(int i=c; i<k; i++) {
			visited[i] = 1;
			combination(i+1, d+1, k);
			visited[i] = 0;
		}
		
		
	}

}