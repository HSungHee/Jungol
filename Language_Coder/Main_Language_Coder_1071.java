package jungol;

import java.util.Scanner;

public class Main_Language_Coder_1071 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	// 입력받을 숫자 개수
		int[] inputs = new int[N];
		
		// N개의 숫자 입력 받기
		for(int i=0; i<N; i++) {
			inputs[i] = sc.nextInt();
		}
		
		int number = sc.nextInt();	// 찾을 정수
		
		int div = 0;	// 약수의 합
		int mul = 0;	// 배수의 합
		
		for(int i=0; i<N; i++) {
			if(number==inputs[i]) {
				div+=inputs[i];
				mul+=inputs[i];
			} else if(number%inputs[i]==0) {
				div+=inputs[i];
			} else if(inputs[i]%number==0) {
				mul+=inputs[i];
			}
		}
		System.out.println(div);
		System.out.println(mul);
	}
}
