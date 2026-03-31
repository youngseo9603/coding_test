import sun.awt.image.ImageWatched;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

    public static String[] map;
    public static int answer;
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new String[5];

        for(int i=0; i<5; i++)
            map[i] = br.readLine();

        Stack<Integer> stack = new Stack<>();
        backtracking(0,0,stack);

        System.out.println(answer);

    }

    public static void backtracking(int depth, int cur, Stack<Integer> stack){

        if(depth == 7){

            int cnt = 0;

            if(check(stack)) {
                for(int s : stack){
                    if(map[s/5].charAt(s%5) == 'S')
                        cnt++;
                }
                if(cnt >= 4)
                    answer++;
            }
            return;
        }

        for(int i=cur; i<25; i++){
            stack.push(i);
            backtracking(depth+1, i+1,stack);
            stack.pop();
        }

        return;

    }

    public static boolean check(Stack<Integer> stack){
        int[][] m = new int[5][5];
        boolean[][] visited = new boolean[5][5];
        int count = 0;

        for(int s : stack){
            int x = s/5;
            int y = s%5;

            m[x][y] = 1;
        }

        Stack<int[]> s = new Stack<>();
        s.push(new int[] {stack.peek()/5, stack.peek()%5});
        visited[stack.peek()/5][stack.peek()%5] = true;

        while(!s.isEmpty()){
            int[] cur = s.pop();

            for(int d=0; d<4; d++){
                int nx = dx[d] + cur[0];
                int ny = dy[d] + cur[1];

                if(nx>=0 && ny>=0 && nx<5 && ny<5 && !visited[nx][ny] && m[nx][ny]==1){
                    s.push(new int[] {nx, ny});
                    visited[nx][ny] = true;
                    count++;
                }
            }
        }

        return count == 6;
    }

}
