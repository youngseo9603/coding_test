import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		int[][] arr = new int[n][2];
		StringTokenizer st;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(bf.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr,(x, y) -> {
			if(x[1] != y[1]) {
				return (x[1] - y[1]);
			}
			else{
				return x[0] - y[0];
			}
		});
		
		LinkedList<int[]> answer = new LinkedList<>();
		answer.add(arr[0]);
		for(int i=1; i<n; i++)
			if(arr[i][0] >= answer.get(answer.size()-1)[1])
				answer.add(arr[i]);
		
		System.out.println(answer.size());
		
		
	}
}