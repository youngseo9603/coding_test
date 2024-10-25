import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());

        parents = new int[G+1];
        for (int i = 1; i <= G; i++)
            parents[i] = i;

        int answer = 0;
        for(int p=0; p<P; p++) {
            int g = Integer.parseInt(br.readLine());

            if(find(g) == 0){
                break;
            }
            answer++;
            union(find(g), find(g)-1);

        }

        System.out.println(answer);

    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);
        parents[a] = b;
    }

    static int find(int x){
        if(x == parents[x]) return x;
        return parents[x] = find(parents[x]);
    }
}