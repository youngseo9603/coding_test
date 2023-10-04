import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String bomb = br.readLine();
		Stack<Character> stack = new Stack<>();
		for(int i=0; i<s.length(); i++) {
			stack.add(s.charAt(i));
			if(stack.size() >= bomb.length()) {
				boolean flag = true;
				for(int j=0; j<bomb.length(); j++) {
					if(!(bomb.charAt(j) == stack.get(stack.size() - bomb.length() + j))) {
						flag = false;
					}
				}
				
				if(flag) {
					for(int j=0; j<bomb.length(); j++)
						stack.pop();
				}	
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<stack.size(); i++)
			sb.append(stack.get(i));
		if(sb.toString().equals(""))
			System.out.println("FRULA");
		else System.out.println(sb);

	}

}