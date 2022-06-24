package quiz;

import java.util.Scanner;

public class Quiz4 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("1. + 2. - 3. * 4. /");
		int sel = sc.nextInt();
		if(sel ==1) {
			hab();
		} else if(sel ==2) {
			sub();
		} else if(sel ==3) {
			mut();
		} else if(sel ==4) {
			div();
		}
		
		
		
	}

	private static void div() {
		System.out.println("1. 숫자 입력");
		int num =  sc.nextInt();
		System.out.println("2. 숫자 입력");
		int num2 = sc.nextInt();
		System.out.println(num + " / " + num2 + " = " + (num /num2));

		
	}

	private static void mut() {
		System.out.println("1. 숫자 입력");
		int num =  sc.nextInt();
		System.out.println("2. 숫자 입력");
		int num2 = sc.nextInt();
		System.out.println(num + " * " + num2 + " = " + (num *num2));

		
	}

	private static void sub() {
		System.out.println("1. 숫자 입력");
		int num =  sc.nextInt();
		System.out.println("2. 숫자 입력");
		int num2 = sc.nextInt();
		System.out.println(num + " - " + num2 + " = " + (num-num2));		
	}

	private static void hab() {
		System.out.println("1. 숫자 입력");
		int num =  sc.nextInt();
		System.out.println("2. 숫자 입력");
		int num2 = sc.nextInt();
		System.out.println(num + " + " + num2 + " = " + (num +num2));
		
	}

}
