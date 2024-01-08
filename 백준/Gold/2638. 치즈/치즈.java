import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

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

        int time = 0;

        while(true){

            int[][] nmap = new int[n][m];

            for(int i=0; i<n; i++)
                for (int j = 0; j < m; j++)
                    nmap[i][j] = map[i][j];

            boolean[][] inside = new boolean[n][m];
            boolean[][] visited = new boolean[n][m];

            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(!visited[i][j]){
                        visited[i][j] = true;
                        List<int []> list = new ArrayList<>();
                        list.add(new int[] {i,j});
                        Stack<int[]> stack = new Stack<>();
                        stack.add(new int[] {i,j});
                        boolean in = false;

                        while(!stack.isEmpty()){
                            int[] temp = stack.pop();

                            if(temp[0] == 0 || temp[1] == 0 || temp[0]==n-1 || temp[1]==m-1)
                                in = true;

                            for(int d=0; d<4; d++){
                                int x = dx[d] + temp[0];
                                int y = dy[d] + temp[1];

                                if(x>=0 && y>=0 && x<n && y<m && !visited[x][y] && map[x][y] == 0){
                                    stack.add(new int[] {x,y});
                                    visited[x][y] = true;
                                    list.add(new int[] {x,y});
                                }
                            }
                        }

                        if(in == true){
                            for(int[] t : list)
                                inside[t[0]][t[1]] = true;
                        }

                    }
                }
            }


            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(map[i][j] == 1){

                        int cnt = 0;
                        for(int d=0; d<4; d++){
                            int x = dx[d] + i;
                            int y = dy[d] + j;

                            if(x>=0 && y>=0 && x<n && y<m && map[x][y] == 0 && inside[x][y] == true) {
                                cnt++;
                            }
                        }

                        if(cnt >= 2){
                            nmap[i][j] = 0;
                        }
                    }
                }
            }

            boolean cnt = false;
            for(int i=0; i<n; i++) {
                for (int j = 0; j < m; j++) {
                    if(map[i][j] != nmap[i][j])
                        cnt = true;
                    map[i][j] = nmap[i][j];
                }
            }

            if(!cnt)
                break;

            time++;
        }

        System.out.println(time);
    }

}