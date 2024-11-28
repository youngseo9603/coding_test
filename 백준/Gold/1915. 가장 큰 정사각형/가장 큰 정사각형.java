import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[][] map;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        int answer = 0;
        int[][] dp = new int[n][m];
        for(int i=0; i<n; i++)
            dp[i][0] = map[i][0];
        for(int j=0; j<m; j++)
            dp[0][j] = map[0][j];

        for(int i=1; i<n; i++) {
            for(int j=1; j<m; j++) {
                dp[i][j] = map[i][j];
                if(map[i][j] == 1){
                    if(dp[i-1][j] != 0 && dp[i][j-1] != 0 && dp[i-1][j-1] != 0){
                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])+1;
                        if(dp[i][j] == dp[i-1][j] && dp[i][j] == dp[i][j-1] && dp[i][j] == dp[i-1][j-1]){
                            dp[i][j]++;
                        }
                    }
                }
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                answer = Math.max(answer, dp[i][j]);
            }
        }

        System.out.println(answer*answer);

    }
}