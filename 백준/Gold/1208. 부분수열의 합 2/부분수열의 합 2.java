import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static HashMap<Integer, Long> left = new HashMap<>();
    static HashMap<Integer, Long> right = new HashMap<>();
    static int n;
    static int[] map;
    static int mid;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        map = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            map[i] = Integer.parseInt(st.nextToken());

        mid = n/2;
        visited = new boolean[n];

        powerSet(0,0,mid, true);
        powerSet(mid,0,n, false);

        long answer = 0;

        for(int l : left.keySet()){
            if(right.containsKey(s-l)) {
                answer += left.get(l) * right.get(s - l);
            }
        }

        if(s==0) answer--;
        System.out.println(answer);
    }

    static void powerSet(int idx, int sum, int end, boolean l){
        if(idx == end){
            if(l)
                left.put(sum, left.getOrDefault(sum, Long.valueOf(0)) + 1);
            else
                right.put(sum, right.getOrDefault(sum, Long.valueOf(0)) + 1);
            return;
        }

        visited[idx] = false;
        powerSet(idx+1, sum, end, l);

        visited[idx] = true;
        powerSet(idx+1, sum+map[idx], end, l);

    }

}