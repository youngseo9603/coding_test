import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

    static int n;
    static int[][] map;
    static int[] visited;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        visited = new int[n];

        for(int i=0; i<n; i++){
            String[] s = br.readLine().split(" ");
            for(int j=0; j<n; j++)
                map[i][j] = Integer.parseInt(s[j]);
        }

        answer = Integer.MAX_VALUE;
        team(0);

        System.out.println(answer);

    }

    static void team(int depth){

        if( depth == n-1 ){
            int cnt = 0;
            for(int i : visited){
                if (i==0)   cnt++;
            }
            if (cnt*2 == n){
                answer = Math.min(combination(), answer);
            }
            return;
        }

        visited[depth] = 1;
        team(depth+1);
        visited[depth] = 0;
        team(depth+1);

    }

    static int combination(){
        LinkedList<Integer> s = new LinkedList<>();
        LinkedList<Integer> l = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(visited[i] == 0)
                s.add(i);
            else
                l.add(i);
        }

        int sSum = 0;
        int lSum = 0;

        for(int i=0; i<s.size(); i++)
            for(int j=i+1; j<s.size(); j++)
                sSum += (map[s.get(i)][s.get(j)] + map[s.get(j)][s.get(i)]);

        for(int i=0; i<l.size(); i++)
            for(int j=i+1; j<l.size(); j++)
                lSum += (map[l.get(i)][l.get(j)] + map[l.get(j)][l.get(i)]);

        return Math.abs(sSum - lSum);
    }
}

