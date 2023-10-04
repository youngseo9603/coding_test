import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String t = br.readLine();
		String p = br.readLine();
		int[] pi = new int[p.length()];

		int j = 0;
		for (int i = 1; i < p.length(); i++) {
			while(j>0 && p.charAt(i)!=p.charAt(j))
				j = pi[j-1];
			if(p.charAt(i)==p.charAt(j)) {
				j++;
				pi[i] = j;
			}
		}

		int answer = 0;
		ArrayList<Integer> a = new ArrayList<>();
		j = 0;
		int i = 0;

		while (i < t.length()) {
			if (t.charAt(i) != p.charAt(j)) {
				if(j==0) {
					i++;
					j = 0;
				}				
				else
					j = pi[j - 1];
			} 
			else {
				i++;
				j++;
			}
			if (j == p.length()) {
				answer++;
				a.add(i - j+1);
				j = pi[j-1];
			}
		}

		System.out.println(answer);
		StringBuilder sb = new StringBuilder();
		for (int k : a)
			
			sb.append(k).append(" ");
		System.out.println(sb);

	}
}