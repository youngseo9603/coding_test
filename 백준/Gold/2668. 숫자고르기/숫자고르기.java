import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static int n;
    public static int[] nums;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        nums = new int[n+1];
        for(int i=1; i<=n; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }

        boolean flag;
        List<Integer> answer = new ArrayList<>();

        for(int i=1; i<=n; i++){
            visited = new boolean[n+1];
            flag = false;
            visited[i] = true;
            int next = nums[i];

            if(next == i){
                flag = true;
            }
            else {
                while(!visited[next]){
                    visited[next] = true;
                    next = nums[next];
                    if(next == i) {
                        flag = true;
                        break;
                    }
                }
            }

            if(flag) answer.add(i);
        }

        Collections.sort(answer);

        System.out.println(answer.size());
        for(int i : answer)
            System.out.println(i);

    }

}