package practice_case1;

public abstract class Character {
	protected int hp ;
	protected int mp ;
	protected int level ;
	
	public abstract void eat();
	public abstract void sleep();
	public abstract void play();
	public abstract boolean train();
	public abstract void levelUp();
	
	
	//마나 사용 조건 체크
	public boolean checkMp() {
		return mp <= 0 ? true : false;
	}
	// 캐릭터 상태 출력 메서드
	public void printStatus() {
		System.out.println("현재 캐릭터의 상태....");
		System.out.println("HP : " + hp);
		System.out.println("Mp : " + mp);
		System.out.println("Level : " + level);
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getMp() {
		return mp;
	}
	public void setMp(int mp) {
		this.mp = mp;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public void contunue_state(int[] state) {
		hp += state[0];
		mp += state[1];
		level += state[2];
		
	}
	
	
	
	
}
