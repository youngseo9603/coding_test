import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {1,-1,0,0,1,1,-1,-1};
    static int[] dy = {0,0,1,-1,1,-1,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        boolean[][] visited = new boolean[n][m];

        int answer = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j]){
                    Stack<int[]> stack = new Stack<>();
                    stack.add(new int[] {i,j});
                    visited[i][j] = true;
                    boolean isTop = true;
                    while (!stack.isEmpty()){
                        int[] temp = stack.pop();
//                        System.out.println(temp[0] + " " + temp[1]);

                        if(isTop) {
                            for (int k = 0; k < 8; k++) {
                                int kx = dx[k] + temp[0];
                                int ky = dy[k] + temp[1];

                                if (kx >= 0 && ky >= 0 && kx < n && ky < m && map[temp[0]][temp[1]] < map[kx][ky]) {
                                    isTop = false;
                                    break;
                                }
                            }
                        }

                        for(int d=0; d<8; d++){
                            int x = dx[d] + temp[0];
                            int y = dy[d] + temp[1];

                            if(x>=0 && y>=0 && x<n && y<m && !visited[x][y] && map[x][y] == map[temp[0]][temp[1]]){
                                visited[x][y] = true;
                                stack.add(new int[] {x,y});

                            }
                        }
                    }

                    if(isTop)   answer++;
                }
            }
        }

        System.out.println(answer);

    }
}