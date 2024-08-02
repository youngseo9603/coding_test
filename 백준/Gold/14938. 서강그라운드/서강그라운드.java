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
        int r = Integer.parseInt(st.nextToken());

        int[] items = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        int[][] map = new int[n+1][n+1];

        for(int i=0; i <= n; i++) {
            for(int j=0; j <= n; j++) {
                if (i==j)   continue;
                map[i][j] = 987654321;
            }
        }

        for(int i = 0; i < r; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[a][b] = Math.min(map[a][b], c);
            map[b][a] = Math.min(map[a][b], c);
        }

        for(int k=0; k<=n; k++){
            for(int i=0; i<=n; i++){
                for(int j=0; j<=n; j++){
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        int answer = 0;
        for(int i=1; i<=n; i++){
            int cnt = items[i-1];
            for(int j=1; j<=n; j++){
                if(i==j)    continue;
                if(map[i][j] <= m){
                    cnt += items[j-1];
                }
            }
            answer = Math.max(answer, cnt);
        }

        System.out.println(answer);

    }
}