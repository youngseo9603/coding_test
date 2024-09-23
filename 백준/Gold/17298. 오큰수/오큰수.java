import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && a[stack.peek()] <a[i]){
                 answer[stack.pop()] = a[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            answer[stack.pop()] = -1;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);


    }
}