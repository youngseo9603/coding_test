import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] start = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            int[][] p = new int[n][2];

            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                p[i][0] = Integer.parseInt(st.nextToken());
                p[i][1] = Integer.parseInt(st.nextToken());
            }
            boolean[] visited = new boolean[n];

            st = new StringTokenizer(br.readLine());
            int[] end = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            Stack<int[]> stack = new Stack<>();
            stack.push(new int[] {start[0], start[1]});

            boolean go = false;

            while(!stack.isEmpty()){
                int[] cur = stack.pop();
                if(canGo(cur, end)){
                    go = true;
                    break;
                }

                for(int i=0; i<n; i++){
                    if(!visited[i] && canGo(cur, p[i])){
                        stack.push(new int[] {p[i][0], p[i][1]});
                        visited[i] = true;
                    }
                }
            }

            if(go || canGo(end, start))
                System.out.println("happy");
            else
                System.out.println("sad");


        }
    }

    public static boolean canGo(int[] start, int[] end){
        if(Math.abs(start[0]-end[0]) + Math.abs(start[1]-end[1]) <= 1000)
            return true;
        return false;
    }


}