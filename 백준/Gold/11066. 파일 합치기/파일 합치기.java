import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < testcase; t++) {
			int K = Integer.parseInt(br.readLine());

			int[] arr = new int[K + 1];
			int[] sum = new int[K + 1];
			int[][] dp = new int[K + 1][K + 1];

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= K; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				sum[i] = sum[i - 1] + arr[i];
			}

			for (int i = 1; i <= K; i++) {
				for (int j = 1; j <= K - i; j++) {
					dp[j][i + j] = Integer.MAX_VALUE;
					for (int k = j; k < i + j; k++) {
						dp[j][i + j] = Math.min(dp[j][i + j], dp[j][k] + dp[k + 1][i + j] + sum[i + j] - sum[j - 1]);
					}
				}
			}
			
//			for(int i=0; i<K+1; i++) {
//				for(int j=0; j<K+1; j++)
//					System.out.print(dp[i][j]+ " ");
//				System.out.println();
//				
//			}
			
			sb.append(dp[1][K]).append('\n');

		}
		System.out.println(sb);
	}
}