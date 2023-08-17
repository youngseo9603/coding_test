import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		
		int stick = 64;
		int cnt = 0;
		while(x != 0) {
			if (x<stick) {
				stick /= 2;
			}
			else{
				x -= stick;
				cnt++;
			}
		}
		
		System.out.println(cnt);

	}
}


/*
	64	32	16	8	4	2	1
	23
	
	
	
*/