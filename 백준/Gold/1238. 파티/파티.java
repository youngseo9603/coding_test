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
        int x = Integer.parseInt(st.nextToken());
        int[][] map = new int[n+1][n+1];

        int start;
        int end;
        int time;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            time = Integer.parseInt(st.nextToken());
            map[start][end] = time;
        }

        for(int i=0; i<=n; i++){
            for(int j=0; j<=n; j++)
                if(map[i][j] == 0)
                    map[i][j] = Integer.MAX_VALUE;
        }

        for(int k=0; k<n+1; k++){
            for(int i=0; i<n+1; i++){
                for(int j=0; j<n+1; j++){
                    if(map[i][k] != Integer.MAX_VALUE && map[k][j] != Integer.MAX_VALUE && map[i][k]+map[k][j] < map[i][j])
                        map[i][j] = map[i][k] + map[k][j];
                }
            }
        }

        int answer = 0;

        for(int i=1; i<=n; i++) {
            if(i == x)
                continue;
            answer = Math.max(answer, map[i][x] + map[x][i]);
        }

        System.out.println(answer);

    }
}