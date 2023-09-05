import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<t; tc++) {
			int n = Integer.parseInt(br.readLine());
			String[] mbti = br.readLine().split(" ");
			int cnt = 0;
			
			if(n<=32) {
				int answer = Integer.MAX_VALUE;
				for(int i=0; i<n-2; i++) {
					for(int j=i+1; j<n-1; j++) {
						for(int z=j+1; z<n; z++) {
							cnt = 0;
							for(int k=0; k<4; k++) {
								if(mbti[i].charAt(k) != mbti[j].charAt(k))
									cnt++;
								if(mbti[i].charAt(k) != mbti[z].charAt(k))
									cnt++;
								if(mbti[z].charAt(k) != mbti[j].charAt(k))
									cnt++;
							}
							answer = Math.min(answer, cnt);
						}
					}
				}
				System.out.println(answer);
			}
			
			else
				System.out.println(0);
			
		}
	}

}