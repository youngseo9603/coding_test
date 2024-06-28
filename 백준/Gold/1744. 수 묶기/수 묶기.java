import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] map = new int[n];
        int cnt = 0;
        boolean zero = false;
        for(int i=0; i<n; i++) {
            map[i] = Integer.parseInt(br.readLine());
            if(map[i] > 0) cnt++;
            if(map[i] == 0) zero = true;
        }

        Arrays.sort(map);
        int answer = 0;


        for(int i=0; i<n-cnt; i++){
            if(i == n-cnt-1) {
                answer += map[i];
                break;
            }

            if(map[i] + map[i+1] >= map[i] * map[i+1]){
                answer += map[i];
            }
            else {
                answer += map[i] * map[i+1];
                i++;
            }

        }

        for(int i=n-1; i>=n-cnt; i--){
            if(i-1 >= n-cnt) {
                if(map[i] == 1 || map[i-1] == 1){
                    answer += map[i] + map[i-1];
                }
                else {
                    answer += map[i] * map[i - 1];
                }
                i--;
            }
            else
                answer += map[i];

        }




        System.out.println(answer);

    }
}