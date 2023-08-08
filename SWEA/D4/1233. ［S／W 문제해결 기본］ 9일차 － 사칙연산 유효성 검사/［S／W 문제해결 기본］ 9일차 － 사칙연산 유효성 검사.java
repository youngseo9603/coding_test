import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		for(int test=0; test<10; test++) {
			int n = Integer.parseInt(bf.readLine());
			
			String[] inputArr = new String[n];
			int[] arr = new int[n];
			boolean flag = true;
			
			for(int i=0; i<n; i++)	inputArr[i] = bf.readLine();
			
			for(int i=n; i>0; i--) {
				String[] temp = inputArr[i-1].split(" ");
				
				if(temp[1].equals("*") && temp.length == 4) {
					arr[i-1] = Integer.parseInt(temp[2]) * Integer.parseInt(temp[3]);
				}
				else if(temp[1].equals("/") && temp.length == 4) {
					arr[i-1] = Integer.parseInt(temp[2]) / Integer.parseInt(temp[3]);
				}
				else if(temp[1].equals("-") && temp.length == 4) {
					arr[i-1] = Integer.parseInt(temp[2]) - Integer.parseInt(temp[3]);
				}
				else if(temp[1].equals("+") && temp.length == 4) {
					arr[i-1] = Integer.parseInt(temp[2]) + Integer.parseInt(temp[3]);
				}
				else if(temp[1].charAt(0) >= 48 && temp[1].charAt(0) <= 57 && temp.length == 2) {
					arr[i-1] = Integer.parseInt(temp[1]);
				}
				else {
					flag = false;
					break;
				}
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test+1).append(" ");
			if(!flag)
				sb.append(0);
			else
				sb.append(1);
			System.out.println(sb);
			
		}
	}

}
