import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int testCase=0; testCase<t; testCase++){
            int n = sc.nextInt();
            int m = sc.nextInt();

            long answer = 1;

            for(int i=0; i<n; i++){
                answer = answer*(m-i)/(i+1);
            }
            System.out.println(answer);
        }
    }
}
