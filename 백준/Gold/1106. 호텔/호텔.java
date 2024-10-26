import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] dp = new int[C * 101];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken());
            int person = Integer.parseInt(st.nextToken());
            dp[price] = Math.max(dp[price], person);
            for(int j=price; j<C*101; j++){
                if(dp[j] != 0)
                    dp[j] = Math.max(dp[j], dp[j-price] + person);
                else if(dp[j-price] != 0)
                    dp[j] = dp[j-price] + person;
            }
        }

        int answer = -1;
        for(int i=0; i<dp.length; i++){
            if(dp[i] >= C){
                answer = i;
                break;
            }
        }
        System.out.println(answer);


    }
}