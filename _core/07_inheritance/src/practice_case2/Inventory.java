package practice_case2;

public class Inventory {
	private PicaChu picachu;
	private kkobugi kkobugi;
	private Ieesanghasi ieesanghasi;
	private pielee pielee;
	private Character ch;
	
	public Character choiceCharacter(int chNum) {
		
		switch (chNum) {
		case 1:
			if(picachu == null) {
				picachu = new PicaChu();
			}
			ch = picachu;
			break;
		case 2:
			if(kkobugi == null) {
				kkobugi = new kkobugi();
			}
			ch = kkobugi;
			break;
		case 3:
			if(ieesanghasi == null) {
				ieesanghasi = new Ieesanghasi();
			}
			ch = ieesanghasi;
			break;
		case 4:
			if(pielee == null) {
				pielee = new pielee();
			}
			ch = pielee;
			break;

		default:
			System.out.println("캐릭터를 잘 못 선택하셧습니다.");
			return null;
		}
		return ch;
	}
	
	
}
