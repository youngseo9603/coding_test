import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int map[][];
    static boolean visited[][];
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());
        int position = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        answer = 1;

        visited = new boolean[n][m];
        visited[startX][startY] = true;
        go(startX,startY,position);
        System.out.println(answer);

    }

    static void go(int x, int y, int position){

        for(int i=0; i<4; i++){
            position--;
            if(position == -1) position = 3;

            int nx = x + dx[position];
            int ny = y + dy[position];

            if(nx>=0 && nx<n && ny>=0 && ny<m && !visited[nx][ny] && map[nx][ny] == 0){
                answer++;
                visited[nx][ny] = true;
                go(nx,ny,position);
                return;
            }

        }

        int back = (position+2) % 4;
        int bx = x + dx[back];
        int by = y + dy[back];

        if(bx>=0 && bx<n && by>=0 && by<m && map[bx][by] != 1){
            go(bx,by,position);
        }

    }

}