import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = bf.readLine().split("");
		
		Stack<String> stack = new Stack<>();
		
//		int a = 0;
//		int b = 0;
//		for(int i=0; i<arr.length; i++) {
//			if(arr[i].equals("(")) {
//				stack.push(arr[i]);
//				a++;
//			}
//			else if(arr[i].equals("[")) {
//				stack.push(arr[i]);
//				b++;
//			}
//			if(arr[i].equals(")")) {
//				if(stack.peek().equals("[")) {
//					System.out.println(0);
//					return;
//				}
//				else if(!stack.peek().equals("(")){
//					
//					while(!stack.peek().equals("(")) {
//						int temp = Integer.parseInt(stack.pop());
//					}
//					a++;
//				}
//				a--;
//			}
//			
//			
//		}
		
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i].equals("(")) {
				stack.add("(");
			}
			else if (arr[i].equals("[")) {
				stack.add("[");
			}
//			else if(stack.empty()) {
//				System.out.println(0);
//				return;
//			}
			else if (arr[i].equals(")") || arr[i].equals("]") ) {
				int n = 0;
				
				if(stack.empty()) {
					System.out.println(0);
					return;
				}
					
				String temp = stack.pop();
				
				while(!(temp.equals("(") || temp.equals("["))) {
					n += Integer.parseInt(temp);
					
					if(stack.empty()) {
						System.out.println(0);
						return;
					}
					temp = stack.pop();
				}
				
				if(n==0)
					n=1;
				
				if(arr[i].equals(")") && temp.equals("(")) 
					stack.add(Integer.toString(2*n));
				else if (arr[i].equals("]") && temp.equals("["))
					stack.add(Integer.toString(3*n));
				else if ( (arr[i].equals(")") && temp.equals("[")) || (arr[i].equals("]") && temp.equals("(")) || arr[i].equals(temp)) {
					System.out.println(0);
					return;
				}
				
			}
			else {
				System.out.println(0);
				return;
			}
		}
		
		
		int answer = 0;
		for(int i=0; i<stack.size(); i++) {
			if(stack.get(i).equals("(") || stack.get(i).equals("[")) {
				System.out.println(0);
				return;
			}
			else	answer += Integer.parseInt(stack.get(i));
		}
		System.out.println(answer);
	}

}


/*
	(()[[()]])([])
	(
	( (
	( 2
	( 2 [
	( 2 [ [
	( 2 [ [ (
	( 2 [ [ 2
	( 2 [ 3 
	( 2 [ 3
	( 2 9
	( 11
	2 11
	
	
*/