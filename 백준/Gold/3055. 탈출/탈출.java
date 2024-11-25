import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static char[][] map;
    static int r;
    static int c;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];

        int[] pos = new int[3];
        for(int i=0; i<r; i++){
            String s = br.readLine();
            for(int j=0; j<c; j++){
                map[i][j] = s.charAt(j);
                if(map[i][j] == 'S')
                    pos = new int[] {i,j,0};
            }
        }

        boolean[][] visited = new boolean[r][c];
        Queue<int[]> q = new LinkedList<>();
        q.add(pos);
        visited[pos[0]][pos[1]] = true;
        int answer = -1;
        int time = 0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(map[cur[0]][cur[1]] == 'D'){
                answer = cur[2];
                break;
            }
            if(time != cur[2]){
                time = cur[2];
                water();
            }
            if(map[cur[0]][cur[1]] == '*'){
                continue;
            }

            for(int d=0; d<4; d++){
                int x = cur[0] + dx[d];
                int y = cur[1] + dy[d];
                if(x>=0 && y>=0 && x<r && y<c && map[x][y] != '*' && map[x][y] != 'X' && !visited[x][y]){
                    q.offer(new int[] {x,y,cur[2]+1});
                    visited[x][y] = true;
                }
            }

        }

        if(answer == -1)
            System.out.println("KAKTUS");
        else
            System.out.println(answer);

    }

    public static void water(){
        List<int[]> list = new ArrayList<>();
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(map[i][j] == '*'){
                    list.add(new int[]{i,j});
                }
            }
        }

        for(int[] temp : list){
            for(int d=0; d<4; d++){
                int x = temp[0] + dx[d];
                int y = temp[1] + dy[d];
                if(x>=0 && x<r && y>=0 && y<c && map[x][y]=='.'){
                    map[x][y] = '*';
                }
            }
        }
    }
}