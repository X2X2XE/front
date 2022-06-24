package quiz;
class Ex03{
	double base = 5.0;
	double height = 3.5;
	double getArea() {
		return (base * height)/ 2;
	}
	double getHyotenuse() {
		
		return Math.sqrt((base*base)+(height*height));
	}
	double getPerimeter() {
		return base + height + getHyotenuse();
	}
}
public class Quiz6_3 {

	public static void main(String[] args) {
		Ex03 ob = new Ex03();
		System.out.printf("삼각형의넓이 : %.2f\n",ob.getArea());
		System.out.printf("빗변길이 : %.2f\n", ob.getHyotenuse());
		System.out.printf("둘레길이 : %.2f\n", ob.getPerimeter());
	}

}
