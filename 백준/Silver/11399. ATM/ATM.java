import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] nums = new int[n];
		String a = br.readLine();
		StringTokenizer st = new StringTokenizer(a);
		
		for(int i=0; i<n; i++)
			nums[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(nums);
		int numSum = 0;
		
		for(int i=1; i<n; i++) {
			nums[i] += nums[i-1];
		}
		
		for(int i=0; i<n; i++) {
			numSum += nums[i];
		}
		
		System.out.println(numSum);
		
	}
}

