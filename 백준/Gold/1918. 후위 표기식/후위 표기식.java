import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            char cur = s.charAt(i);
            switch(cur) {
                case '+':
                case '-':
                case '*':
                case '/':
                    while(!stack.isEmpty() && priority(stack.peek()) >= priority(cur)) {
                        sb.append(stack.pop());
                    }
                    stack.push(cur);
                    break;
                case '(':
                    stack.push(cur);
                    break;
                case ')':
                    while(!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.pop();
                    break;
                default:
                    sb.append(cur);
            }

        }

        while(!stack.isEmpty())
            sb.append(stack.pop());

        System.out.println(sb);
    }

    public static int priority(char operator){
        if(operator == '(' || operator == ')')
            return 0;
        else if (operator == '+' || operator == '-')
            return 1;
        else if (operator == '*' || operator == '/')
            return 2;
        else
            return -1;
    }
}