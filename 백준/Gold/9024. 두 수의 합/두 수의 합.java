import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] num;
        StringBuilder sb = new StringBuilder();
        int n, k, left, right, minus, min, cnt;
        StringTokenizer st;

        while(t-->0){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            num = new int[n];
            for(int i = 0; i < n; i++)  num[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(num);

            left = 0;
            right = n - 1;
            min = Integer.MAX_VALUE;
            cnt = 0;

            while (left < right) {
                minus = Math.abs(num[left] + num[right] - k);

                if (minus < min) {
                    min = minus;
                    cnt = 1;
                }
                else if (minus == min) cnt++;

                if(num[left] + num[right] <= k) left++;
                else right--;

            }

            sb.append(cnt).append("\n");

        }

        System.out.print(sb);
    }
}