import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int[] dx = {0, 0, -1, 1}; // 우, 좌, 상, 하
    public static int[] dy = {1, -1, 0, 0};
    static int n;
    static int m;
    static int[][] map;
    static int answer;
    static boolean[][][][] visited;

    public static class Marble {
        int rx;
        int ry;
        int bx;
        int by;
        boolean done;
        boolean fail;
        int cnt;

        public Marble(int rx, int ry, int bx, int by) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            done = false;
            fail = false;
            cnt = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m][n][m];

        int rx = 0, ry = 0, bx = 0, by = 0;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                if(s.charAt(j) == '#') {
                    map[i][j] = 1;
                }
                else if (s.charAt(j) == '.') {
                    map[i][j] = 0;
                }
                else if (s.charAt(j) == 'O') {
                    map[i][j] = 2;
                }
                else if (s.charAt(j) == 'R') {
                    map[i][j] = 0;
                    rx = i;
                    ry = j;
                }
                else if (s.charAt(j) == 'B') {
                    map[i][j] = 0;
                    bx = i;
                    by = j;
                }
            }
        }

        Marble marble = new Marble(rx, ry, bx, by);
        answer = 0;
        bfs(marble);

    }

    public static void bfs(Marble marble){

        Queue<Marble> queue = new LinkedList<>();
        queue.add(marble);
        visited[marble.rx][marble.ry][marble.bx][marble.by] = true;
        while(!queue.isEmpty()){
            Marble m = queue.poll();
            if(m.cnt > 10)
                break;

//            System.out.println(m.rx + " " + m.ry + " " + m.bx + " " + m.by + " " + m.fail + " " + m.done);

            if(map[m.rx][m.ry] == 2 && !m.fail && m.done){
                answer = m.cnt;
                break;
            }
            else if(m.fail){
                continue;
            }

            for(int d=0; d<4; d++){
                Marble next = move(m, d);
                if(!visited[next.rx][next.ry][next.bx][next.by] && !next.fail) {
                    queue.add(next);
                    visited[next.rx][next.ry][next.bx][next.by] = true;
                }
            }
        }

        if(answer == 0) System.out.println(-1);
        else System.out.println(answer);

    }

    public static Marble move(Marble marble, int d){

        int rx = marble.rx;
        int ry = marble.ry;
        int bx = marble.bx;
        int by = marble.by;
        Marble next = new Marble(rx, ry, bx, by);
        next.cnt = marble.cnt + 1;
        boolean redFirst = moveFirst(marble, d);

        if(redFirst){ // r 부터
            while(rx + dx[d] >= 0 && ry + dy[d] >= 0 && rx + dx[d] < n && ry + dy[d] < m && (map[rx + dx[d]][ry + dy[d]] == 0 || map[rx + dx[d]][ry + dy[d]] == 2)){
                if(map[rx + dx[d]][ry + dy[d]] == 2){ // goal
                    next.done = true;
                    rx += dx[d];
                    ry += dy[d];
                    break;
                }
                rx += dx[d];
                ry += dy[d];
            }

            while(bx + dx[d] >= 0 && by + dy[d] >= 0 && bx + dx[d] < n && by + dy[d] < m && (map[bx + dx[d]][by + dy[d]] == 0 || map[bx + dx[d]][by + dy[d]] == 2)){
                if(map[bx + dx[d]][by + dy[d]] == 2){
                    next.fail = true;
                    bx += dx[d];
                    by += dy[d];
                    return next;
                }
                bx += dx[d];
                by += dy[d];
            }
            if(rx == bx && ry == by) {
                bx -= dx[d];
                by -= dy[d];
            }
        }
        else {
            while(bx + dx[d] >= 0 && by + dy[d] >= 0 && bx + dx[d] < n && by + dy[d] < m && (map[bx + dx[d]][by + dy[d]] == 0 || map[bx + dx[d]][by + dy[d]] == 2)){
                if(map[bx + dx[d]][by + dy[d]] == 2){
                    next.fail = true;
                    bx += dx[d];
                    by += dy[d];
                    return next;
                }
                bx += dx[d];
                by += dy[d];
            }
            while(rx + dx[d] >= 0 && ry + dy[d] >= 0 && rx + dx[d] < n && ry + dy[d] < m && (map[rx + dx[d]][ry + dy[d]] == 0 || map[rx + dx[d]][ry + dy[d]] == 2)){
                if(map[rx + dx[d]][ry + dy[d]] == 2){ // goal
                    next.done = true;
                    rx += dx[d];
                    ry += dy[d];
                    break;
                }
                rx += dx[d];
                ry += dy[d];
            }
            if(rx == bx && ry == by) {
                rx -= dx[d];
                ry -= dy[d];
            }
        }

        if(next.done && next.fail){
            next.fail = false;
        }

        next.rx = rx;
        next.ry = ry;
        next.bx = bx;
        next.by = by;

        return next;
    }

    public static boolean moveFirst(Marble marble, int d){

        if(d == 0){
            if(marble.ry > marble.by)   return true; // r 부터
            else return false; // b 부터
        }
        else if (d == 1){
            if(marble.ry < marble.by)   return true;
            else return false;
        }
        else if(d == 2){
            if(marble.rx < marble.bx)   return true;
            else return false;
        }
        else {
            if(marble.rx > marble.bx)   return true;
            else return false;
        }

    }

}