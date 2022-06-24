package quiz;

import java.util.Arrays;
import java.util.Scanner;

class potion {
	
	public potion() {
		super();
		// TODO Auto-generated constructor stub
	}

	String[] item = {"healing", "mana", "stamina"};
}
class weapon {
	String[] item = {"sword", "bow", "axe"};
}
class ammor {
	String[] item = {"helmet", "armor", "gloves"};
}
class item {
	String[] item;
	void setItem(String[] item){
		this.item = new String[item.length];
		for(int i =0; i < item.length; i++) {
			this.item[i] = item[i];
		}
	}
	void viewItem() {
		for (String i : item) {
			System.out.print(i+ " ");
		}
	}
	String getItem(int a) {
		return Integer.toString(a);
	}
}
public class Quiz6_5 {

	public static void main(String[] args) {
		String[] item_arr = new String[100];
		potion po = new potion();
		weapon we = new weapon();
		ammor am = new ammor();
		item user = new item();
		Scanner sc = new Scanner(System.in);
		int count =0;
		for(int i=0;;i++) {
		System.out.println("1: 아이템 리스트, 2: 아이템 구입, 3: 종료");
		int sel = sc.nextInt();
		if(sel== 1) {
			System.out.println("1: 포션상점, 2: 무기점, 3:방어구점");
			int sele = sc.nextInt();
			if(sele ==1) {
				for (String it : po.item) {
					System.out.print(it+" ");
				}
				System.out.println("");
			} else if(sele == 2){
				for (String it : we.item) {
					System.out.print(it+" ");
				}
				System.out.println("");
			} else if(sele == 3){
				for (String it : am.item) {
					System.out.print(it+" ");
				}
				System.out.println("");
			}
			
		} else if (sel ==2) {
			System.out.println("1: 포션상점, 2: 무기점, 3:방어구점");
			int sele = sc.nextInt();
			if(sele ==1) {
				for (String it : po.item) {
					System.out.print(it+" ");
				}
				System.out.println("");
				System.out.println("구입하고자하는 아이템을 입력하세요 >>");
				String item_name = sc.next();
				item_arr[count] = item_name;
				System.out.println(item_name+ "을 구입햇습니다");
				count++;
				
			} else if(sele == 2){
				for (String it : we.item) {
					System.out.print(it+" ");
				}
				System.out.println("");
				System.out.println("구입하고자하는 아이템을 입력하세요 >>");
				String item_name = sc.next();
				item_arr[count] = item_name;
				System.out.println(item_name+ "을 구입햇습니다");
				count++;
			} else if(sele == 3){
				for (String it : am.item) {
					System.out.print(it+" ");
				}
				System.out.println("");
				System.out.println("구입하고자하는 아이템을 입력하세요 >>");
				String item_name = sc.next();
				item_arr[count] = item_name;
				System.out.println(item_name+ "을 구입햇습니다");
				count++;
			} 
		}else if(sel ==3) {
			int che = nullcheck(item_arr);
			System.out.println(che);
			String[] copy = copy(item_arr,che);
			user.setItem(copy);
			user.viewItem();
			System.out.println("총 " + (count) + "번 구매 햇습니다");
			break;
		}
		
		}
		
	}

	private static String[] copy(String[] item_arr, int che) {
		String[] co = new String[che];
		for(int i=0; i< che; i++) {
			co[i] = item_arr[i];
		}
		return co;
	}

	private static int nullcheck(String[] item_arr) {
		int no_nul = 0;
		for(int i=0; i<item_arr.length; i++) {
			if(item_arr[i] != null) {
				no_nul = (i+1);	
			}
		}
		
		return no_nul;
	}

	

}
