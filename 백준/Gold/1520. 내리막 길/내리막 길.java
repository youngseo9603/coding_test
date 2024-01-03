import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static boolean[][] visited;
    static int answer;
    static int[][] map;
    static int[][] dp;
    static int m;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[m][n];
        visited = new boolean[m][n];
        dp = new int[m][n];

        for(int i=0; i<m;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        visited[0][0] = true;
        for(int i=0; i<m; i++){
            Arrays.fill(dp[i], -1);
        }

        System.out.println(dfs(0,0));

    }

    static int dfs(int x, int y){
        if(x == m-1 && y == n-1)
            return 1;
        if (dp[x][y] != -1)
            return dp[x][y];
        dp[x][y] = 0;

        for(int d=0; d<4; d++){
            int nx = dx[d] + x;
            int ny = dy[d] + y;

            if (nx>=0 && nx<m && ny>=0 && ny<n && !visited[nx][ny] && map[nx][ny] < map[x][y]) {
                dp[x][y] += dfs(nx,ny);
            }
        }

        return dp[x][y];

    }
}