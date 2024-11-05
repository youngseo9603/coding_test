import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        int breakCnt = 0;
        int startCnt = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1)
                    breakCnt++;
                else if (map[i][j] == 2)
                    startCnt++;
            }
        }

        if(breakCnt == 0){
            if(startCnt == 1)
                System.out.println(1);
            else
                System.out.println(-1);
        }
        else {

            int answer = 0;
            answer += divide(0, 0, n, n, false);
            answer += divide(0, 0, n, n, true);

            System.out.println(answer == 0 ? -1 : answer);
        }
    }

    public static int divide(int startX, int startY, int endX, int endY, boolean row){

        int answer = 0;
        int starCnt = 0;
        int breakCnt = 0;
        int result1 = 0;
        int result2 = 0;

        for(int i=startX; i<endX; i++){
            for(int j=startY; j<endY; j++){
                if(map[i][j] == 1)
                    breakCnt++;
                else if(map[i][j] == 2)
                    starCnt++;
            }
        }

        if(starCnt == 0 || starCnt>=2 && breakCnt == 0 || starCnt == 1 && breakCnt >=1) return 0;
        else if(breakCnt == 0 && starCnt == 1) return 1;

        for(int i=startX; i<endX; i++){
            for(int j=startY; j<endY; j++){
                if(map[i][j] == 1 && isJewel(i,j,startX,startY,endX,endY,row)) {
                    if (row) { // 가로로 자르기
                        if (i == startX || i == endX - 1)
                            continue;
                        result1 = divide(startX, startY, i, endY, false); // 위
                        result2 = divide(i + 1, startY, endX, endY, false); // 아래

                    }
                    else { // 세로로 자르기
                        if (j == endY - 1 || j == startY)
                            continue;
                        result1 = divide(startX, startY, endX, j, true); //왼쪽
                        result2 = divide(startX, j + 1, endX, endY, true); // 오른쪽

                    }
                    answer += result1 * result2;
                }
            }
        }

        return answer;
    }

    public static boolean isJewel(int x,int y,int startX,int startY,int endX,int endY,boolean row){

        if(!row) {
            for(int i=startX; i<endX; i++){
                if(map[i][y]==2)
                    return false;
            }
        }
        else {
            for(int j=startY; j<endY; j++){
                if(map[x][j]==2)
                    return false;
            }
        }

        return true;
    }

}