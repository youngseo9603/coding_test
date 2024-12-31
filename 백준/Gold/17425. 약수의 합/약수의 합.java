import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] num = new int[t];
        int maxNum = 0;
        for (int i = 0; i < t; i++) {
            num[i] = Integer.parseInt(br.readLine());
            maxNum = Math.max(maxNum, num[i]);
        }

        long[] g = new long[maxNum + 1];
        Arrays.fill(g, 1);

        for(int i=2; i<=maxNum; i++){
            int cnt = 1;
            while(cnt*i <= maxNum){
                g[cnt*i] += i;
                cnt++;
            }
        }

        long[] sum = new long[maxNum + 1];
        for(int i=1; i<=maxNum; i++){
            sum[i] = sum[i-1] + g[i];
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<t; i++){
            sb.append(sum[num[i]]).append("\n");
        }
        System.out.println(sb);

    }
}
/* 1 2 4
1 2 5 10
1 2 3 6
1 2 4 8
1 3 9
1   2   3   4   5       6       7       8       9       10
1   1+3 4+4 8+7 15+6    21+12   33+8    41+15   56+13   69+18
 */