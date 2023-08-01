import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		boolean[] light = new boolean [n];
		
		for(int i=0; i<n; i++) {
			String temp = st.nextToken();
			if(temp.equals("1")) light[i] = true;
			else light[i] = false;
		}
		
		int students = Integer.parseInt(bf.readLine());
		for(int s=0; s<students; s++) {
			st = new StringTokenizer(bf.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int number = Integer.parseInt(st.nextToken());
			
			if (gender == 1) {
				int cnt = number;
				while(cnt <= n) {
					push(light, cnt -1);
					cnt += number;
				}
			}
			else {
				int cnt = 1;
				push(light, number-1);
				while(number + cnt <= n && number - cnt -1 >= 0 && light[number+cnt-1] == light[number-cnt-1]) {
					push(light, number+cnt-1);
					push(light, number-cnt-1);
					cnt++;
				}
			}
		}
		
		int [] rLight = new int[n];
		
		for(int i=0; i<n; i++) {
			if(light[i] == true)	rLight[i] = 1;
			else rLight[i] = 0;
		}
		for(int i=1; i<=n; i++) {
			System.out.print(rLight[i-1] + " ");
			if(i % 20 == 0) System.out.println();
		}
		
	}
	
	static void push(boolean[] l,int index) {
		if (l[index] == false)	l[index] = true;
		else l[index] = false;
	}

}


/*
 * 0 1 0 1 0 0 0 1
 * 0 1 1 1 0 1 0 1
 * 1 0 0 0 1 1 0 1
 * 
 */