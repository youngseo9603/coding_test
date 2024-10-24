import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int h;
    public static int[] up;
    public static int[] down;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        up = new int[h+2];
        down = new int[h+2];

        for(int i = 1; i <= n/2; i++) {
            int a = Integer.parseInt(br.readLine());
            int b = h-Integer.parseInt(br.readLine())+1;
            down[a]++;
            up[b]++;
        }

        for(int i=1; i<=h; i++)
            down[i] += down[i-1];
        for(int i=h; i>0; i--)
            up[i] += up[i+1];

        int answer = n;
        int cnt = 0;
        for(int i=1; i<=h; i++){
            int dif = down[h] - down[i-1] + up[1] - up[i+1];

            if(dif < answer){
                answer = dif;
                cnt = 1;
            }
            else if(dif == answer)
                cnt++;

        }
        System.out.println(answer + " " + cnt);



    }

}