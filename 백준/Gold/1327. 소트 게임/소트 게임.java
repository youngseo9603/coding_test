import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;

public class Main {

    static int[] num;
    static HashMap<String, Boolean> visited;
    static int k;
    static int n;
    static int answer;

    public static class Node{
        int cnt;
        String str;

        Node(int cnt, String str){
            this.cnt = cnt;
            this.str = str;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        num = new int[n];
        visited = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            num[i] = Integer.parseInt(st.nextToken());

        answer = -1;

        bfs(num);

        System.out.println(answer);


    }

    public static void bfs(int[] arr){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, arrayToString(arr)));
        visited.put(arrayToString(arr), true);

        while(!queue.isEmpty()){
            Node n = queue.poll();
            int[] temp = stringToArray(n.str);

            if(isAsc(temp)){
                answer = n.cnt;
                break;
            }

            int[][] request = swap(temp);
            for(int i=0; i<request.length; i++){
                if(!visited.getOrDefault(arrayToString(request[i]), false)) {
                    queue.add(new Node(n.cnt+1, arrayToString(request[i])));
                    visited.put(arrayToString(request[i]), true);
                }
            }
        }

    }

    public static int[][] swap(int[] map){
        int[][] response = new int[n-k+1][n];

        for(int i=0; i<n-k+1; i++){
            response[i] = Arrays.copyOf(map, n);
            for(int j=0; j<k/2; j++){
                int temp = map[i+j];
                response[i][j+i] = map[i+k-j-1];
                response[i][i+k-j-1] = temp;
            }
        }

        return response;
    }

    public static boolean isAsc(int[] num){
        for(int i=1; i<num.length; i++)
            if(num[i-1] >= num[i])
                return false;
        return true;
    }

    public static String arrayToString(int[] arr){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr.length; i++)
            sb.append(arr[i]);
        return sb.toString();
    }

    public static int[] stringToArray(String s){
        int[] response = new int[s.length()];
        for(int i=0; i<s.length(); i++){
            response[i] = Character.getNumericValue(s.charAt(i));
        }
        return  response;
    }



}