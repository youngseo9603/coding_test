import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[][] dp = new int[n+1][3];
	
		for(int i=0; i<n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			dp[i+1][0] = Math.min(a+dp[i][1], a+dp[i][2]);
			dp[i+1][1] = Math.min(b+dp[i][0], b+dp[i][2]);
			dp[i+1][2] = Math.min(c+dp[i][0], c+dp[i][1]);
		}
		
		int answer = Math.min(dp[n][0], dp[n][1]);
		answer = Math.min(answer, dp[n][2]);
		
		System.out.println(answer);
		
	}
}
