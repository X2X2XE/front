package practice_case1;

public class pielee extends Character {

	public pielee() {//피카츄 생성자
		hp +=70;//체력 초기화
		mp += 80;//마나 초기화
		
		System.out.println("파이리 생성~ 파일 파일~");
		printStatus(); //상태정보 출력
	}
	
	
	
	
	@Override
	public void eat() {
		mp += 10;
		

	}

	@Override
	public void sleep() {
		mp += 20;
		
	}

	@Override
	public void play() {
		mp -= 20;
		hp += 5;

	}

	@Override
	public boolean train() {
		mp -= 10;
		hp += 10;
		levelUp();
		return checkMp();
	}

	@Override
	public void levelUp() {
		if(hp >= 40) {
			hp -= 40;
			level++;
		}

	}

}
