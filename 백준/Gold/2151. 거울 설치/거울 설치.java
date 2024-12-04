import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] dx = {0,-1,0,1}; // 우 상 좌 하
    static int[] dy = {1,0,-1,0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[][] map = new char[n][n];

        int[] start = new int[2];

        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < n; j++){
                map[i][j] = s.charAt(j);
                if(map[i][j] == '#'){
                    start = new int[] {i,j};
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();

        for (int d = 0; d < 4; d++) {
            int x = start[0] + dx[d];
            int y = start[1] + dy[d];
            if (x >= 0 && y >= 0 && x < n && y < n && map[x][y] != '*') {
                queue.add(new int[]{start[0], start[1], d, 0});
            }
        }

        map[start[0]][start[1]] = '*';

        int answer = -1;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            if(map[cur[0]][cur[1]] == '#'){
                answer = cur[3]-1;
                break;
            }

            int nx = cur[0];
            int ny = cur[1];

            while(nx>=0 && ny>=0 && nx < n && ny < n){
                nx += dx[cur[2]];
                ny += dy[cur[2]];

                if(nx>=0 && ny>=0 && nx < n && ny < n) {
                    if (map[nx][ny] == '.') {
                        continue;
                    } else if (map[nx][ny] == '!') {
                        queue.add(new int[]{nx, ny, (cur[2] + 3) % 4, cur[3] + 1});
                        queue.add(new int[]{nx, ny, (cur[2] + 1) % 4, cur[3] + 1});
                    } else if (map[nx][ny] == '#') {
                        queue.add(new int[]{nx, ny, cur[2], cur[3] + 1});
                        break;
                    } else if (map[nx][ny] == '*') {
                        break;
                    }
                }
            }

        }

        System.out.println(answer);

    }
}