import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayList<Integer>[] list;

        for(int t=1; t<=10; t++){
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            list = new ArrayList[101];
            for(int i=0; i<101; i++)
            	list[i] = new ArrayList<>();
            
            st = new StringTokenizer(br.readLine());
            for(int i=0; 2*i<l; i++){
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                
                list[from].add(to);
            }
            
            int[] visited = new int[101];
            int[] depth = new int[101];
            Queue<Integer> q = new LinkedList<>();
            q.add(start);
            visited[start] = 1;
            int max_depth = 0;
            
            while(!q.isEmpty()) {
            	int temp = q.poll();
            	for(int n : list[temp]) {
            		if (visited[n] == 0) {
            			q.add(n);
            			visited[n] = 1;
            			depth[n] =depth[temp]+1;
            			max_depth = Math.max(max_depth, depth[n]);
            		}
            	}
            }
            
            int answer = 0;
            for(int i=0; i<101; i++) {
            	if(max_depth == depth[i]) {
            		answer = i;
            	}
            }
            StringBuilder sb = new StringBuilder();
            sb.append("#" + t + " " + answer);
            System.out.println(sb);
        }

    }

}