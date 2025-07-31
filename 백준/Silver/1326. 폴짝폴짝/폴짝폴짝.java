import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] map = new int[n];
        int answer = -1;
        for(int i=0; i<n; i++)
            map[i] = Integer.parseInt(s[i]);

        s = br.readLine().split(" ");

        int a = Integer.parseInt(s[0])-1;
        int b = Integer.parseInt(s[1])-1;

        boolean[] visited = new boolean[n];
        visited[a] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {a,0});
        while(!queue.isEmpty()){
            int[] temp = queue.poll();

            if(temp[0] == b){
                answer = temp[1];
            }

            int left = temp[0] - map[temp[0]];
            int right = temp[0] + map[temp[0]];

            while(left >= 0 || right < n){
                if(left >= 0 && !visited[left]) {
                    queue.offer(new int[] {left, temp[1]+1});
                    visited[left] = true;
                }
                if(right < n && !visited[right]) {
                    queue.offer(new int[] {right, temp[1]+1});
                    visited[right] = true;
                }
                left -= map[temp[0]];
                right += map[temp[0]];
            }

        }

        System.out.println(answer);

    }
}
