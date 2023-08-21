import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		
		int[] a = new int[n];
		int[] b = new int[n];
		
		String[] temp = bf.readLine().split(" ");
		
		for(int i=0; i<n; i++)
			a[i] = Integer.parseInt(temp[i]);
		Arrays.sort(a);
		
		temp = bf.readLine().split(" ");
		for(int i=0; i<n; i++)
			b[i] = Integer.parseInt(temp[i]);
		Arrays.sort(b);
		
		int answer = 0;
		for(int i=0; i<n; i++)
			answer += a[n-i-1] * b[i];
		
		System.out.println(answer);
	}

}