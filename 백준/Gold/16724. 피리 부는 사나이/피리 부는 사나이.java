import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int m;
    public static char[][] map;
    public static boolean[][] visited;
    public static boolean[][] finished;
    public static int answer;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new boolean[n][m];
        finished = new boolean[n][m];

        for(int i=0; i<n; i++) {
            String l = br.readLine();
            for(int j=0; j<m; j++) {
                map[i][j] = l.charAt(j);
            }
        }

        answer = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(!visited[i][j]) {
                    dfs(i,j);
                }
            }
        }

        System.out.println(answer);

    }

    public static void dfs(int i, int j){
        visited[i][j] = true;
        int[] next = getNow(map[i][j]);
        int nx = i + next[0];
        int ny = j + next[1];

        if(!visited[nx][ny]) {
            dfs(nx, ny);
        }
        else {
            if(!finished[nx][ny]) {
                answer++;
            }
        }

        finished[i][j] = true;

    }

    public static int[] getNow(char now){
        switch (now){
            case 'U':
                return new int[]{-1,0};
            case 'D':
                return new int[]{1,0};
            case 'R':
                return new int[]{0,1};
            case 'L':
                return new int[]{0,-1};
        }

        return new int[] {0,0};
    }

}