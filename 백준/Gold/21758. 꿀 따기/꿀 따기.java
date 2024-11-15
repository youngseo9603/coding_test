import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] honey = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            honey[i] = Integer.parseInt(st.nextToken());

        long[] rightSum = new long[n+1];
        for(int i = 1; i <= n; i++){
            rightSum[i] = rightSum[i-1] + honey[i-1];
        }

        int max = 0;
        for(int i=1; i<n-1; i++)
            if(max < honey[i])
                max = honey[i];

        long answer = rightSum[n-1] - (long)honey[0] + max;

        for(int i=1; i<n-1; i++){ // 벌 벌 통
            long cnt = 2*rightSum[n] - honey[0] - rightSum[i+1] - honey[i];
            answer = Math.max(answer, cnt);
        }

        for(int i=1; i<n-1; i++){ // 통 벌 벌
            long cnt = rightSum[n] - honey[n-1] + rightSum[i] - honey[i];
            answer = Math.max(answer, cnt);
        }


        System.out.println(answer);

    }
}