import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int k;
    static boolean[][] words;
    static boolean[] learned;
    static boolean[] check;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken()) - 5;

        words = new boolean[n][26];
        learned = new boolean[26];
        check = new boolean[26];
        learned[(int)'a' - 97] = true;
        learned[(int)'n' - 97] = true;
        learned[(int)'t' - 97] = true;
        learned[(int)'i' - 97] = true;
        learned[(int)'c' - 97] = true;

        for(int i=0; i<n; i++){
            String w = br.readLine();
            for(int c=0; c<w.length(); c++){
                words[i][(int)w.charAt(c)-97] = true;
                check[(int)w.charAt(c)-97] = true;
            }
        }

        answer = 0;
        if(k>=0)
            bfs(0, 0);

        System.out.println(answer);

    }

    static void bfs(int depth, int idx){

        if(depth == k || idx == 26){

            int cnt = 0;
            for(int i=0; i<n; i++){
                boolean isValid = true;
                for(int j=0; j<26; j++){
                    if(words[i][j] && !learned[j]) {
                        isValid = false;
                        break;
                    }
                }
                if(isValid)
                    cnt++;

            }
            answer = Math.max(answer, cnt);
            return;
        }

        for(int i=idx; i<26; i++){
            if(check[i] && !learned[i]){
                learned[i] = true;
                bfs(depth+1, i+1);
                learned[i] = false;
            }
        }


        int cnt = 0;
        for(int i=0; i<n; i++){
            boolean isValid = true;
            for(int j=0; j<26; j++){
                if(words[i][j] && !learned[j]) {
                    isValid = false;
                    break;
                }
            }
            if(isValid)
                cnt++;

        }
        answer = Math.max(answer, cnt);

    }

}