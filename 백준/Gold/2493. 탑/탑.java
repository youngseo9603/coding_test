import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int[] tower = new int[n];
		for(int i=0; i<n; i++) {
			tower[i] = Integer.parseInt(st.nextToken());
		}
		
		Stack< int[] > stack = new Stack<>();
		int[] answer = new int[n]; 
		for(int i=n-1; i>=0; i--) {
			
			if( stack.empty() || tower[i] < stack.peek()[1]) {
				stack.add(new int[] {i, tower[i]} );
			}
			else {
				int[] temp = stack.peek();
				
				while(!stack.isEmpty() && stack.peek()[1] < tower[i]) {
					answer[stack.pop()[0]] = temp[0];
				}
				stack.add(new int[] {i, tower[i]});
			}
			
			
		}
		
		for(int i=0; i<n; i++)
			System.out.print(answer[i] + " ");
		
		
	}

}


/* 0 
 * 6 9 5 7 4
 * 0 
 * 
 * 
 */