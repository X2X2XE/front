package set;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class SetEx1 {

	public static void main(String[] args) {
		Set set = new HashSet();
		random_go(set);

	}

	private static void random_go(Set set) {
		int cnt =0;
		while(true) {
			Random ran = new Random();
			int random = ran.nextInt(10)+1;
			set.add(random);
			cnt++;
			if(set.size() == 10) {
				break;
			}
		}
		System.out.println(set);
		System.out.println("돈 횟수 : " + cnt);
		
	}

}
