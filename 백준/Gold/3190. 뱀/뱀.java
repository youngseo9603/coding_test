import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int[] dx = {1,0,-1,0};
    public static int[] dy = {0,1,0,-1};

    public static class Direction implements Comparable<Direction> {
        int time;
        String d;

        Direction(int t, String d){
            this.time = t;
            this.d = d;
        }

        public int compareTo(Direction o) {
            return time - o.time;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        map[0][0] = 0;

        StringTokenizer st;
        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = -1;
        }

        int l = Integer.parseInt(br.readLine());
        Direction[] directions = new Direction[l];

        for(int i=0; i<l; i++){
            st = new StringTokenizer(br.readLine());
            directions[i] = new Direction(Integer.parseInt(st.nextToken()), st.nextToken());
        }

        Arrays.sort(directions);

        int time = 0;
        int dir = 1;
        int headX = 0;
        int headY = 0;
        int dirIndex = 0;

        ArrayDeque<int[]> snake = new ArrayDeque<>();
        snake.add(new int[] {0,0});


        while(true){
            headX += dx[dir];
            headY += dy[dir];

            if(headX < 0 || headX >= n || headY < 0 || headY >= n || map[headX][headY] > 0){
                break;
            }
            else {
                if(map[headX][headY] == -1){
                    snake.addLast(new int[] {headX, headY});
                    map[headX][headY] = ++time;
                }
                else {
                    map[headX][headY] = ++time;
                    snake.add(new int[] {headX, headY});
                    int[] tail = snake.pollFirst();
                    map[tail[0]][tail[1]] = 0;
                }

            }

            if(dirIndex < directions.length && directions[dirIndex].time == time){
                if(directions[dirIndex].d.equals("D")){ // 오른쪽
                    dir = (dir+3) % 4;
                }
                else if(directions[dirIndex].d.equals("L")){
                    dir = (dir+1) % 4;
                }
                dirIndex++;
            }


        }

        System.out.println(++time);


    }
}