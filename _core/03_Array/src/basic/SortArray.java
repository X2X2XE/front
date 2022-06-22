package basic;

public class SortArray {

	public static void main(String[] args) {
		int[] intArr = new int[12];
		int[] intArr2 = new int[12];
		int a = 0;
		//intArr에 랜덤 정수를 넣고 순차정렬과 역정렬을 구현해 보세요
		for(int i=0; i < intArr.length;i++) {
			intArr[i] = (int)(Math.random()*100) + 1;
		}
		// 순차 정렬
		for(int i=1; i < intArr.length;i++) {
			
			for(int j =0; j <i; j++) {
				if(intArr[i] < intArr[j]) {
					a = intArr[i];
					intArr[i] = intArr[j];
					intArr[j] = a;
				}
			}	
		}
		
		System.out.print("[");
		for(int i=0; i < intArr.length; i++) {
			if(i == intArr.length-1) {
				System.out.println(intArr[i]+"]");
				break;
			}
			System.out.print(intArr[i]+", ");
		}
		
		
		// 역순 정렬
		for(int i=intArr.length-1; i > 1;i--) {
			
			for(int j =0; j < i; j++) {
				if(intArr[i] > intArr[j]) {
					a = intArr[i];
					intArr[i] = intArr[j];
					intArr[j] = a;
				}
			}
		}

		System.out.print("[");
		for(int i=0; i < intArr.length; i++) {
			if(i == intArr.length-1) {
				System.out.println(intArr[i]+"]");
				break;
			}
			System.out.print(intArr[i]+", ");
		}
	}

}
