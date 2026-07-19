import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    public static int[] dx = {1,0,0,-1};
    public static int[] dy = {0,1,-1,0};
    public static int[][] map;
    public static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcase = Integer.parseInt(br.readLine());
        int tc = testcase;
        StringBuilder sb;

        while(tc-->0){
            sb = new StringBuilder();
            int n = Integer.parseInt(br.readLine());

            map = new int[n][n];
            visited = new int[n][n];

            for(int i=0; i<n; i++){
                String s = br.readLine();
                for(int j=0; j<n; j++){
                    map[i][j] = s.charAt(j) - '0';
                    visited[i][j] = n*n;
                }
            }

            visited[0][0] = 0;
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[] {0,0});

            while(!queue.isEmpty()){
                int[] cur = queue.poll();

                for(int d=0; d<4; d++){
                    int nx = cur[0] + dx[d];
                    int ny = cur[1] + dy[d];

                    if(nx >= 0 && nx < n && ny >= 0 && ny < n){
                        if(visited[nx][ny] > visited[cur[0]][cur[1]] + map[nx][ny]){
                            visited[nx][ny] = visited[cur[0]][cur[1]] + map[nx][ny];
                            queue.add(new int[] {nx,ny});
                        }
                    }
                }
            }
            sb.append("#").append(testcase - tc).append(" ").append(visited[n-1][n-1]);
            System.out.println(sb);
        }

    }


}
