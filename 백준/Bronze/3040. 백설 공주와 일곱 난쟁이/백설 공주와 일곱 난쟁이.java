import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] n = new int[9];
		int sum = 0;
		for(int i=0; i<9; i++) {
			n[i] = sc.nextInt();
			sum += n[i];
		}
		
		int combine = 0;
			
		for(int i=0; i<9; i++) {
			for(int j=i+1; j<9; j++) {
				combine = n[i] + n[j];
				if(sum - combine == 100) {
					for(int k=0; k<9; k++) {
						if(k!=i & k!=j)	System.out.println(n[k]);
					}
					return;
				}
				
			}
		}
		
	}

}