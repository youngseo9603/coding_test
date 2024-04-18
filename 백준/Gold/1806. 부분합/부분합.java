import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] num = new int[n];
        for(int i=0; i<n; i++)
            num[i] = Integer.parseInt(st.nextToken());

        int answer = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int sum = 0;
        while(end < n) {
            sum += num[end];
            if(sum >= s) {
                while(start <= end && sum - num[start] >= s) {
                    sum -= num[start];
                    start++;
                }
                answer = Math.min(answer, end - start + 1);
            }
            end++;
        }

        if(answer == Integer.MAX_VALUE)
            answer = 0;

        System.out.println(answer);
    }
}