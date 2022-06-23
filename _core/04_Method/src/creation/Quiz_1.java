package creation;

public class Quiz_1 {

	public static void main(String[] args) {
		// 랜덤으로 정수 5개를 배열에 담는 메서드
		// 그 배열을 전달 받아 평균 연산하는 메서드
		// 정수 5개와 연산 결과를 출력하는 메서드
		// main 메서드에는 어떠한 연산식도 있으면 안됨
		// 메서드간 데이터 전달 및 호출만 있어야 함
		int[] ran = random();
		double avg = average(ran);
		

	}

	

	private static double average(int[] ran) {
		double hab = 0;
		for (int i : ran) {
			hab += i;
		}
		System.out.println(" 평균 : " + (hab/ran.length));
		return  hab/ran.length;
	}

	private static int[] random() {
		int[] re = new int[5];
		System.out.print("5개의 정수 값 : ");
		for(int i=0; i < re.length; i++) {
			re[i] = (int)Math.floor(Math.random()*100 + 1);
			System.out.print(re[i]+ " ");
		}
		return re;
	}

}
