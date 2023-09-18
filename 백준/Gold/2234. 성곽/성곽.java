import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        boolean[][][] d = new boolean[n][m][4]; //상하좌우 가능한지 확인
        int[][][] wall = new int[n][m][2];

        for(int i=0; i<n; i++){
            String[] s = br.readLine().split(" ");
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(s[j]);
                int t = map[i][j];

                if(t >= 8) //하 남쪽에 벽 있음
                    t-=8;
                else
                    d[i][j][1] = true;

                if(t >= 4) //우 동쪽에 벽 있음
                    t-=4;
                else
                    d[i][j][3] = true;

                if(t >= 2) //상 북쪽에 벽 있음
                    t-=2;
                else
                    d[i][j][0] = true;

                if(t >= 1) //좌 서쪽에 벽 있음
                    t-=1;
                else
                    d[i][j][2] = true;
            }
        }

        boolean[][] visited = new boolean[n][m];
        int answer1 = 0;
        int answer2 = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                Stack<int[]> stack = new Stack<>();
                if(!visited[i][j]){
                    stack.add(new int[] {i,j});
                    visited[i][j] = true;
                    int size = 0;
                    while(!stack.isEmpty()){
                        size++;
                        int[] temp = stack.pop();

                        if(d[temp[0]][temp[1]][0] && !visited[temp[0]-1][temp[1]]){ //상
                            stack.add(new int[] {temp[0]-1, temp[1]});
                            visited[temp[0]-1][temp[1]] = true;
                        }
                        if(d[temp[0]][temp[1]][1] && !visited[temp[0]+1][temp[1]]){ //하
                            stack.add(new int[] {temp[0]+1, temp[1]});
                            visited[temp[0]+1][temp[1]] = true;
                        }
                        if(d[temp[0]][temp[1]][2] && !visited[temp[0]][temp[1]-1]){ //좌
                            stack.add(new int[] {temp[0], temp[1]-1});
                            visited[temp[0]][temp[1]-1] = true;
                        }
                        if(d[temp[0]][temp[1]][3] && !visited[temp[0]][temp[1]+1]){ //우
                            stack.add(new int[] {temp[0], temp[1]+1});
                            visited[temp[0]][temp[1]+1] = true;
                        }

                    }
                    answer1++;
                    answer2 = Math.max(answer2, size);

                    for(int a=0; a<n; a++){
                        for(int b=0; b<m; b++){
                            if(visited[a][b] && wall[a][b][0] == 0) {
                                wall[a][b][0] = size;
                                wall[a][b][1] = answer1;
                            }
                        }
                    }

                }

            }
        }

        int answer3 =0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i+1<n && !d[i][j][1] && !d[i+1][j][0] && wall[i][j][1] != wall[i+1][j][1]){
                    answer3 = Math.max(answer3, wall[i][j][0] + wall[i+1][j][0]);
                }
                else if (j+1<m && !d[i][j][3] && !d[i][j+1][2] && wall[i][j][1] != wall[i][j+1][1]) {
                    answer3 = Math.max(answer3, wall[i][j][0] + wall[i][j+1][0]);
                }
            }
        }

        System.out.println(answer1);
        System.out.println(answer2);
        System.out.println(answer3);


    }

}