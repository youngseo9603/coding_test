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
        long result = 0;

        st = new StringTokenizer(br.readLine());
        int[] a = new int[n+1];
        long[] cnt = new long[m];


        for(int i=1; i<n+1; i++) {
            a[i] = (a[i-1] + Integer.parseInt(st.nextToken())) % m;

            if(a[i] == 0)
                result++;

            cnt[a[i]]++;
        }

        for(int i=0; i<m; i++) {
            if(cnt[i] > 1){
                result += (cnt[i]* (cnt[i]-1) / 2);
            }
        }

        System.out.println(result);
    }
}