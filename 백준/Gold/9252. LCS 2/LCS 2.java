import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();

        int[][] dp = new int[s1.length()+1][s2.length()+1];
        StringBuilder[][] lcs = new StringBuilder[s1.length()+1][s2.length()+1];

        for(int i=0; i<s1.length()+1; i++)
            for(int j=0; j<s2.length(); j++)
                lcs[i][j] = new StringBuilder();

        for(int i=1; i<s1.length()+1; i++){
            for(int j=1; j<s2.length()+1; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                    if(dp[i][j-1] > dp[i-1][j]){
                        dp[i][j] = dp[i][j-1];
                    }
                    else {
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }

        int n = s1.length();
        int m = s2.length();
        StringBuilder sb = new StringBuilder();

        while ( n != 0 && m != 0) {
            if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
                sb.insert(0, s1.charAt(n - 1));
                n--;
                m--;
            } else if (dp[n][m] == dp[n - 1][m]) {
                n--;
            } else if (dp[n][m] == dp[n][m - 1]) {
                m--;
            }
        }

        System.out.println(dp[s1.length()][s2.length()]);
        System.out.println(sb);


    }

}