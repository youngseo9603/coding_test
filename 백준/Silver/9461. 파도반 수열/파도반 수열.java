import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<t; tc++) {
			int n = Integer.parseInt(br.readLine());
			long[] dp = new long[n+1];
			if(n<=3) {
				System.out.println(1);
				continue;
			}
			else if(n<=5) {
				System.out.println(2);
				continue;
			}
			dp[1] = 1;
			dp[2] = 1;
			dp[3] = 1;
			dp[4] = 2;
			dp[5] = 2;
			for(int i = 6; i<n+1; i++) {
				dp[i] = dp[i-1] + dp[i-5];
			}
			
			System.out.println(dp[n]);
		}
		
	}

}

/*
	1, 1, 1, 2, 2, 3, 4, 5, 7, 9, 12, 16, 21 
*/