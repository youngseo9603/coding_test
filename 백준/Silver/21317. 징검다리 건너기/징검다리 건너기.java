import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][2];

        StringTokenizer st;
        for(int i=1; i<n; i++){
            st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
        }

        int k = Integer.parseInt(br.readLine());

        long[][] dp = new long[n+1][2];

        for(int i=0; i<n+1; i++){
            dp[i][0] = 100000;
            dp[i][1] = 100000;
        }

        dp[1][0] = 0;

        if (n > 1) {
            dp[2][0] = map[1][0];
            if (n > 2) {
                dp[3][0] = Math.min(map[2][0] + dp[2][0], map[1][1]);
            }
        }
        for (int i = 4; i <= n; i++) {
            dp[i][0] = Math.min(map[i-1][0] + dp[i-1][0], map[i-2][1] + dp[i-2][0]);
            dp[i][1] = Math.min(Math.min(map[i-1][0] + dp[i-1][1], map[i-2][1] + dp[i-2][1]), k + dp[i-3][0]);
        }

        System.out.println(Math.min(dp[n][0], dp[n][1]));

    }

}