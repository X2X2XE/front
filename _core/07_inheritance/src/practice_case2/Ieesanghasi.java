package practice_case2;

public class Ieesanghasi extends Character {

	public Ieesanghasi() {//피카츄 생성자
		hp +=130;//체력 초기화
		mp += 20;//마나 초기화
		setHp(hp);
		setMp(mp);
		System.out.println("이상해씨 생성~ 이상 이상~");
		printStatus(); //상태정보 출력
	}
	
	
	
	
	@Override
	public void eat() {
		mp += 10;
		setMp(mp);

	}

	@Override
	public void sleep() {
		mp += 20;
		setMp(mp);

	}

	@Override
	public void play() {
		mp -= 20;
		hp += 5;
		setHp(hp);
		setMp(mp);

	}

	@Override
	public boolean train() {
		mp -= 10;
		hp += 10;
		levelUp();
		setMp(mp);
		setHp(hp);
		setLevel(level);
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
