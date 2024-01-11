import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int[][] map;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        answer = 0;

        dfs(0,map);

        System.out.println(answer);

    }

    static void dfs(int depth, int[][] map){

//        System.out.println();
        for(int i=0; i<n; i++) {
            for (int j = 0; j < n; j++) {
                answer = Math.max(answer, map[i][j]);
//                System.out.print(map[i][j] + " ");
            }
//            System.out.println();
        }

        if(depth == 5){

            return;
        }

        int[][] nextMap = new int[n][n];

        nextMap = moveRight(map);
        if(!Arrays.deepEquals(nextMap, map)) {
//            System.out.println("동");
            dfs(depth + 1, nextMap);
        }

        nextMap = moveLeft(map);
        if(!Arrays.deepEquals(nextMap, map)) {
//            System.out.println("서");
            dfs(depth + 1, nextMap);
        }

        nextMap = moveUp(map);
        if(!Arrays.deepEquals(nextMap, map)) {
//            System.out.println("북");
            dfs(depth + 1, nextMap);
        }

        nextMap = moveDown(map);
        if(!Arrays.deepEquals(nextMap, map)) {
//            System.out.println("남");
            dfs(depth + 1, nextMap);
        }
    }

    static int[][] moveUp(int[][] map){
        int[][] nextMap = new int[n][n];

        for(int i=0; i<n; i++){
            Stack<Integer> stack = new Stack<>();
            boolean cnt = false;
            for(int j=0; j<n; j++){
                if(cnt && map[j][i] != 0){
                    stack.add(map[j][i]);
                    cnt = false;
                }
                else if(map[j][i] != 0) {
                    if(!stack.isEmpty() && stack.peek() == map[j][i]){
                        stack.pop();
                        stack.add(2*map[j][i]);
                        cnt = true;
                    }
                    else
                        stack.add(map[j][i]);
                }
            }

            int k = stack.size()-1;
            while(!stack.isEmpty()) {
                nextMap[k][i] = stack.pop();
                k--;
            }
        }

        return nextMap;
    }

    static int[][] moveDown(int[][] map){
        int[][] nextMap = new int[n][n];

        for(int i=0; i<n; i++){
            Stack<Integer> stack = new Stack<>();
            boolean cnt = false;
            for(int j=n-1; j>=0; j--){
                if(cnt && map[j][i] != 0) {
                    stack.push(map[j][i]);
                    cnt = false;
                }
                else if(map[j][i] != 0){
                    if(!stack.isEmpty() && stack.peek() == map[j][i]){
                        stack.pop();
                        stack.add(2*map[j][i]);
                        cnt = true;
                    }
                    else
                        stack.add(map[j][i]);
                }
            }

            int k = stack.size()-1;

            while(!stack.isEmpty()) {
                nextMap[n - k - 1][i] = stack.pop();
                k--;
            }
        }
        return nextMap;
    }

    static int[][] moveRight(int[][] map){
        int[][] nextMap = new int[n][n];

        for(int i=0; i<n; i++) {
            Stack<Integer> stack = new Stack<>();
            boolean cnt = false;
            for(int j=n-1; j>=0; j--){
                if(cnt && map[i][j] != 0){
                    cnt = false;
                    stack.push(map[i][j]);
                }
                else if(map[i][j] != 0){
                    if(!stack.isEmpty() && stack.peek() == map[i][j]){
                        stack.pop();
                        stack.add(2*map[i][j]);
                        cnt = true;
                    }
                    else
                        stack.add(map[i][j]);
                }
            }

            int  k = stack.size()-1;
            while(!stack.isEmpty()) {
                nextMap[i][n - k - 1] = stack.pop();
                k--;
            }
        }

        return  nextMap;
    }

    static int[][] moveLeft(int[][] map){
        int[][] nextMap = new int[n][n];

        for(int i=0; i<n; i++) {
            Stack<Integer> stack = new Stack<>();
            boolean cnt = false;
            for(int j=0; j<n; j++){
                if(cnt && map[i][j] != 0){
                    cnt = false;
                    stack.push(map[i][j]);
                }
                else if(map[i][j] != 0){
                    if(!stack.isEmpty() && stack.peek() == map[i][j]){
                        stack.pop();
                        stack.add(2*map[i][j]);
                        cnt = true;
                    }
                    else
                        stack.add(map[i][j]);
                }
            }

            int k = stack.size()-1;
            while(!stack.isEmpty()) {
                nextMap[i][k] = stack.pop();
                k--;
            }
        }

        return  nextMap;

    }


}