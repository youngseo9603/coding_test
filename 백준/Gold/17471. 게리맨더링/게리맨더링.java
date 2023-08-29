import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

public class Main {

	static int[][] map;
	static int[] visited;
	static int[] person;
	static int[] vil;
	static int n;
	static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new int[n];
		person = new int[n];
		String[] s = br.readLine().split(" ");
		for (int i = 0; i < n; i++)
			person[i] = Integer.parseInt(s[i]);
		
		vil = new int[n];
		for (int i = 0; i < n; i++)
			vil[i] = i;
		
		for (int i = 0; i < n; i++) {
			s = br.readLine().split(" ");
			for (int j = 1; j < s.length; j++)
				map[i][Integer.parseInt(s[j])-1] = 1;
		}

		

		answer = Integer.MAX_VALUE;
		divide(0);
		if(answer == Integer.MAX_VALUE)
			System.out.println(-1);
		else System.out.println(answer);

	}

	static void divide(int depth) {
		if (depth == n) {
			if (linked(vil)) {
				int g1 = 0;
				int g2 = 0;
				for (int i = 0; i < n; i++) {
					if (vil[i] == 1)
						g1 += person[i];
					else
						g2 += person[i];
				}
				answer = Math.min(answer, Math.abs(g1 - g2));
			}

			return;
		}

		vil[depth] = 1;
		divide(depth + 1);
		vil[depth] = 2;
		divide(depth + 1);

		return;
	}

	static boolean linked(int[] vil) {
		visited = new int[n];
		int[][] temp = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1) {
					if (vil[i] == 1 && vil[j] == 1)
						temp[i][j] = 1;
					if (vil[i] == 2 && vil[j] == 2)
						temp[i][j] = 2;
				}
			}
		}

//		for(int i=0; i<n; i++) {
//			for(int j=0; j<n; j++)
//				System.out.print(temp[i][j] + " ");
//			System.out.println();
//		}

		Stack<Integer> stack = new Stack<>();

		stack.add(0);
		visited[0] = vil[0];
		while (!stack.isEmpty()) {
			int t = stack.pop();
			for (int i = 0; i < n; i++) {
				if (vil[i] == vil[t] && visited[i] == 0 && temp[t][i] == vil[t]) {
					stack.add(i);
					visited[i] = vil[t];
				}
			}
		}

		stack = new Stack<>();
		int c = -1;
		for (int i = 0; i < n; i++) {
			if (vil[i] != vil[0]) {
				stack.add(i);
				visited[i] = vil[i];
				c = i;
				break;
			}
		}

		if (c == -1)
			return false;

		while (!stack.isEmpty()) {
			int t = stack.pop();
			for (int i = 0; i < n; i++) {
				if (vil[i] == vil[t] && visited[i] == 0 && temp[t][i] == vil[t]) {
					stack.add(i);
					visited[i] = vil[t];
				}
			}
		}

//		for(int i : vil)
//			System.out.print(i + " ");
//		System.out.println();
//		for(int i : visited)
//			System.out.print(i + " ");
//		System.out.println();
		for (int i : visited)
			if (i == 0)
				return false;

		return true;
	}
}