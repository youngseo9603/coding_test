import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] coin;
    static int n;
    static int k;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());


        coin = new int[n];

        for(int i=0; i<n; i++)
            coin[i] = Integer.parseInt(br.readLine());

        answer = Integer.MAX_VALUE;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {k,0});
        boolean[] visited = new boolean[k+1];
        visited[k] = true;

        while (!queue.isEmpty()){
            int[] q = queue.poll();
            if(q[0] == 0){
                answer = q[1];
            }

            for(int i=0; i<n; i++){
                if(q[0]-coin[i]>=0 && !visited[q[0]-coin[i]]) {
                    queue.add(new int[]{q[0] - coin[i], q[1] + 1});
                    visited[q[0]-coin[i]] = true;
                }
            }

        }


//        dfs(0,0);

        if(answer != Integer.MAX_VALUE)
            System.out.println(answer);
        else
            System.out.println(-1);
    }


//    public static void dfs(int money, int depth){
//        if(money >= k){
//            if(money == k)
//                answer = Math.min(answer, depth);
//
//            return;
//        }
//
//        for(int i=0; i<n; i++){
//            dfs(money+coin[i], depth+1);
//        }
//
//    }

}