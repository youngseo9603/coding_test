import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[][] map;
    static boolean[][][] visited; // 0 좌 1 우 2 하

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n][m];
        dp[0][0] = map[0][0];
        for(int i=1; i<m; i++)
            dp[0][i] = dp[0][i-1] + map[0][i];

        for(int i=1; i<n; i++){

            for(int j=0; j<m; j++)
                dp[i][j] = dp[i-1][j] + map[i][j];

            int[] dpr = new int[m];
            dpr[0] = dp[i-1][0] + map[i][0];
            int[] dpl = new int[m];
            dpl[m-1] = dp[i-1][m-1] + map[i][m-1];
            for(int j=1; j<m; j++){
                dpr[j] = Math.max(dp[i-1][j] + map[i][j] ,dpr[j-1] + map[i][j]);
            }
            for(int j=m-2; j>=0; j--){
                dpl[j] = Math.max(dp[i-1][j] + map[i][j], dpl[j+1] + map[i][j]);
            }

            for(int j=0; j<m; j++){
                dp[i][j] = Math.max(dpr[j], dpl[j]);
            }
        }

        System.out.println(dp[n-1][m-1]);


    }
}