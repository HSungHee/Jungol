package jungol;

import java.util.Scanner;

public class Main_Language_Coder_1523 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	// 삼각형의 높이
		int type = sc.nextInt(); 	// 종류
		
		if(N>100) type = 4;	// 삼각형크기가 100보다 크다면, error 메시지 출력
		
		switch(type) {
		case 1:
			for(int i=0; i<N; i++) {
				for(int j=0; j<=i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			break;
		case 2:
			for(int i=0; i<N; i++) {
				for(int j=N; j>i; j--) {
					System.out.print("*");
				}
				System.out.println();
			}
			break;
		case 3:
			for(int i=0; i<N; i++) {
				for(int j=N-1; j>i; j--) System.out.print(" ");
				for(int j=0; j<1+2*i; j++) System.out.print("*");
				System.out.println();
			}
			break;
		default:
			System.out.println("INPUT ERROR!");
			break;
		}
		
	}

}
