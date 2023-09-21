import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		Stack<int[]> stack = new Stack<>();
		stack.add(new int[] {b,0});
		
		int answer = 1;
		while(!stack.isEmpty()) {
			int[] temp = stack.pop();
			if(temp[0] < a) {
				break;
			}
			else if (temp[0] == a) {
				answer = temp[1]+1;
				break;
			}
				
				
			if(temp[0]%10 == 1)
				stack.add(new int[] {(temp[0]-1)/10, temp[1]+1});
			else if(temp[0]%2 == 0)
				stack.add(new int[] {temp[0]/2, temp[1]+1});
		}
		
		if(answer == 1)
			System.out.println(-1);
		else
			System.out.println(answer);
		
	}
}