import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {n,0});

        int[] visited = new int[200000];
        visited[n] = 1;
        int[] x;
        int answer = 0;

        while (!q.isEmpty()) {
            x = q.poll();
            if (x[0] == k) {
                answer = x[1];
                break;
            }

            if(x[0] * 2 < 200000 && (visited[x[0]*2] == 0 || visited[x[0]*2] == x[1] + 1)) {
                q.add(new int[]{x[0] * 2, x[1] + 1});
                visited[x[0]*2] = x[1] + 1;
            }
            if(x[0] + 1 < 200000 && (visited[x[0]+1] == 0 || visited[x[0]+1] == x[1] + 1)) {
                q.add(new int[]{x[0] + 1, x[1] + 1});
                visited[x[0]+1] = x[1] + 1;
            }
            if(x[0]-1 >= 0 && (visited[x[0]-1] == 0 || visited[x[0]-1] == x[1] + 1)) {
                q.add(new int[]{x[0] - 1, x[1] + 1});
                visited[x[0]-1] = x[1] + 1;
            }

        }
        int cnt = 1;
        for(int[] t : q){
            if(t[1] == answer && t[0]==k)
                cnt++;
        }

        System.out.println(answer);
        System.out.println(cnt);


    }
}