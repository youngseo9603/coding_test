import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int map[][];
	static int n;
	static int k;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map = new int[n][2];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[k+1];
		
		for(int i=0; i<n; i++) {
			for(int j=k; j>=0; j--) {
				if(j >= map[i][0])
					dp[j] = Math.max(dp[j], dp[j - map[i][0]] + map[i][1]);
			}
		}
		
		System.out.println(dp[k]);
		
	}
	

}