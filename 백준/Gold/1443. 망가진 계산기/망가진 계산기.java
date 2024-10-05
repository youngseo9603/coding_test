import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int d;
    public static int p;
    public static int maxValue;
    public static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        d = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        maxValue = (int) Math.pow(10, (long) d) - 1;
        answer = 1;
        int minValue = (int) Math.pow(2, (long) p);
        if(minValue > maxValue){
            System.out.println(-1);
        }
        else {
            dfs(0, 1, 2);
            System.out.println(answer);
        }


    }

    public static void dfs(int depth, int num, int start){
        if(depth == p){
            answer = Math.max(answer, num);
            return;
        }

        for(int i=start; i<10; i++){
            if(num * i <= maxValue)
                dfs(depth+1, num * i, i);
        }


    }

}