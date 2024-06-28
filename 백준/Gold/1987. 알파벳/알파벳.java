import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static int r, c;
    public static int answer;
    public static int[] dx = {1,0,0,-1};
    public static int[] dy = {0,1,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        answer = 0;

        char[][] map = new char[r][c];
        for(int i=0; i<r; i++){
            String input = br.readLine();
            for(int j=0; j<c; j++){
                map[i][j] = input.charAt(j);
            }
        }

        HashMap<Character, Boolean> visited = new HashMap<Character, Boolean>();
        visited.put(map[0][0], true);

        backtracking(map, 0, 0, visited, 1);
        System.out.println(answer);
    }

    public static void backtracking(char[][] map, int x, int y, HashMap<Character, Boolean> visited, int cnt){

        int nx, ny;
        boolean flag = false;
        for(int d=0; d<4; d++){
            nx = x + dx[d];
            ny = y + dy[d];

            if(nx>=0 && nx<r && ny>=0 && ny<c && !visited.getOrDefault(map[nx][ny], false)){
                flag = true;
                visited.put(map[nx][ny], true);
                backtracking(map, nx, ny, visited, cnt + 1);
                visited.put(map[nx][ny], false);
            }
        }

        if(!flag){
            answer = Math.max(answer, cnt);
        }

    }
}