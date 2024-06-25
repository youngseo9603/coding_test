import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i==j)    continue;
                map[i][j] = 100000*100+1;
            }
        }

        StringTokenizer st;
        int start;
        int end;
        int cost;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());
            map[start-1][end-1] = Math.min(map[start-1][end-1], cost);
        }

        for(int k=0; k<n; k++){

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }

        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++) {
                if (map[i][j] == 100000*100+1)
                    map[i][j] = 0;
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}