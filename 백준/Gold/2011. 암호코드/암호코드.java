import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static String s;
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i=1; i<=n; i++){
            int now = s.charAt(i-1) - '0';
            if(now >= 1 && now <= 9){
                dp[i] += dp[i-1];
                dp[i] %= 1000000;
            }

            if(i==1) continue;

            int prev = s.charAt(i-2) - '0';
            if(prev==0) continue;

            int val = prev*10 +now;

            if(val >= 10 && val <= 26){
                dp[i] += dp[i-2];
                dp[i] %= 1000000;
            }
        }

        System.out.println(dp[n]);
    }

}