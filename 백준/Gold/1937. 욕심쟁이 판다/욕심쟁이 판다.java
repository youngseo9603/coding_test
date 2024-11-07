import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int n;
    static int[][] map;
    static int[][] dp;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[n][n];
        visited = new boolean[n][n];


        int answer = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                answer = Math.max(answer, dfs(i,j));
            }
        }
        System.out.println(answer);

    }

    public static int dfs(int x, int y){

        if(dp[x][y] != 0) return dp[x][y];

        dp[x][y] = 1;

        for(int d=0; d<4; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

            if(map[x][y] < map[nx][ny]) {
                dp[x][y] = Math.max(dp[x][y], dfs(nx,ny)+1);
            }

        }

        return dp[x][y];
    }

}