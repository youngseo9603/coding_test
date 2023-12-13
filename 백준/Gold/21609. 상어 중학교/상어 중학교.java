import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        visited = new boolean[n][n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(find_by_bfs()){
//            System.out.println(answer);
//            for(int i=0; i<n; i++){
//                for(int j=0; j<n; j++)
//                    System.out.print(map[i][j] + " ");
//                System.out.println();
//            }
//            System.out.println();
            gravityAndRotate();
        }

        System.out.println(answer);


    }

    static public boolean find_by_bfs(){

        int maxCnt = 1;
        int maxRandbow = 0;
        int maxX = -1;
        int maxY = -1;
        visited = new boolean[n][n];
        // 제일 큰 부분 찾아주기
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){

                for(int a=0; a<n; a++){
                    for(int b=0; b<n; b++)
                        if(map[a][b] == 0)
                            visited[a][b] = false;
                }


                if(!visited[i][j] && map[i][j] != -2 && map[i][j] != 0 && map[i][j] != -1){
                    int cnt = 1;
                    int rainbow = 0;
                    visited[i][j] = true;
                    Stack<int[]> stack = new Stack<>();
                    stack.add(new int[] {i,j});
                    int color = map[i][j];

                    while(!stack.isEmpty()){
                        int[] temp = stack.pop();

                        for(int d=0; d<4; d++){
                            int x = dx[d] + temp[0];
                            int y = dy[d] + temp[1];

                            if(x>=0 && y>=0 && x<n && y<n && !visited[x][y]){
                                if(map[x][y] == color || map[x][y] == 0){
                                    cnt++;
                                    visited[x][y] = true;
                                    stack.add(new int[] {x,y});
                                    if(map[x][y] == 0)
                                        rainbow++;
                                }
                            }
                        }
                    }
                    if(maxCnt < cnt){
                        maxCnt = cnt;
                        maxX = i;
                        maxY = j;
                        maxRandbow = rainbow;
                    }
                    else if (maxCnt == cnt && maxRandbow <= rainbow){
                        maxCnt = cnt;
                        maxX = i;
                        maxY = j;
                        maxRandbow = rainbow;
                    }

                }
            }
        }

        //블록 그룹이 2보다 작으면 stop
        if(maxCnt >= 2) {
//            System.out.println( "               "+ maxX + " " + maxY + " " + maxCnt + " " + maxRandbow);

            visited = new boolean[n][n];
            int color = map[maxX][maxY];
            answer += maxCnt*maxCnt;
            //pop
            Stack<int[]> stack = new Stack<>();
            stack.add(new int[] {maxX, maxY});
            map[maxX][maxY] = -2;
            visited[maxX][maxY] = true;
            while(!stack.isEmpty()){
                int[] temp = stack.pop();
                for(int d=0; d<4; d++){
                    int x = dx[d] + temp[0];
                    int y = dy[d] + temp[1];

                    if(x>=0 && y>=0 && x<n && y<n && !visited[x][y]){
                        if(map[x][y] == color || map[x][y] == 0){
                            visited[x][y] = true;
                            map[x][y] = -2;
                            stack.add(new int[] {x,y});
                        }
                    }
                }
            }
            return true;
        }
        else
            return false;

    }

    static void gravityAndRotate(){
        int[] temp;
        int cnt;
        int[][] nextMap = new int[n][n];
        int[][] testMap = new int[n][n];
        for(int i=0; i<n; i++){
            cnt = 0;
            temp = new int[n];
            for(int j=0; j<n; j++){
                if(map[n-j-1][i] == -2)
                    cnt++;
                else if(map[n-j-1][i] == -1){
                    for(int z=0; z<cnt; z++)
                        temp[j+z-cnt] = -2;
                    cnt = 0;
                    temp[j-cnt] = -1;
                }
                else
                    temp[j-cnt] = map[n-j-1][i];
            }
            for(int z=0; z<cnt; z++){
                temp[n-1-z] = -2;
            }

            for(int j=0; j<n; j++){
                testMap[n-j-1][i] = temp[j];
            }

            for(int j=0; j<n; j++){
                nextMap[n-i-1][n-j-1] = temp[j];
            }
        }

//        for(int i=0; i<n; i++){
//            for(int j=0; j<n; j++)
//                System.out.print(testMap[i][j] + " ");
//            System.out.println();
//        }
//        System.out.println();
//
//
//        for(int i=0; i<n; i++){
//            for(int j=0; j<n; j++)
//                System.out.print(nextMap[i][j] + " ");
//            System.out.println();
//        }
//        System.out.println();

        for(int i=0; i<n; i++){
            cnt = 0;
            temp = new int[n];
            for(int j=0; j<n; j++){
                if(nextMap[n-j-1][i] == -2)
                    cnt++;
                else if(nextMap[n-j-1][i] == -1){
                    for(int z=0; z<cnt; z++)
                        temp[j+z-cnt] = -2;
                    cnt = 0;
                    temp[j-cnt] = -1;
                }
                else
                    temp[j-cnt] = nextMap[n-j-1][i];
            }
            for(int z=0; z<cnt; z++){
                temp[n-1-z] = -2;
            }

            for(int j=0; j<n; j++)
                map[n-1-j][i] = temp[j];

        }
//
//        for(int i=0; i<n; i++){
//            for(int j=0; j<n; j++)
//                System.out.print(map[i][j] + " ");
//            System.out.println();
//        }
//        System.out.println();

    }

}


/*
    64점

    1   -1
    3           2   1
   -1           3   2
            2   1   2
            1  -1   2
    64 + 9 73점


                     2
                    -1
         1
    -1   2   3   1
     1   3  -1   2   1

    73 + 4 77점


        -1        1
              1   2
              3  -1
              2   3
    2    1   -1   1
*/
/*

    2310-12
    2-14133
    304-2-21
    -14-1-234
    3-14-2-23
    1-2-2-2-21


        2   -2  -2  -2  -2  -2
        -1  -2  -2  -2  3   1
        -2  3   1   4   3   3
        1   4   4   -1  0   1
        3   -1  0   4  -1   4
        2   2   3   -1  3   1

4 4
2 1 4 2
4 4 0 1
1 2 3 3
-1 2 2 1
*/