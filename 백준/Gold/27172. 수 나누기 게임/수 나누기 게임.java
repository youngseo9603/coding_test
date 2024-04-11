import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] card = new int[n];
        HashMap<Integer, Integer> point = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        for(int i=0; i<n; i++) {
            card[i] = Integer.parseInt(st.nextToken());
            point.put(card[i], 0);
            max = Math.max(max, card[i]);
        }

        for(int i=0; i<n; i++){
            int p = card[i];
            int t = 2 * p;
            while(t <= max){
                if(point.containsKey(t)){
                    point.put(t, point.get(t)-1);
                    point.put(p, point.get(p)+1);
                }
                t += p;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++)
            sb.append(point.getOrDefault(card[i], 0)).append(" ");

        System.out.println(sb);
    }
}