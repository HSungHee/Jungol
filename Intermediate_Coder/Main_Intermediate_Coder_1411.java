package jungol;
/**
 * f(0) : 아무것도 없는 것
 * f(1) : f(0)에다가 한칸짜리 붙이는 것
 * f(2) : 2x1짜리 세로 막대는 f(1)에다가 1개를 더 붙인 것 + 2x2짜리나 1x2짜리 가로 막대는 f(0)에다가 2개를 붙이는 것
 * 
 * 점화식 : f(n) = f(n-1) + f(n-2)*2
 */
import java.util.Scanner;

public class Main_Intermediate_Coder_1411 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] D = new long[N+1];
		
		D[0] = 1;
		D[1] = 1;
		for(int i=2; i<=N; i++) {
			D[i] = (D[i-1] + 2*D[i-2])%20100529;
		}
		System.out.println(D[N]);
	}
}
