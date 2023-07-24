import java.util.*;

public class Main {
	public static void main(String[] args) {
		int x = 1;
		
		while(x<=10000) {
			int flag = 0;
			
			for (int i=0; i<x; i++) {
				int sum = i;
				int temp = i;
				
				while(temp != 0) {
					sum += temp%10;
					temp /= 10;
				}
				if(sum == x) {
					flag = 1;
					
					break;
				}
				
			}
			
			if(flag == 0) {
				System.out.println(x);
			}
			x++;
		}
	}
}
