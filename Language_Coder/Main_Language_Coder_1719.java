package jungol;

import java.util.Scanner;

public class Main_Language_Coder_1719 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int type = sc.nextInt();
		int mid = size/2;
		
		if(size%2==0) type=5;	// 삼각형 크기가 짝수가 입력되면 error로 처리
		
		
		switch(type) {
		case 1 :
			for(int i=0; i<size; i++) {
				if(i<=mid) {
					for(int j=0; j<=i; j++) System.out.print("*");
				} else {
					for(int j=i; j<size; j++) System.out.print("*");
				}
				System.out.println();
			}
			break;
		case 2 :
			for(int i=0; i<size; i++) {
				if(i<=mid) {
					for(int j=i; j<mid; j++) System.out.print(" ");
					for(int j=0; j<=i; j++) System.out.print("*");
				} else {
					for(int j=mid; j<i; j++) System.out.print(" ");
					for(int j=i; j<size; j++) System.out.print("*");
				}
				System.out.println();
			}
			break;
		case 3 :
			for(int i=0; i<size; i++) {
				if(i<=mid) {
					for(int j=0; j<i; j++) System.out.print(" ");
					for(int j=0; j<size-2*i; j++) System.out.print("*");
				} else {
					for(int j=i; j<size-1; j++) System.out.print(" ");
					for(int j=0; j<1+2*(i-mid); j++) System.out.print("*");
				}
				System.out.println();
			}
			break;
		case 4 :
			for(int i=0; i<size; i++) {
				if(i<=mid) {
					for(int j=0; j<i; j++) System.out.print(" ");
					for(int j=i; j<=mid; j++) System.out.print("*");
				} else {
					for(int j=0; j<mid; j++) System.out.print(" ");
					for(int j=0; j<=i-mid; j++) System.out.print("*");
				}
				System.out.println();
			}
			break;
		default :	// 짝수이거나 잘못된 종류의 값이 입력되면 error 메시지 출력
			System.out.println("INPUT ERROR!");
		}
	}

}
