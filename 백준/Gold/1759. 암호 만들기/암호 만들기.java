import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int l;
    static int c;
    static String[] s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        s = br.readLine().split(" ");

        Arrays.sort(s);
        Stack<String> stack = new Stack<>();
        backtracking(0,0, stack);

    }

    public static void backtracking(int dept, int cur, Stack<String> stack) {
        if(dept == l){
            StringBuilder sb = new StringBuilder();
            boolean exist = false;
            int cnt = 0;
            for(String s1 : stack) {
                if(s1.equals("a") || s1.equals("e") || s1.equals("i") || s1.equals("o") || s1.equals("u"))
                    exist = true;
                else cnt++;
                sb.append(s1);
            }
            if(exist && cnt >= 2)
                System.out.println(sb);

            return;
        }

        for(int i=cur; i<c; i++){
            stack.push(s[i]);
            backtracking(dept + 1, i+1, stack);
            stack.pop();
        }


    }

}