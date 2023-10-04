import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		System.out.println(pow(a,b,c));
	}
	
	static long pow(int a, int b, int c) {
		
		if(b==0)
			return 1;
		
		long n = pow(a,b/2,c);
		if(b%2 == 0)
			return n*n % c;
		else
			return (n*n%c)*a%c;
	}

}