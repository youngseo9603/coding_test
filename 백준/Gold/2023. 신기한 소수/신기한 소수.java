import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		
		int[] l = {2,3,5,7};
		
		for(int i=0; i<4; i++) 
			dfs(l[i], 1);
	}
	
	static boolean prime(int n) {
		if(n<2) return false;
		for(int i=2; i*i<=n; i++) {
			if(n%i == 0) return false;
		}
		return true;
	}
	static int[] num = {1,3,5,7,9};
	
	static void dfs(int k, int depth) {
		if(depth == n)
			System.out.println(k);
		
		for(int i=0; i<5; i++) {
			int t = 10*k + num[i];
			if(prime(t))
				dfs(t, depth+1);
		}
	}

}
/*
	10,000,000 ~ 100,000,000
	
	 2,3,5,7
	1,3,5,7,9
	1,3,5,7,9
	1,3,5,7,9

*/