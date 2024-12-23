import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[9][9];

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtracking(0,0);
    }

    public static void backtracking(int x, int y){
        if(y == 9){
            backtracking(x+1, 0);
            return;
        }

        if(x==9 && y==0){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    sb.append(map[i][j]).append(" ");
                }
                sb.append("\n");
            }

            sb.deleteCharAt(sb.length()-1);
            System.out.println(sb.toString());
            System.exit(0);
        }

        if(map[x][y] == 0) {
            List<Integer> next = check(x,y);

            for (int n : next) {
                map[x][y] = n;
                backtracking(x, y+1);
            }
            map[x][y] = 0;
            return;
        }

        backtracking(x, y+1);

    }

    public static List<Integer> check(int r, int c){
        ArrayList<Integer> res = new ArrayList<>();
        boolean find = false;
        for(int i=1; i<=9; i++){
            find = false;
            for(int k=0; k<9; k++){
                if(map[r][k] == i) {
                    find = true;
                    break;
                }
                if(map[k][c] == i){
                    find = true;
                    break;
                }
            }
            if(!find)   res.add(i);
        }

        int x = (r/3)*3;
        int y = (c/3)*3;
        for(int s=0; s<res.size(); s++){
            find = false;
            for (int i = x; i < x + 3; i++) {
                for (int j = y; j < y + 3; j++) {
                    if(map[i][j] == res.get(s)){
                        find = true;
                        break;
                    }
                }
            }
            if(find) {
                res.remove(s);
                s--;
            }
        }

        return res;
    }


    public static List<Integer> checkBox(int r, int c){
        ArrayList<Integer> res = new ArrayList<>();
        int x = (r/3)*3;
        int y = (c/3)*3;

        for(int k=1; k<=9; k++) {
            boolean find = false;
            for (int i = x; i < x + 3; i++) {
                for (int j = y; j < y + 3; j++) {
                    if(map[i][j] == k){
                        find = true;
                        break;
                    }
                }
            }
            if(!find) res.add(k);
        }

        return res;
    }
}