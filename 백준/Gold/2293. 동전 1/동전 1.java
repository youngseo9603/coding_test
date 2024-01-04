import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static Integer[] coin;
    static int answer;
    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        coin = new Integer[n];

        for(int i=0; i<n; i++)
            coin[i] = Integer.parseInt(br.readLine());

        int[] dp = new int[m+1];
        dp[0] = 1;
        for(int c : coin){
            for (int i = 1; i <= m; i++) {
                if (i - c >= 0) {
                    dp[i] += dp[i - c];
                }
            }
        }

        System.out.println(dp[m]);
    }

}