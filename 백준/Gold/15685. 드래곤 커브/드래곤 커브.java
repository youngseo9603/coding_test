import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static int[][] map;
    public static int[] dy = {0,-1,0,1};
    public static int[] dx = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        map = new int[101][101];

        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            dragon(x,y,d,g);
        }

        int answer = 0;
        for(int i=0; i<100; i++)
            for(int j=0; j<100; j++)
                if(map[i][j] == 1 && map[i+1][j] == 1 && map[i][j+1] == 1 && map[i+1][j+1] == 1)
                    answer++;

        System.out.println(answer);

    }

    public static void dragon(int x, int y, int d, int g){

        ArrayList<Integer> dir = new ArrayList<>();
        dir.add(d);

        for(int generation = 0; generation<g; generation++){
            for(int i=dir.size()-1; i>=0; i--){
                dir.add((dir.get(i)+1)%4);
            }
        }

        map[y][x] = 1;
        for(int direction : dir){
            x += dx[direction];
            y += dy[direction];
            map[y][x] = 1;
        }

    }


}