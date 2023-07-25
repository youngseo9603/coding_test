import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int answer = -1;
		for(int i = Math.floorDiv(n, 5); i>=0; i--) {
			
			if ((n-5*i)%3 == 0) {
				answer = i + Math.floorDiv(n-5*i, 3);
				break;
			}
		}
		System.out.println(answer);
	}
	
}
