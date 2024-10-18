import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String s = br.readLine();

        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Character> deque = new ArrayDeque<>();

        for(int i = 0; i < n; i++) {
            if(deque.isEmpty() || cnt == k)
                deque.add(s.charAt(i));
            else if(deque.peekLast() < s.charAt(i)){
                while(!deque.isEmpty() && deque.peekLast() < s.charAt(i) && cnt < k){
                    deque.removeLast();
                    cnt++;
                }
                deque.addLast(s.charAt(i));
            }
            else deque.addLast(s.charAt(i));
        }

        for(char c : deque) {
            sb.append(c);
        }

        while(cnt < k){
            sb.deleteCharAt(sb.length()-1);
            cnt++;
        }


        System.out.println(sb);

    }
}