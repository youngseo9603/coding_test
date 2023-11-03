import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];

        int x1, x2, y1, y2;

        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            for(int x=x1; x<x2; x++)
                for(int y=y1; y<y2; y++)
                    map[x][y] = 1;

        }

        boolean[][] visited = new boolean[n][m];
        Stack<int[]> stack;
        List<Integer> answer = new ArrayList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == 0 && !visited[i][j]){
                    stack = new Stack<>();
                    stack.add(new int[] {i,j});
                    visited[i][j] = true;
                    int cnt = 1;
                    while(!stack.isEmpty()){
                        int[] temp = stack.pop();

                        for(int d=0; d<4; d++){
                            int x = dx[d] + temp[0];
                            int y = dy[d] + temp[1];

                            if(x>=0 && x<n && y>=0 && y<m && !visited[x][y] && map[x][y] == 0){
                                stack.add(new int[] {x,y});
                                cnt++;
                                visited[x][y] = true;
                            }

                        }
                    }
                    answer.add(cnt);
                }
            }
        }

        System.out.println(answer.size());
        Collections.sort(answer);
        for(int a : answer)
            System.out.print(a + " ");
    }

}