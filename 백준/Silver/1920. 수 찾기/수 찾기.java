import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] a = new int[n];
		
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		
		Arrays.sort(a);
		
		int m = sc.nextInt();
		int[] b = new int[m];
		
		for(int i=0; i<m; i++) {
			b[i] = sc.nextInt();
		}
		
		for (int target : b) {
			int answer = 0;
			int start = 0;
			int end = n;
			int mid = Math.floorDiv(start+end, 2);
			
			while(start < end) {
				//System.out.println(mid);
				if(a[mid] > target) {
					end = mid;
					mid = Math.floorDiv(start+end, 2);
				}
				else if(a[mid] < target) {
					start = mid+1;
					mid = Math.floorDiv(start+end, 2);
				}
				else {
					answer = 1;
					break;
				}
				
			}
			System.out.println(answer);
		}
		
		
	}
}
