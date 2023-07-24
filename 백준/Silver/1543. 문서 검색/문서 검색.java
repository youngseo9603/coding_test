import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String note = new String(sc.nextLine());
		String word = new String(sc.nextLine());
		
		int answer = 0;
		int i = 0;
		while(i < note.length() - word.length()+1){
			int flag = 0;
			for(int j =0; j<word.length(); j++) {
				if (note.charAt(i+j) != word.charAt(j)) {
					flag = 1;
					break;
				}
			}
			if(flag == 0) {
				answer++;
				i += word.length();
				continue;
			}
			i++;
		}
		
		System.out.println(answer);
		
	}
}
