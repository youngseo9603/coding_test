import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n][n];

        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                if(i==j)
                    dp[i][j] = 0;
                else
                    dp[i][j] = 10000001;

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            dp[a-1][b-1] = 1;
            dp[b-1][a-1] = 1;
        }


        for(int k=0; k<n; k++){

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }

        }

        int[] answer = {-1,-1,1000001};
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                int time = 0;
                for(int k=0; k<n; k++){
                    time += Math.min(2*dp[i][k], 2*dp[j][k]);
                }
                if(time < answer[2]){
                    answer[0] = i+1;
                    answer[1] = j+1;
                    answer[2] = time;
                }
            }
        }

        for(int i=0; i<3; i++) {
            System.out.print(answer[i] + " ");
        }

    }
}