package quiz;
class Ex06 {
	final double PI = 3.141593;
	double area(int a) {
		return (a*a*PI);
	}
	double area(int a, int b) {
		return (double)(a*b);
	}
	double area (int a, int b, int c) {
		return ((a+b)*c) /2 ;
	}
}
public class Quiz6_6 {
	public static void main(String[] args) {
		Ex06 start = new Ex06();
		System.out.println("원의넓이 : " + start.area(3));
		System.out.println("사각형의넓이 : " +start.area(4,5));
		System.out.println("사다리꼴의 넓이 : " +start.area(3,4,7));
	}
}
