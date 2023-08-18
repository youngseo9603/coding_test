import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] dp = new int[n+1];
		
		dp[1] = 1;
		
		
		for(int i=2 ;i<n+1; i++) {
			dp[i] = dp[i-1] + 1;
			for(int k=1; k*k<=i; k++)
				dp[i] = Math.min(dp[i], dp[i-k*k] + 1);
		}
		
		System.out.println(dp[n]);
		
	}
}