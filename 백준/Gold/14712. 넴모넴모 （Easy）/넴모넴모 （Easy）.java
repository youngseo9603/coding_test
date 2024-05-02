import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] visited;
    static int n;
    static int m;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n][m];
        answer = 0;
        dfs(0);
        System.out.println(answer);
    }

    public static void dfs(int depth){

        if(depth == n*m){
            answer++;
            return;
        }

        int x = depth / m;
        int y = depth % m;

        dfs(depth+1);

        visited[x][y] = true;
        if(!isStop(x,y))
            dfs(depth+1);
        visited[x][y] = false;

    }

    public static boolean isStop(int x, int y){
        int[] dx = {-1, -1, 0};
        int[] dy = {-1, 0, -1};
        for (int i = 0; i < 3; i++) {
            int tempX = x + dx[i];
            int tempY = y + dy[i];
            if(tempX < 0 || tempY < 0 || !visited[tempX][tempY]) return false;
        }
        return true;
    }

}