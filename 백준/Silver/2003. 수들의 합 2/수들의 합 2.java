import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] sumNum = new int[n+1];
		sumNum[0] = 0;
		int sum = 0;
		int answer = 0;
		
		for(int i = 0; i<n ; i++) {
			sum += sc.nextInt();
			sumNum[i+1] = sum;
		}
		
		int s = 0;
		int e = 0;
		while(s < n+1 && e < n+1) {

			if (sumNum[e] - sumNum[s] < m) {
				e++;
			}
			else if (sumNum[e] - sumNum[s] > m) {
				s++;
			}
			else {
				answer++;
				s++;
			}
		}
		
		System.out.println(answer);
	}

}

/*
1 2 3 4 2 5 3 1 1 2
1 3 6 10 12 17 20 21 22 24
se  1
  e 3
    e 6
s   e 5 answer += 1
  s e  


*/