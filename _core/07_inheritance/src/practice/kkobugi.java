package practice;

public class kkobugi extends Character {

	public kkobugi() {
		hp +=80;//체력 초기화
		mp += 70;//마나 초기화
		System.out.println("꼬부기 생성~ 꼬북~ 꼬북~");
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
