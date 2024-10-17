import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[] dx = {1,0,0,-1};
    static int[] dy = {0,1,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 1;
        int year = 0;
        while(cnt < 2){
            map = nextYear(map);
            year++;
            cnt = count(map);
            boolean melt = false;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(map[i][j] != 0)
                        melt = true;
                }
            }
            if(!melt) {
                year = 0;
                break;
            }
        }

        System.out.println(year);

    }

    public static int[][] nextYear(int[][] map) {
        int[][] next = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                next[i][j] = map[i][j];
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 0){
                    for(int d=0; d<4; d++) {
                        int x = i + dx[d];
                        int y = j + dy[d];

                        if(x>=0 && x<n && y>=0 && y<m && next[x][y] > 0) {
                            next[x][y]--;
                        }
                    }
                }
            }
        }

        return next;
    }

    static int count(int[][] map) {
        int cnt = 0;
        boolean[][] visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] != 0 && !visited[i][j]) {
                    Stack<int[]> stack = new Stack<>();
                    stack.push(new int[]{i, j});
                    visited[i][j] = true;
                    while(!stack.isEmpty()) {
                        int[] pop = stack.pop();

                        for(int d=0; d<4; d++) {
                            int x = pop[0] + dx[d];
                            int y = pop[1] + dy[d];

                            if(x>=0 && x<n && y>=0 && y<m && !visited[x][y] && map[x][y] > 0) {
                                stack.push(new int[]{x, y});
                                visited[x][y] = true;
                            }
                        }
                    }
                    cnt++;
                }
            }
        }

        return cnt;
    }

}