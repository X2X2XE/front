package quiz;

import java.util.Scanner;

public class Quiz3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("자릿 수 입력 >>");
		int n = sc.nextInt();
		int fibo = fibo(n);
		System.out.println(n + " 번째 자리의 피보의 값은 : " + fibo);

	}

	private static int fibo(int n) {
		int fi = 0;
		for(int i=0; i < n;i++) {
			fi = fib(i);
		}
		return fi;
	}

	private static int fib(int i) {
		if(i ==0 || i ==1) {
			return 1;
		} else {
			return fib(i-2) + fib(i-1);
		}
		
	}

}
