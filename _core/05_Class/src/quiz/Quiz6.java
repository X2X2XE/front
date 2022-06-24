package quiz;

import java.util.Scanner;

public class Quiz6 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int[] num_arr = insert();
		System.out.println("1. +, 2. -, 3. *, 4. /");
		int sel = sc.nextInt();
		switch (sel) {
		case 1:
			hab(num_arr);
			break;
		case 2:
			sub(num_arr);
			break;
		case 3:
			mut(num_arr);
			break;
		case 4:
			div(num_arr);
			break;
		default:
			break;
		}
		
		
		
		
	}

	private static int[] insert() {
		int[] num = new int[2];
		for(int i =0; i < num.length ; i++) {
			System.out.println((i+1) + ". 숫자입력");
			num[i] = sc.nextInt();
		}
		return num;
	}

	private static void div(int[] num) {
		
		System.out.println(num[0] + " / " + num[1] + " = " + (num[0] /num[1]));

		
	}

	private static void mut(int[] num) {
		
		System.out.println(num[0] + " * " + num[1] + " = " + (num[0] *num[1]));

		
	}

	private static void sub(int[] num) {
		
		System.out.println(num[0] + " - " + num[1] + " = " + (num[0] -num[1]));
	}

	private static void hab(int[] num) {
		
		System.out.println(num[0] + " + " + num[1] + " = " + (num[0] +num[1]));
		
	}

}
