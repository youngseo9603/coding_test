import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int cnt = 0;
        String[] s = br.readLine().split(" ");
        int[] arr = new int[n+1];
        for(int i=0; i<n; i++) {
            cnt += Integer.parseInt(s[i]);
            arr[i+1] = cnt;
        }

        int answer = Integer.MIN_VALUE;
        for(int i=0; i<n-k+1; i++){
            answer = Math.max(arr[i+k] - arr[i], answer);
        }

        System.out.println(answer);

    }
}
