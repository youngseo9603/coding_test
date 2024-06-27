import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = n/3 * 6 - 1;
        map = new char[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = ' ';
            }
        }

        draw(n, m);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            for (int j = 0; j < m; j++)
                sb.append(map[i][j]);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static char[][] draw(int n, int m) {

        int x = 0;
        int y = m/2;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        Queue<int[]> next = new LinkedList<>();
        next.add(new int[]{x, y});

        for(int i=0; i<n; i+=3){

            for(int[] q : next) {
                paint(q[0], q[1]);
                queue.add(q);
            }

            next.clear();

            while(i != n-3 && !queue.isEmpty()){
                int[] cur = queue.poll();
                if((map[cur[0]+2][cur[1]-2] == ' ' && map[cur[0]+2][cur[1]-4] == '*') || (map[cur[0]+2][cur[1]-2] == '*' && map[cur[0]+2][cur[1]-4] == ' ')){
                    next.add(new int[]{cur[0]+3, cur[1]-3});
                }
                if((map[cur[0]+2][cur[1]+2] == ' ' && map[cur[0]+2][cur[1]+4] == '*') || (map[cur[0]+2][cur[1]+2] == '*' && map[cur[0]+2][cur[1]+4] == ' ')){
                    next.add(new int[]{cur[0]+3, cur[1]+3});
                }
            }
        }

        return map;
    }


    public static void paint(int x, int y) {

        map[x][y] = '*';
        map[x + 1][y - 1] = '*';
        map[x + 1][y + 1] = '*';
        map[x + 2][y - 2] = '*';
        map[x + 2][y - 1] = '*';
        map[x + 2][y] = '*';
        map[x + 2][y + 1] = '*';
        map[x + 2][y + 2] = '*';

    }

}