import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<m; j++){
                map[i][j] = (int) s.charAt(j) - 48;
            }
        }

        int[][] space = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        int[][] pieces = new int[n][m];
        int p = 1;


        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int cnt = 0;
                p++;
                if(map[i][j] == 1) space[i][j] = 0;
                else if(!visited[i][j]){
                    visited[i][j] = true;
                    cnt++;
                    Stack<int[]> stack = new Stack<>();
                    List<int[]> list = new ArrayList<>();
                    stack.push(new int[]{i,j});
                    list.add(new int[]{i,j});
                    while(!stack.isEmpty()){
                        int[] cur = stack.pop();

                        for(int d=0; d<4; d++){
                            int x = cur[0] + dx[d];
                            int y = cur[1] + dy[d];
                            if(x >= 0 && x < n && y >= 0 && y < m && !visited[x][y] && map[x][y] == 0){
                                stack.push(new int[]{x,y});
                                list.add(new int[]{x,y});
                                visited[x][y] = true;
                                cnt++;
                            }
                        }
                    }

                    for(int[] l : list){
                        space[l[0]][l[1]] = cnt;
                        pieces[l[0]][l[1]] = p;
                    }

                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++) {
                if(map[i][j] == 0) sb.append(0);
                else{
                    int count = 1;
                    List<Integer> piece = new ArrayList<>();
                    for(int d=0; d<4; d++){
                        int x = i + dx[d];
                        int y = j + dy[d];

                        if(x >= 0 && y >= 0 && x<n && y<m){
                            if(!piece.contains(pieces[x][y])){
                                count += space[x][y];
                                piece.add(pieces[x][y]);
                            }
                        }
                    }
                    sb.append(count%10);
                }

            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
}