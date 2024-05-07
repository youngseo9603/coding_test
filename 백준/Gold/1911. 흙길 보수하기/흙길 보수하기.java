import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        WaterPool[] waterPools = new WaterPool[n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            waterPools[i] = new WaterPool(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(waterPools);

        int answer = 0;
        int cnt = (int) Math.ceil((double) (waterPools[0].end - waterPools[0].start) /l);
        int end = waterPools[0].start + l * cnt;
        answer += cnt;
        
        for(int i=1; i<n; i++){
            if(end > waterPools[i].start){
                cnt = (int) Math.ceil((double) (waterPools[i].end - end) /l);
                end += cnt*l;
                answer += cnt;
            }
            else {
                cnt = (int) Math.ceil((double) (waterPools[i].end - waterPools[i].start) /l);
                end = waterPools[i].start + l * cnt;
                answer += cnt;
            }

        }


        System.out.println(answer);

    }

    public static class WaterPool implements Comparable<WaterPool> {
        int start;
        int end;

        WaterPool(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(WaterPool o){
            return this.start - o.start;
        }

    }
}