import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) 
			arr[i] = Integer.parseInt(s[i]);
		
		
		ArrayList<Integer>[] dp_ASC = new ArrayList[n];
		ArrayList<Integer>[] dp_DESC = new ArrayList[n];
		
		for(int i=0; i<n; i++) {
			dp_ASC[i] = new ArrayList<>();
			dp_DESC[i] = new ArrayList<>();
		}
		
		dp_ASC[0].add(arr[0]);
		dp_DESC[n-1].add(arr[n-1]);
		for(int i=1; i<n; i++) {
			for(int j=0; j<i; j++) {
				if(dp_ASC[j].get(dp_ASC[j].size()-1) < arr[i]) {
					if(dp_ASC[i].size() < dp_ASC[j].size() + 1) {
						dp_ASC[i] = new ArrayList<>();
						for(int k=0; k<dp_ASC[j].size(); k++) {
							dp_ASC[i].add(dp_ASC[j].get(k));
						}
						dp_ASC[i].add(arr[i]);
					}	
				}
				
				if(dp_DESC[n-1-j].get(dp_DESC[n-1-j].size()-1) < arr[n-1-i]) {
					if(dp_DESC[n-1-i].size() < dp_DESC[n-1-j].size() + 1) {
						dp_DESC[n-1-i] = new ArrayList<>();
						for(int k=0; k<dp_DESC[n-1-j].size(); k++) {
							dp_DESC[n-1-i].add(dp_DESC[n-1-j].get(k));
						}
						dp_DESC[n-1-i].add(arr[n-1-i]);
					}	
				}
			}
			if(dp_ASC[i].size()==0)
				dp_ASC[i].add(arr[i]);
			if(dp_DESC[n-1-i].size()==0)
				dp_DESC[n-1-i].add(arr[n-1-i]);
		}
		
		int answer = 0;
		for(int i=0; i<n; i++) {
			answer = Math.max(answer, dp_DESC[i].size() + dp_ASC[i].size() - 1);
		}
		
		System.out.println(answer);
		
	}

}