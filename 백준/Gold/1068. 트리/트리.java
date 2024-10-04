import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static class Node {
        int index;
        int parent;
        ArrayList<Integer> child;

        Node(int index, int parent) {
            this.index = index;
            this.parent = parent;
            this.child = new ArrayList<>();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Node[] nodes = new Node[n];

        int root = -1;
        for(int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(i, temp);
        }
        for(int i = 0; i < n; i++) {
            if(nodes[i].parent != -1){
                nodes[nodes[i].parent].child.add(i);
            }
            else{
                root = i;
            }
        }

        int num = Integer.parseInt(br.readLine());
        int answer = 0;
        Stack<Node> stack = new Stack<>();
        if(num != root)
            stack.add(nodes[root]);

        while(!stack.isEmpty()) {
            Node node = stack.pop();

            int childCnt = 0;
            for(int c : node.child) {
                if(c != num){
                    stack.add(nodes[c]);
                    childCnt++;
                }
            }
            if(childCnt == 0) {
                answer++;
            }

        }

        System.out.println(answer);

    }
}