import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][3];
        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
            map[i][2] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n][3];
        dp[0][0] = map[0][0];
        dp[0][1] = map[0][1];
        dp[0][2] = map[0][2];

        int answer = 1000001;
        for(int start=0; start<3; start++){

            for(int end=0; end<3; end++){
                if(start == end) continue;
                for(int i=0; i<3; i++) {
                    if (i == start)
                        dp[0][start] = map[0][start];
                    else
                        dp[0][i] = 1000001;
                }


                for(int i=1; i<n-1; i++){
                    dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + map[i][0];
                    dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + map[i][1];
                    dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + map[i][2];
                }

                dp[n-1][end] = Integer.MAX_VALUE;
                for(int i=0; i<3; i++) {
                    if(i == end)    continue;
                    dp[n - 1][end] = Math.min(dp[n - 2][i] + map[n - 1][end], dp[n - 1][end]);
                }

                answer = Math.min(answer, dp[n-1][end]);

            }

        }

        System.out.println(answer);

    }

}