import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static class Shortcut implements Comparable<Shortcut>{
        int start;
        int end;
        int length;

        Shortcut(int start, int end, int length){
            this.start = start;
            this.end = end;
            this.length = length;
        }

        @Override
        public int compareTo(Shortcut o) {
            return this.end - o.end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        Shortcut[] shortcuts = new Shortcut[n];
        int start, end, length;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            length = Integer.parseInt(st.nextToken());
            shortcuts[i] = new Shortcut(start,end,length);
        }
        Arrays.sort(shortcuts);


        int[] dp = new int[d+1];
        int cnt = 0;

        for(int i=1; i<d+1; i++) {
            dp[i] = dp[i-1] + 1;
            while(cnt < n && i == shortcuts[cnt].end){
                dp[i] = Math.min(dp[i], dp[shortcuts[cnt].start] + shortcuts[cnt].length);
                cnt++;
            }
        }

        System.out.println(dp[d]);

    }
}