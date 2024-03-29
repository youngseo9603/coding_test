import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static class Node implements Comparable<Node> {
        int first;
        int second;

        Node(int f, int t){
            this.first = f;
            this.second = t;
        }

        @Override
        public int compareTo(Node o) {
            return first - o.first;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Node[] map = new Node[n];
        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            map[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(map);

        int[] dp = new int[n];
        dp[0] = 1;
        for(int i=1; i<n; i++){
            dp[i] = 1;
            for(int j=0; j<i; j++) {
                if(map[i].second > map[j].second)
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
        }
        int answer = 0;
        for(int i=0; i<n; i++)
            answer = Math.max(answer, dp[i]);
        System.out.println(n - answer);
    }
}