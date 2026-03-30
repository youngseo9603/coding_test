import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int m;
    public static int[][] map;
    public static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        int cnt = 0;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2)
                    cnt++;
            }
        }

        m = cnt - m;
        answer = Integer.MAX_VALUE;

        backtracking(0,0);

        System.out.print(answer);
    }

    public static void backtracking(int depth, int cur){

        if(depth == m){

            Stack<int[]> stack = new Stack<>();
            int[][] tmap = new int[n][n];
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    tmap[i][j] = map[i][j];
                    if(map[i][j] == 2)
                        stack.add(new int[] {i,j});
                    if(tmap[i][j] == 1)
                        tmap[i][j] = Integer.MAX_VALUE;
                }
            }



            for(int[] t : stack){
                for(int i=0; i<n; i++){
                    for(int j=0; j<n; j++){
                        if(map[i][j] != 0 && map[i][j] != 2){
                            tmap[i][j] = Math.min(tmap[i][j], Math.abs(t[0] - i) + Math.abs(t[1] - j));
                        }
                    }
                }
            }

            int cnt = 0;
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(map[i][j] != 0 && map[i][j] != 2){
                        cnt += tmap[i][j];
                    }
                }
            }

            answer = Math.min(answer, cnt);

            return;
        }

        int x;
        int y;

        for(; cur<n*n; cur++){
            x = cur/n;
            y = cur%n;

            if(map[x][y] == 2){
                map[x][y] = 0;

                depth += 1;

                backtracking(depth, cur+1);
                depth -= 1;
                map[x][y] = 2;
            }
        }

        return;

    }

}
