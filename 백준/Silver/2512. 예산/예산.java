import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int right = 0;
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, num[i]);
        }

        int m = Integer.parseInt(br.readLine());

        int left = 0;;
        right++;
        int mid = (left + right) / 2;

        while (left < right) {
            mid = (right + left) / 2;

            int cnt = 0;
            for(int s : num){
                if(mid > s) cnt += s;
                else cnt += mid;
            }

            if(cnt <= m){
                left = mid+1;
            }
            else {
                right = mid;
            }
        }

        System.out.println(left-1);

    }
}