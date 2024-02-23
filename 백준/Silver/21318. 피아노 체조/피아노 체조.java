import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] hard = new int[n];
        int[] hard_sum = new int[n];
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            hard[i] = Integer.parseInt(st.nextToken());
        for(int i=1; i<n; i++){
            if(hard[i] < hard[i-1]) sum++;
            hard_sum[i] = sum;
        }

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int testCase=0; testCase<t; testCase++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int answer = hard_sum[y-1] - hard_sum[x-1];

            sb.append(answer).append("\n");
        }

        System.out.println(sb);

    }
}