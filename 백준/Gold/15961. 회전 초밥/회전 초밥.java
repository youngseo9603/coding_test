import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());


        int[] map = new int[n];

        for(int i=0; i<n; i++)
            map[i] = Integer.parseInt(br.readLine());


        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(c,1);
        for(int i=n-k; i<n; i++)
            hm.put(map[i], hm.getOrDefault(map[i], 0) + 1);
        
        int answer = hm.keySet().size();

        for(int i=0; i<n; i++){
            answer = Math.max(hm.keySet().size(), answer);

            hm.put(map[(n+i-k) % n], hm.get(map[(n+i-k)%n])-1);
            if(hm.get(map[(n+i-k)%n]) == 0){
                hm.remove(map[(n+i-k)%n]);
            }
            hm.put(map[i], hm.getOrDefault(map[i], 0)+1);
        }

        answer = Math.max(hm.keySet().size(), answer);

        System.out.println(answer);

    }
}