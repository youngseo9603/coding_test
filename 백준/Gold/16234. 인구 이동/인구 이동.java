import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];
        visited = new boolean[n][n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        boolean change = true;
        int time = 0;

        while(change){
            change = false;
            visited = new boolean[n][n];
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(!visited[i][j]){
                        Stack<int[]> stack = new Stack<>();
                        Stack<int[]> unite = new Stack<>();
                        stack.add(new int[] {i,j});
                        unite.add(new int[] {i,j,map[i][j]});
                        visited[i][j] = true;
                        while(!stack.isEmpty()){
                            int[] temp = stack.pop();

                            for(int d=0; d<4; d++){
                                int x = temp[0]+dx[d];
                                int y = temp[1]+dy[d];

                                if(x>=0 && x<n && y>=0 && y<n && !visited[x][y]){
                                    if(Math.abs(map[temp[0]][temp[1]] - map[x][y]) >= l && Math.abs(map[temp[0]][temp[1]] - map[x][y]) <= r){
                                        stack.add(new int[] {x,y});
                                        visited[x][y] = true;
                                        change = true;
                                        unite.add(new int[] {x,y,map[x][y]});
                                    }
                                }
                            }
                        }

                        int avg = 0;
                        for(int[] u : unite)
                            avg += u[2];
                        avg = avg / unite.size();

                        for(int[] u : unite)
                            map[u[0]][u[1]] = avg;

                    }
                }
            }

            if(change)
                time++;
        }

        System.out.println(time);

    }
}