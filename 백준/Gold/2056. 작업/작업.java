import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];

        for(int i=1; i<n+1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            ArrayList<Integer> list = new ArrayList<>();
            for(int j=0; j<cnt; j++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            dp[i] = time;

            for(int l : list){
                dp[i] = Math.max(dp[i], dp[l] + time);
            }

        }

        int answer = 0;
        for(int i=1; i<n+1; i++) {
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);



    }
}