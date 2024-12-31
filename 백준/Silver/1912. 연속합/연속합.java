import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        long[] dp = new long[n];
        dp[0] = num[0];
        long answer = dp[0];
        for(int i=1; i<n; i++){
            dp[i] = Math.max(dp[i-1] + num[i], num[i]);
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }
}
/*
0 10 6 9 10 15 21 -14 -2 19 18

0 2 3 -1 2 6 2 8 13 8 9
 */