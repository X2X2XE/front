package quiz;
class Student {
	String name ="";
	String clas = "";
	int num = (int)Math.floor(Math.random()*100);
	int kor = (int)Math.floor(Math.random()*100);
	int eng = (int)Math.floor(Math.random()*100);
	int math = (int)Math.floor(Math.random()*100);
	double getTotal() {
		return (kor + eng + math);
	}
	double getAvg() {
		return getTotal()/3;
	}
}
public class Quiz6_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
