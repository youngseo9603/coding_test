import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int max;
    public static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        int[] num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            num[i] = Integer.parseInt(st.nextToken());

        int[] arr = new int[4];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        dfs(1, num, arr, num[0]);

        System.out.println(max);
        System.out.println(min);
    }


    public static void dfs(int depth, int[] num, int[] arr, int answer){
        if(depth == n){
            max = Math.max(max, answer);
            min = Math.min(min, answer);
            return;
        }

        for(int i=0; i<4; i++){
            if(arr[i] > 0){
                arr[i]--;
                dfs(depth+1, num, arr, method(i, answer, num[depth]));
                arr[i]++;
            }
        }

    }

    public static int method(int m, int num, int target){
        if(m==0)    return num + target;
        else if(m==1)   return num - target;
        else if(m==2)   return num * target;
        else return num / target;
    }

}