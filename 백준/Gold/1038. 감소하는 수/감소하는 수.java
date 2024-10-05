import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int n;
    public static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        cnt = -1;

        if(n > 1022)
            System.out.println("-1");
        else {
            for(int i=1; i<=10; i++){
                if(cnt<n)
                    dfs(0, i,10,0);
            }
        }

    }

    public static void dfs(int depth, int d, int lastNum, long num){
        if(depth == d){

            cnt++;
            if(cnt == n){
                System.out.println(num);
                return;
            }
            return;
        }

        for(int i=0; i<lastNum; i++){
            dfs(depth+1, d, i, i+num*10);
        }

    }

}

/*
    0 1 2 3 4 5 6 7 8 9 10 20 21 30 31 32 43 42 41
 */