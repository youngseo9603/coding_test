import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int n;
    static int m;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static boolean[][][] visited;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<m; j++){
                map[i][j] = (int) s.charAt(j) - 48;
            }
        }

        answer = Integer.MAX_VALUE;
        visited = new boolean[n][m][2];
        bfs();

        if(answer == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(answer);

    }

//    public static void dfs(int x, int y, int cnt, int wall){
//        if(x==n-1 && y==m-1){
//            answer = Math.min(answer, cnt);
//            return;
//        }
//
//        for(int i=0; i<4; i++){
//            int nx = x + dx[i];
//            int ny = y + dy[i];
//
//            if(nx>=0 && ny>=0 && nx<n && ny<m && map[nx][ny]==0 && !visited[nx][ny]){
//                visited[nx][ny] = true;
//                dfs(nx, ny, cnt+1, wall);
//                visited[nx][ny] = false;
//            }
//            else if(nx>=0 && ny>=0 && nx<n && ny<m && map[nx][ny]==1 && wall > 0 && !visited[nx][ny]){
//                visited[nx][ny] = true;
//                dfs(nx, ny, cnt+1, wall-1);
//                visited[nx][ny] = false;
//            }
//        }
//    }

    public static void bfs(){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {0,0,1,1});
        visited[0][0][0] = true;

        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            if(temp[0] == n-1 && temp[1] == m-1){
                answer = temp[2];
                break;
            }

            for(int i=0; i<4; i++){
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];

                if(nx>=0 && ny>=0 && nx<n && ny<m && map[nx][ny]==0) {
                    if(temp[3] == 1 && !visited[nx][ny][0]){
                        visited[nx][ny][0] = true;
                        queue.add(new int[] {nx,ny,temp[2]+1,temp[3]});
                    }
                    else if (temp[3] == 0 && !visited[nx][ny][1]){
                        visited[nx][ny][1] = true;
                        queue.add(new int[] {nx,ny,temp[2]+1,temp[3]});
                    }
                }
                else if(temp[3] == 1 && nx>=0 && ny>=0 && nx<n && ny<m && map[nx][ny]==1 && !visited[nx][ny][0] && !visited[nx][ny][1]) {
                    visited[nx][ny][1] = true;
                    queue.add(new int[] {nx,ny,temp[2]+1,temp[3]-1});
                }
            }

        }

    }
}