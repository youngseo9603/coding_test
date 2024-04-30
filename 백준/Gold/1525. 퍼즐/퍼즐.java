import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int[] dd = {3,-3,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] map = new int[3][3];
        StringTokenizer st;
        for(int i=0; i<3; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        String answer = "123456780";
        HashMap<String, Integer> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(mapToString(map),0));
        visited.put(mapToString(map), 1);
        int ans = -1;


        while(!queue.isEmpty()){
            Node n = queue.poll();

            if(n.s.equals(answer)){
                ans = n.cnt;
                break;
            }

            int a = 0;
            for(int i=0; i<9; i++)
                if(n.s.charAt(i) == '0'){
                    a = i;
                    break;
                }

            for(int j=0; j<4; j++){
                int x = dd[j] + a;
                
                if((a/3 != x/3) && j>1){
                    continue;
                }

                if(x>=0 && x<9){
                    String n_s = swap(n.s, a, x);
                    if(!visited.containsKey(n_s)){
                        queue.add(new Node(n_s, n.cnt+1));
                        visited.put(n_s, 1);
                    }
                }

            }
        }

        System.out.println(ans);

    }

    public static class Node{
        String s;
        int cnt;

        Node(String s, int cnt){
            this.s = s;
            this.cnt = cnt;
        }

    }

    public static String mapToString(int[][] map){
        StringBuilder response = new StringBuilder();
        for(int i=0; i<3; i++)
            for(int j=0; j<3; j++)
                response.append(map[i][j]);
        return response.toString();
    }

    public static String swap(String s, int a, int b){
        StringBuilder response = new StringBuilder();
        char c1 = s.charAt(a);
        char c2 = s.charAt(b);

        for(int i=0; i<9; i++){
            if(i == a)
                response.append(c2);
            else if (i == b)
                response.append(c1);
            else
                response.append(s.charAt(i));
        }

        return response.toString();
    }

}